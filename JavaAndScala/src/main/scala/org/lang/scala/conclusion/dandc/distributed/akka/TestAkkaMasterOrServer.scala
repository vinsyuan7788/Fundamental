package org.lang.scala.conclusion.dandc.distributed.akka

import org.lang.scala.conclusion.dandc.distributed.akka.starter.heartbeat.MasterStarter

/**
 * 	This is a stand-alone object to test starting Akka masters or servers
 * 
 * 	@author VinceYuan
 */
object TestAkkaMasterOrServer {
    
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    MasterStarter.main(args)
  }
}