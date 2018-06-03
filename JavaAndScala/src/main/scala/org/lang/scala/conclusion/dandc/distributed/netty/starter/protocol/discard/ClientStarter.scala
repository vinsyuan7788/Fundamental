package org.lang.scala.conclusion.dandc.distributed.netty.starter.protocol.discard

import org.lang.scala.conclusion.dandc.distributed.netty.starter.protocol.discard.client.Client

/**
 * 	This is a stand-alone object to start clients
 * 
 * 	@author VinceYuan
 */
object ClientStarter {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    new Client().start()
  }
}