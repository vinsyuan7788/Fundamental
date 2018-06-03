package org.lang.scala.conclusion.nio.channel.tcp

import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel

import scala.io.StdIn

/**
 * 	This is a stand-alone object to test socket channel for TCP protocol
 * 
 * 	@author VinceYuan
 */
object TestSocketChannel {
  
  /**
   * 	This is a main method for execution
   * 	-- Make sure only 1 method is being test once at a time
   */
  def main(args: Array[String]): Unit = {
//    testReadFromSocketChannelWithBlockingModeAndRemoteServer()
//    testReadFromSocketChannelWithBlockingModeAndLocalServer()
    testWriteToSocketChannelWithBlockingModeAndLocalServer()
  }
  
  /**
   * 	This is a method to test reading from socket channel with blocking mode and remote server
   * 	-- To do the test, open a Linux server "192.168.2.130" and open a port 8500 (by using net-cat, namely "nc -lk 8500")
   *  -- When the port is closed, this program is terminated automatically
   *  -- Data from remote (Linux) server ---> channel on local (Windows) server that connects remote server --- (read) ---> buffer --- (flip) --- (get) ---> data read
   */
  private def testReadFromSocketChannelWithBlockingModeAndRemoteServer(): Unit = {
    
    /*	Open a socket channel	 */
    val socketChannel = SocketChannel.open()
    
    /*	Configure the socket channel: connect to which address, blocking or not, etc.	 */
    socketChannel.connect(new InetSocketAddress("192.168.2.130", 8500))
    socketChannel.configureBlocking(true)
    
    /*	Allocate a byte buffer to stored read data	*/
    val byteBuffer = ByteBuffer.allocate(128)
    
    /*	Clear the buffer	*/
    byteBuffer.clear()
    
    /*	Read data from socket channel to byte buffer	*/
    var bytesRead = socketChannel.read(byteBuffer)
    /*	While there are data read	 */
    while (bytesRead != -1) {
      /*	Flip the byte buffer from write mode to read mode	 */
      byteBuffer.flip()
      /*	While there are data remaining in the byte buffer	 */
      while (byteBuffer.hasRemaining()) {
        /*	Display the data read from socket channel to the console	*/
        print(s"${byteBuffer.get.asInstanceOf[Char]}") 
      }
      /*	Clear the byte buffer	 */
      byteBuffer.clear()
      /*	Read from channel to byte buffer again: at this point byte buffer becomes write mode	*/
      bytesRead = socketChannel.read(byteBuffer)
    }
    
    /*	Close necessary resources	 */
    socketChannel.close()
  }
  
  /**
   * 	This is a method to test reading from socket channel with blocking mode and local server
   * 	-- To do the test
   *     -- Execute "testWriteOnServerSocketChannelWithBlockingMode" method in "TestServerSocketChannel" object under current package
   *     -- Execute this method then: can execute this method multiple times
   */
  private def testReadFromSocketChannelWithBlockingModeAndLocalServer(): Unit = {
    
    /*	Open a socket channel	 */
    val socketChannel = SocketChannel.open()
    
    /*	Configure the socket channel: connect to which address, blocking or not, etc.	 */
    socketChannel.connect(new InetSocketAddress("localhost", 8500))
    socketChannel.configureBlocking(true)
    
    /*	Allocate a byte buffer to stored read data	*/
    val byteBuffer = ByteBuffer.allocate(128)
    
    /*	Clear the buffer	*/
    byteBuffer.clear()
    
    /*	Read data from socket channel to byte buffer	*/
    var bytesRead = socketChannel.read(byteBuffer)
    /*	While there are data read	 */
    while (bytesRead != -1) {
      /*	Flip the byte buffer from write mode to read mode	 */
      byteBuffer.flip()
      /*	Information from socket channel for display on the console	*/
      println("Socket channel:")
      /*	While there are data remaining in the byte buffer	 */
      while (byteBuffer.hasRemaining()) {
        /*	Display the data read from socket channel to the console	*/
        print(s"${byteBuffer.get.asInstanceOf[Char]}") 
      }
      /*	Clear the byte buffer	 */
      byteBuffer.clear()
      /*	Read from channel to byte buffer again: at this point byte buffer becomes write mode	*/
      bytesRead = socketChannel.read(byteBuffer)
    }
    
    /*	Close necessary resources	 */
    socketChannel.close()
  }
  
  /**
   * 	This is a method to test writing to socket channel with blocking mode and local server
   * 	-- To do the test:
   *     -- Execute the "testReadOnServerSocketChannelWithBlockingMode" method in "TestServerSocketChannel" object under current package firstly
   *     -- Execute this method then: can execute this method multiple times
   */
  private def testWriteToSocketChannelWithBlockingModeAndLocalServer(): Unit = {
    
    /*	Open a socket channel that connects to an address	 */
    val socketChannel = SocketChannel.open()
    
    /*	Configure socket channel: connect to which address, blocking or not, etc.	*/
    socketChannel.connect(new InetSocketAddress("localhost", 8500))
    socketChannel.configureBlocking(true)
    
    /*	The data that will be sent	*/
    val data = "This is a request from socket channel at " + System.currentTimeMillis()
    
    /*	Allocate a byte buffer	*/
    val byteBuffer = ByteBuffer.allocate(128)
    
    /*	
     * 	Manipulate the buffer necessarily
     * 	-- Clear the buffer
     * 	-- Put data into the buffer
     * 	-- Flip the buffer to switch it from read mode to write mode 
     */
    byteBuffer.clear()
    byteBuffer.put(data.getBytes)
    byteBuffer.flip()
    
    /*	Write data to the socket channel	*/
    while (byteBuffer.hasRemaining()) {
      socketChannel.write(byteBuffer)
    }
    
    /*	Close necessary resources	 */
    socketChannel.close()
  }
}