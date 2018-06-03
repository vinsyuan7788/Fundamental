package org.lang.scala.conclusion.dandc.distributed.akka.actor.heartbeat

import org.lang.scala.conclusion.dandc.distributed.akka.actor.heartbeat.parent.Worker

import com.typesafe.config.ConfigFactory

import akka.actor.ActorSystem
import akka.actor.Props

/**
 * 	This is a companion class to start a worker
 * 
 * 	@author VinceYuan
 */
class WorkerOne(
    
    /*	Necessary instance variables for primary constructors	 */
    override val masterHost: String, 
    override val masterPort: Int,
    override val workerHost: String,
    override val workerPort: Int, 
    override val totalCores: Int,
    override val totalMemSize: Long
    
) extends Worker(masterHost, masterPort, workerHost, workerPort, totalCores, totalMemSize) {
  
  /**
   * 	This is a method to get master class name
   */
  override def getMasterClassName(): String = classOf[ActiveMaster].getSimpleName
}

/**
 * 	This is a companion object to start a worker
 *  -- Actor instance is created by ActorSystem instance
 *     -- ActorSystem is responsible for managing and monitoring actors
 *     -- ActorSystem is singleton
 * 
 * 	@author VinceYuan
 */
object WorkerOne {
  
  /*	Necessary instance variables	*/
  var actorSys: ActorSystem = _
  
  /**
   * 	This is a method to create an Actor instance
   */
  def apply(workerHost: String, workerPort: Int, masterHost: String, masterPort: Int) = {
    
    /*	Get an ActorSystem instance from configuration	*/
    val configStr = 
      s"""
        |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
        |akka.remote.netty.tcp.hostname = "$workerHost"
        |akka.remote.netty.tcp.port = "$workerPort"
      """.stripMargin
    if (actorSys == null) {
      actorSys = ActorSystem("WorkerSystem", ConfigFactory.parseString(configStr))
    }
    
    /*	Create an Actor instance from ActorSystem instance	*/
    val totalCores = 8
    val totalMemSize = 8192l
    val workerProps = Props(classOf[WorkerOne], masterHost, masterPort, workerHost, workerPort, totalCores, totalMemSize)
    actorSys.actorOf(workerProps, "WorkerOne")
  }
  
  /**
   * 	This is a method to have actor instance await termination
   */
  def whenTerminated() = {
    if (actorSys != null) {
      actorSys.whenTerminated.isCompleted
    }
  }
}