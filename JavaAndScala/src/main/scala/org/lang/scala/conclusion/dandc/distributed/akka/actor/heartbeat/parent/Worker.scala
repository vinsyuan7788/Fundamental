package org.lang.scala.conclusion.dandc.distributed.akka.actor.heartbeat.parent

import java.util.UUID
import java.util.concurrent.atomic.AtomicBoolean

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt

import org.lang.scala.conclusion.dandc.distributed.akka.actor.heartbeat.parent.traits.MasterRetriever
import org.lang.scala.conclusion.dandc.distributed.akka.common.cases.HeartBeatInfo
import org.lang.scala.conclusion.dandc.distributed.akka.common.cases.SendHeartBeat
import org.lang.scala.conclusion.dandc.distributed.akka.common.cases.WorkerRegistInfo
import org.lang.scala.conclusion.dandc.distributed.akka.common.cases.WorkerRegistered

import akka.actor.Actor
import akka.actor.ActorSelection
import akka.actor.ActorSelection.toScala

/**
 * 	This is a stand-alone class to implement Akka actor
 * 
 * 	@author VinceYuan
 */
abstract class Worker(
    
    /*	Necessary instance variables for primary constructors	 */
    val masterHost: String, 
    val masterPort: Int,
    val workerHost: String,
    val workerPort: Int, 
    val totalCores: Int,
    val totalMemSize: Long
    
) extends Actor with MasterRetriever {
  
  /*	Necessary instance variables	*/
  private var masterRef: ActorSelection = _
  private var masterId: String = _
  private var masterUrl: String = _
  private val workerId = UUID.randomUUID().toString()
  private val heartBeatIntervalInSec = 5
  private var registered = new AtomicBoolean(false)
  
  /*	A message to inform Actor constructor is invoked	*/
  println("Worker actor constructor is invoked...")
  
  /**
   * 	This is a method to be invoked after actor instance construction before actor actually receives message
   * 	-- Print out a message
   *  -- If first-time connecting to master:
   *     -- Find (or select) the master and connect to it
   *     -- Send registration information to the master
   */
  override def preStart(): Unit = {
    println("Worker actor \"preStart\" is invoked...")
    if (masterRef == null) {
      masterRef = context.actorSelection(s"akka.tcp://MasterSystem@${masterHost}:${masterPort}/user/${getMasterClassName}")
      masterRef ! WorkerRegistInfo(workerId, masterHost, masterPort, workerHost, workerPort, totalCores, totalMemSize)
    }
  }
  
  /**
   * 	Override this method to process message
   */
  override def receive: Receive = {
    
    /*
     * 	When receives the reply from master:
     *  -- Print out a message
     *  -- Send a heart-beat signal to the worker itself PERIODICALLY for heart-beat check
     *     -- The reason why sending signal to itself is that worker CANNOT obtain the master's actor reference when using "schedule" method
     *     -- Hence sending a signal to itself, then send another one to master
     */
    case WorkerRegistered(masterId, masterUrl) => {
      this.masterId = masterId
      this.masterUrl = masterUrl
      if (this.registered.compareAndSet(false, true)) println(s"Connect and register to master actor successfully at ${masterUrl}? ${this.registered.get}")
      context.system.scheduler.schedule(0 milliseconds, heartBeatIntervalInSec seconds, self, SendHeartBeat)
    }
    
    /*
     *	When receives the heart-beat signal from worker itself PERIODICALLY:
     *  -- Process some business logics:
     *     -- E.g., if totalMemSize < 512 (MB), then no need to send heart-beat message, etc.
     *  -- Send a heart-beat message to master with necessary information 
     */
    case SendHeartBeat => {
      // Can process some business logic here...
      // Then send a heart-beat message to master for heart-beat check
      masterRef ! HeartBeatInfo(workerId)
    }
  }
  
  /**
   * 	This is a method to be invoked after actor receives message before Actor instance destruction
   */
  override def postStop(): Unit = {
    println("Worker actor \"postStop\" is invoked...")
  }
}