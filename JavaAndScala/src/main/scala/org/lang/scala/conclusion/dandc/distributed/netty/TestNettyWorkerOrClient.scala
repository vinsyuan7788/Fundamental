package org.lang.scala.conclusion.dandc.distributed.netty

import org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat.WorkerStarter

/**
 * 	This is a stand-alone object to test starting Netty workers or clients
 * 
 * 	@author VinceYuan
 */
object TestNettyWorkerOrClient {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    WorkerStarter.main(args)
  }
}