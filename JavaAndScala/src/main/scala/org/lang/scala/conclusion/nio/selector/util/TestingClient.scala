package org.lang.scala.conclusion.nio.selector.util

import java.net.InetSocketAddress
import java.nio.channels.SocketChannel

/**
 * 	This is a stand-alone object to implement a testing client for selector
 * 	-- Selector is basically used with non-blocking mode
 *     -- Reason refers to "~/../TestSelector.scala" file
 * 
 * 	@author VinceYuan
 */
object TestingClient {
  
  /**
   * 	THis is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    startClient("localhost", 8500)
  }
  
  /**
   * 	This is a method to start a client
   */
  private def startClient(host: String, port: Int): Unit = {
    
    /*	Open a socket channel	 */
    val socketChannel = SocketChannel.open()
        
    try {
      /*	Configure socket channel: connect to which address, blocking or not, etc.	 */
      socketChannel.connect(new InetSocketAddress(host, port))
      socketChannel.configureBlocking(false)
    } catch {
      case t: Throwable => {
        println(s"Server ${host} disconnected...")
      }
    } finally {
      /*	Close necessary resources	 */
      socketChannel.close()
    }
  }
}