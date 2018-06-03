package org.lang.scala.conclusion.nio.selector

import java.net.InetSocketAddress
import java.nio.channels.SelectionKey
import java.nio.channels.Selector
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel

import scala.collection.JavaConversions.asScalaSet

/**
 * 	This is a stand-alone object to test selector
 * 	-- Selector is basically used with non-blocking mode, since:
 *     -- Any operation (that corresponds to in-coming requests) that fits our interest will be selected, processed accordingly and returned with a response/result by selector
 *     -- Hence the communication between client and server does not need to keep waiting actively
 * 
 * 	@author VinceYuan
 */
object TestSelector {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testSelector()
  }
  
  /**
   * 	This is a method to test selector
   * 	-- To do the test:
   *     -- Execute this method firstly
   *     -- Execute the main method under "~/util/TestingClient" then
   */
  private def testSelector(): Unit = {
    
    /*	Open a selector	 */
    val selector = Selector.open()
    
    /*	Open a server socket channel	*/
    val serverSocketChannel = ServerSocketChannel.open()
    
    try {
      /*	Configure server socket channel: bind to which address, blocking or not, etc.	*/
      serverSocketChannel.bind(new InetSocketAddress("localhost", 8500))
      serverSocketChannel.configureBlocking(false)
      
      /*	Information regarding selection keys	*/
      val ops = SelectionKey.OP_ACCEPT | SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE
      println(s"SelectionKey - OP_ACCEPT: ${SelectionKey.OP_ACCEPT}")        // 16
      println(s"SelectionKey - OP_CONNECT: ${SelectionKey.OP_CONNECT}")      // 8
      println(s"SelectionKey - OP_READ: ${SelectionKey.OP_READ}")            // 1
      println(s"SelectionKey - OP_WRITE: ${SelectionKey.OP_WRITE}")          // 4
      println(s"SelectionKey - all op: ${ops}")                              // 29
      /*
       * 	If register(selector, ops), an illegal argument exception will be thrown out
       */
      val selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT)   
      
      /*	Operations regarding selection keys	 */
      val interestOps = selectionKey.interestOps()
      println(s"Interesting operations: ${interestOps}")
      val readyOps = selectionKey.readyOps()
      println(s"Ready operations: ${readyOps}")
      
      /*
       *	Select a set of keys (which can be retrieved by "selector.selectedKeys") whose corresponding channels are ready for I/O operations
       *  -- This is a blocking method
       */
      val numOfSelectedKeys = selector.select()
      println(s"\nSelect: ${numOfSelectedKeys}")
      while (numOfSelectedKeys > 0) {
        /*	Get all selected keys	 */
        val selectedKeys = selector.selectedKeys()
        /*	Just the information for validation of number of selected keys	*/
        if (numOfSelectedKeys.equals(selectedKeys.size())) {
          println(s"Number of selected keys: ${numOfSelectedKeys}")
        }
        /*	Process the keys corresponding to channels accordingly	*/
        selectedKeys.foreach { currentSelectedKey => {
          if (currentSelectedKey.isAcceptable()) { 
            println("Channel is acceptable...")
            val socketChannel = serverSocketChannel.accept()
            println(s"Accept client ${socketChannel.socket().getInetAddress.getHostAddress}...")
          }
          if (currentSelectedKey.isConnectable()) { 
            println("Channel is connectable...") 
          }
          if (currentSelectedKey.isReadable()) { 
            println("Channel is readable...")
            val socketChannel = currentSelectedKey.channel().asInstanceOf[SocketChannel]
          }
          if (currentSelectedKey.isWritable()) { 
            println("Channel is writable...")
            val socketChannel = currentSelectedKey.channel().asInstanceOf[SocketChannel]
          }
          selectedKeys.remove(currentSelectedKey)
        } }
      }
    } catch {
      case t: Throwable => t.printStackTrace()
    } finally {
      serverSocketChannel.close()
      selector.close()
    }
  }
}