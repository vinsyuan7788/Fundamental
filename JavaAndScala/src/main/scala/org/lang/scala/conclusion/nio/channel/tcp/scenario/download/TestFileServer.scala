package org.lang.scala.conclusion.nio.channel.tcp.scenario.download

import org.lang.scala.conclusion.nio.channel.tcp.scenario.download.server.FileServer

/**
 * 	This is a stand-alone object to test TCP server
 *  -- To see the test effect: run the server first, then run the client
 *     -- Can run the client multiple times: to start multiple clients to connect this server
 * 
 * 	@author VinceYuan
 */
object TestFileServer {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    FileServer.startServer("localhost", 8500)
  }
}