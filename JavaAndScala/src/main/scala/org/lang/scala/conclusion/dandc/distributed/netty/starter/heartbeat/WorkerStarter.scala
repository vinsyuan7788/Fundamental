package org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat

import org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat.worker.WorkerOne

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
    WorkerOne.main(args)
  }
}