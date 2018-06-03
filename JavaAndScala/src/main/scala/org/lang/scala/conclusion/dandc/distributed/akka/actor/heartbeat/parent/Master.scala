package org.lang.scala.conclusion.dandc.distributed.akka.actor.heartbeat.parent

import java.util.UUID

import scala.annotation.migration
import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt

import org.lang.scala.conclusion.dandc.distributed.akka.actor.heartbeat.parent.traits.MasterRetriever
import org.lang.scala.conclusion.dandc.distributed.akka.common.cases.HeartBeatInfo
import org.lang.scala.conclusion.dandc.distributed.akka.common.cases.SendTimeout
import org.lang.scala.conclusion.dandc.distributed.akka.common.cases.WorkerRegistInfo
import org.lang.scala.conclusion.dandc.distributed.akka.common.cases.WorkerRegistered
import org.lang.scala.conclusion.dandc.distributed.akka.common.classes.WorkerInfo

import akka.actor.Actor
import akka.actor.actorRef2Scala

/**
 * 	This is a stand-alone class to implement Akka actor
 * 
 * 	@author VinceYuan
 */
abstract class Master(

    /*	Necessary instance variables for primary constructors	 */
    val masterHost: String, 
    val masterPort: Int

) extends Actor with MasterRetriever {
  
  /*	A message to inform Actor constructor is invoked	*/
  println("Master actor constructor is invoked...")
  
  /*	Necessary instance variables	*/
  private val masterId = UUID.randomUUID().toString()
  private val masterUrl = s"akka.tcp://MasterSystem@${masterHost}:${masterPort}/user/${getMasterClassName}"
  private val workerHeartBeatTimeoutInSec = 10
  private val workerMap = new HashMap[String, WorkerInfo]()
  private val workerSet = new HashSet[WorkerInfo]()
  
  /**
   * 	This is a method to be invoked after actor instance construction before actor actually receives message
   *  -- Print out a message
   *  -- Send a check-if-worker-is-time-out signal to master itself PERIODICALLY
   */
  override def preStart(): Unit = {
    println("Master actor \"preStart\" is invoked...")
    context.system.scheduler.schedule(0 microsecond, workerHeartBeatTimeoutInSec seconds, self, SendTimeout)
  }
  
  /**
   * 	Override this method to process message
   */
  override def receive: Receive = {
    
    /*
     *  When receives registration information from worker:
     *  -- If the worker exists, then do nothing
     *  -- If the worker does not exist, then store the worker information and reply to the worker with some information
     */
    case WorkerRegistInfo(workerId, masterHost, masterPort, workerHost, workerPort, totalCores, totalMemSize) => {
      println("A worker actor is connected...")
      workerMap.get(workerId) match {
        case Some(_) => {
          // Do nothing if the worker exists
        }
        case None => {
          val workerInfo = new WorkerInfo(workerId, masterHost, masterPort, workerHost, workerPort, totalCores, totalMemSize)
          workerMap(workerId) = workerInfo
          workerSet += workerInfo
          sender ! WorkerRegistered(masterId, masterUrl)
        }
      }
    }
    
    /*
     * 	When receives the heart-beat message from worker:
     *  -- Record current heart-beat time if the worker exists
     */
    case HeartBeatInfo(workerId) => {
      if (workerMap.contains(workerId)) {
        val workerInfo = workerMap(workerId)
        workerInfo.lastHeartBeatTime = System.currentTimeMillis()
      }
    }
    
    /*
     * 	When receives a check-if-worker-is-timeout signal from master itself PERIODICALLY
     *  -- Remove the information of time-out workers from master
     *  -- Print those workers that are still alive
     */
    case SendTimeout => {
      val currentTime = System.currentTimeMillis()
      workerSet.filter { workerInfo => (currentTime - workerInfo.lastHeartBeatTime) > workerHeartBeatTimeoutInSec * 1000 }
        .map { workerInfo => { workerMap -= workerInfo.workerId; workerSet -= workerInfo } }
      println("Live workers:\n" + workerSet.mkString("\n"))
    }
    
    /*
     * 	When receives a test message, print out a message
     */
    case "test" => println("Test succeeds! Can connect to master actor...")
  }
  
  /**
   * 	This is a method to be invoked after actor receives message before Actor instance destruction
   */
  override def postStop(): Unit = {
    println("Master actor \"postStop\" is invoked...")
  }
}