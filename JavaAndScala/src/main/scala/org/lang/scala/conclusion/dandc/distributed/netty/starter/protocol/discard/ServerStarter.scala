package org.lang.scala.conclusion.dandc.distributed.netty.starter.protocol.discard

import org.lang.scala.conclusion.dandc.distributed.netty.starter.protocol.discard.server.Server

/**
 * 	This is a stand-alone object to start servers
 * 
 * 	@author VinceYuan
 */
object ServerStarter {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    new Server().start()
  }
}