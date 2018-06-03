package org.lang.scala.conclusion.dandc.distributed.akka.actor.heartbeat

import org.lang.scala.conclusion.dandc.distributed.akka.actor.heartbeat.parent.Master

import com.typesafe.config.ConfigFactory

import akka.actor.ActorSystem
import akka.actor.Props

/**
 * 	This is a companion class to start a master
 * 
 * 	@author VinceYuan
 */
class ActiveMaster(

    /*	Necessary instance variables for primary constructors	 */
    override val masterHost: String, 
    override val masterPort: Int

) extends Master(masterHost, masterPort) {
  
  /**
   * 	This is a method to get master class name
   */
  override def getMasterClassName(): String = classOf[ActiveMaster].getSimpleName
}

/**
 * 	This is a companion object to to start a master
 *  -- Actor instance is created by ActorSystem instance
 *     -- ActorSystem is responsible for managing and monitoring actors
 *     -- ActorSystem is singleton
 * 
 * 	@author VinceYuan
 */
object ActiveMaster {
  
  /*	Necessary instance variables	*/
  var actorSys: ActorSystem = _
  
  /**
   * 	This is a method to create an Actor instance
   */
  def apply(host: String, port: Int) = {
    
    /*	Get an ActorSystem instance from configuration	*/
    val configStr = 
      s"""
        |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
        |akka.remote.netty.tcp.hostname = "$host"
        |akka.remote.netty.tcp.port = "$port"
      """.stripMargin
    if (actorSys == null) {
      actorSys = ActorSystem("MasterSystem", ConfigFactory.parseString(configStr))
    }
    
    /*	Create an Actor instance from ActorSystem instance	*/
    val masterProps = Props(classOf[ActiveMaster], host, port)
    actorSys.actorOf(masterProps, "ActiveMaster")
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