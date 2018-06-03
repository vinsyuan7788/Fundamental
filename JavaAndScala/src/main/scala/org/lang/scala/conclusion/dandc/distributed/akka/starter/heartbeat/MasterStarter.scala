package org.lang.scala.conclusion.dandc.distributed.akka.starter.heartbeat

import org.lang.scala.conclusion.dandc.distributed.akka.actor.heartbeat.ActiveMaster

import akka.actor.actorRef2Scala

/**
 * 	This is a stand-alone object to start masters
 * 
 * 	@author VinceYuan
 */
object MasterStarter {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    
    val activeMaster = ActiveMaster("localhost", 8888)
    activeMaster ! "test"    // Master sends a message "test" to itself
    ActiveMaster.whenTerminated()
  }
}