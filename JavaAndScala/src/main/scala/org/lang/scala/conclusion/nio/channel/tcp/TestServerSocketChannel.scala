package org.lang.scala.conclusion.nio.channel.tcp

import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel

/**
 * 	This is a stand-alone object to test server socket channel
 * 
 * 	@author VinceYuan
 */
object TestServerSocketChannel {
  
  /*	Necessary instance variables	*/
  private var charArr = Array[Char]()
  
  /**
   * 	This is a main method for execution
   * 	-- Make sure only 1 method is being test once at a time
   */
  def main(args: Array[String]): Unit = {
//    testReadOnServerSocketChannelWithBlockingMode()
//    testWriteOnServerSocketChannelWithBlockingMode()
    testSelectOperationOnServerSocketWithNonBlockingMode()
  }
  
  /**
   * 	This is a method to test reading data on server socket channel
   * 	-- To do the test:
   *     -- Execute this method firstly
   *     -- Then execute the "testWriteToSocketChannelWithBlockingModeAndLocalServer" method in "TestSocketChannel" object under current package: can execute it multiple times
   */
  private def testReadOnServerSocketChannelWithBlockingMode(): Unit = {
    
    /*	Open a serve socket channel	 */
    val serverSocketChannel = ServerSocketChannel.open()
    
    /*	Configure the server socket channel: bind to which address, blocking or not, etc.	*/
    serverSocketChannel.bind(new InetSocketAddress("localhost", 8500))
    serverSocketChannel.configureBlocking(true)
    
    /*	Initialize a socket channel that is newly coming	*/
    var socketChannel: SocketChannel = null
    
    try {     
      /*	Loop forever to accept newly coming socket channel	*/
      while (true) {
        /*	Accept the newly coming socket channel and return it if there is any	*/
        socketChannel = serverSocketChannel.accept()     
        /*	If it is not null	 */
        if (socketChannel != null) {         
          /*	Allocate a byte buffer	*/
          val byteBuffer = ByteBuffer.allocate(128)
          /*	Clear the buffer	*/
          byteBuffer.clear()
          /*	Information from server socket channel for display on the console	 */
          println("Server socket channel:") 
          /*	Read the data from the newly coming socket channel to buffer	*/
          var bytesRead = socketChannel.read(byteBuffer)        
          /*	While there is any data read	*/
          while (bytesRead != -1) {          
            /*	Flip the buffer to switch from write mode to read mode	*/
            byteBuffer.flip()                  
            /*	While there is buffer remaining	 */
            while (byteBuffer.hasRemaining()) {             
              /*	Get the data from the buffer and save them into an array	*/
              charArr = charArr :+ byteBuffer.get.asInstanceOf[Char]
            }                   
            /*	Clear the buffer	*/
            byteBuffer.clear()   
            /*	Read the data from the newly coming socket channel again	*/ 
            bytesRead = socketChannel.read(byteBuffer) 
          }
          /*	Print the array and reset it	*/
          println(s"${charArr.mkString("")}")
          charArr = Array[Char]()
        }
      }  
    } catch {
      case t: Throwable => {
        /*	Print information if there is any exception caught	*/
        println("\nClient disconnected...")
      }
    } finally {
      /*	Close necessary resources	 */
      socketChannel.close()
      serverSocketChannel.close()
    }
  }
  
  /**
   * 	This is a method to test writing on server socket channel with blocking mode
   * 	-- To do the test:
   *     -- Execute this method firstly
   *     -- Execute "testReadFromSocketChannelWithBlockingModeAndLocalServer" method in "TestSocketChannel" object under current package: can execute it multiple times
   */
  private def testWriteOnServerSocketChannelWithBlockingMode(): Unit = {
    
    /*	Open a serve socket channel	 */
    val serverSocketChannel = ServerSocketChannel.open()
    
    /*	Configure the server socket channel: bind to which address, blocking or not, etc.	*/
    serverSocketChannel.bind(new InetSocketAddress("localhost", 8500))
    serverSocketChannel.configureBlocking(true)
    
    /*	Initialize a socket channel that is newly coming	*/
    var socketChannel: SocketChannel = null
    
    try {      
      /*	Loop forever to accept newly coming socket channel	*/
      while (true) { 
        /*	Accept the newly coming socket channel and return it if there is any	*/
        socketChannel = serverSocketChannel.accept()       
        /*	If it is not null	 */
        if (socketChannel != null) {
          /*	Data that will be written to the socket channel	 */
          val data = "This is a response from server socket channel at " + System.currentTimeMillis() 
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
          /*	Write the buffer back to the newly coming socket channel	*/
          while (byteBuffer.hasRemaining()) {
            socketChannel.write(byteBuffer)
          }
        }
      }  
    } catch {
      case t: Throwable => {
        /*	Print information if there is any exception caught	*/
        println("\nSystem disconnected...")
      }
    } finally {
      /*	Close necessary resources	 */
      socketChannel.close()
      serverSocketChannel.close()
    }
  }
  
  /**
   * 	This is a method to test selecting operation on server socket with non-blocking mode
   * 	-- This is left to be done in the future: implementation can refer to "~/../selector" package
   */
  private def testSelectOperationOnServerSocketWithNonBlockingMode(): Unit = {
    
  }
}