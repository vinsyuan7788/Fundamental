package org.lang.scala.conclusion.dandc.distributed.akka

import org.lang.scala.conclusion.dandc.distributed.akka.starter.heartbeat.WorkerStarter

/**
 * 	This is a stand-alone object to test starting Akka workers or clients
 * 
 * 	@author VinceYuan
 */
object TestAkkaWorkerOrClient {

  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    WorkerStarter.main(args)
  }
}