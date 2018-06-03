package org.lang.scala.conclusion.dandc.distributed.akka.starter.heartbeat

import org.lang.scala.conclusion.dandc.distributed.akka.actor.heartbeat.WorkerOne
import org.lang.scala.conclusion.dandc.distributed.akka.actor.heartbeat.WorkerTwo

/**
 * 	This is a stand-alone object to start workers
 * 
 * 	@author VinceYuan
 */
object WorkerStarter {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    
    val workerOne = WorkerOne("localhost", 9999, "localhost", 8888)
    WorkerOne.whenTerminated()
    
    Thread.sleep(10000)    // Wait for 10 seconds
    
    val workerTwo = WorkerTwo("localhost", 7777, "localhost", 8888)
    WorkerTwo.whenTerminated()
  }
}