package org.lang.scala.conclusion.nio.channel.tcp.scenario.download.server

import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
 * 	This is a companion class to implement a TCP (multi-threaded) server
 * 
 * 	@author VinceYuan
 */
class FileServer private(

    val socketChannel: SocketChannel
    
) extends Thread {
  
  /**
   * 	This is an overridden method to inform the thread what needs to be done
   */
  override def run() = {
    
    /*	Initialize necessary resources	*/
    val byteBuffer = ByteBuffer.allocate(1024)
    val charListBuffer = ListBuffer[Char]()
  
    try {     
      /**  Read: data ---> channel --- (read) ---> buffer --- (flip) --- (get) ---> list buffer  **/
      /*
       * 	Below is the standard steps for data reading
       */
      byteBuffer.clear()
      var bytesRead = socketChannel.read(byteBuffer)
      while (bytesRead != -1) {
        byteBuffer.flip()
        while (byteBuffer.hasRemaining()) {
          charListBuffer += byteBuffer.get.asInstanceOf[Char]
        }
        byteBuffer.clear()
        bytesRead = socketChannel.read(byteBuffer) 
      }
      
      /*	NECESSARY here: to shutdown the reading from the channel and prepare the subsequent writing to channel	*/
      socketChannel.shutdownInput()
      
      /*	Print necessary information	 */
      println(s"File name from client ${socketChannel.socket().getInetAddress.getHostAddress}:\n${charListBuffer.mkString("")}")
      
      /*	Get the file name from console input	*/
      println("Please reply with the file name:")
      val fileName = StdIn.readLine()
      
      /**	 Write:	data --- (put) ---> buffer --- (channel.write) ---> channel  **/
      /*
       * 	Below is the standard steps for data writing
       */
      byteBuffer.clear()
      byteBuffer.put(fileName.getBytes)
      byteBuffer.flip()
      while (byteBuffer.hasRemaining()) {
        socketChannel.write(byteBuffer)
      }
    } catch {
      case t: Throwable => {
        println(s"Client ${socketChannel.socket().getInetAddress.getHostAddress} disconnected...")
      }
    } finally {
      /*	Close necessary resources	 */
      socketChannel.close()
    }
  }
}

/**
 * 	This is a companion object to start a TCP server
 * 
 * 	@author VinceYuan
 */
object FileServer {
  
  /**
   * 	This is a method to start a server
   */
  def startServer(host: String, port: Int) = {
    
    /*	Open a server socket channel	*/
    val serverSocketChannel = ServerSocketChannel.open()
    
    /*	Configure the server socket channel: bind to which address, blocking or not	*/
    serverSocketChannel.bind(new InetSocketAddress(host, port))
    serverSocketChannel.configureBlocking(true)
    
    /*	Initialize necessary null references	*/
    var socketChannel: SocketChannel = null
    
    try {
      /*	Loop forever to accept newly-coming or in-coming request	*/
      while (true) {
        
        /*	Accept the in-coming request and return the corresponding socket channel	*/
        socketChannel = serverSocketChannel.accept()
        
        /*	Start a new thread to process the in-coming request	 */
        if (socketChannel != null) new FileServer(socketChannel).start()
      }
    } catch {
      case t: Throwable => t.printStackTrace()
    } finally {
      /*	Close necessary resources	 */
      serverSocketChannel.close()
    }
  }
}