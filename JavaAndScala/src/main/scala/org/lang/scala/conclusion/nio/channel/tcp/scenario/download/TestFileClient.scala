package org.lang.scala.conclusion.nio.channel.tcp.scenario.download

import org.lang.scala.conclusion.nio.channel.tcp.scenario.download.client.FileClient

/**
 * 	This is a stand-alone object to test TCP client
 *  -- To see the test effect: run the server first, then run the client
 *     -- Can run this client multiple times: to start multiple clients to connect the server
 *  
 * 	@author VinceYuan
 */
object TestFileClient {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    FileClient.startClient("localhost", 8500)
  }
}