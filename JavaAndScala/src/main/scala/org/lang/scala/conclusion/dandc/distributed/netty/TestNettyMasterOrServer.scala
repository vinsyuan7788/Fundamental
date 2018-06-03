package org.lang.scala.conclusion.dandc.distributed.netty

import org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat.MasterStarter

/**
 * 	This is a stand-alone object to test starting Netty masters or servers
 * 
 * 	@author VinceYuan
 */
object TestNettyMasterOrServer {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    MasterStarter.main(args)
  }
}