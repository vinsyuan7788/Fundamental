package org.lang.scala.conclusion.dandc.distributed.netty.starter.protocol.echo

import org.lang.scala.conclusion.dandc.distributed.netty.starter.protocol.echo.client.Client

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