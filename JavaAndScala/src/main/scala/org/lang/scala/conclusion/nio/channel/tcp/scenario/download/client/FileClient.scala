package org.lang.scala.conclusion.nio.channel.tcp.scenario.download.client

import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.SocketChannel

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
 * 	This is a stand-alone object to implement a TCP client
 * 
 * 	@author VinceYuan
 */
object FileClient {
 
  /**
   * 	This is a method to start a client
   */
  def startClient(host: String, port: Int): Unit = {
  
    /*	Initialize necessary resources	*/
    val byteBuffer = ByteBuffer.allocate(1024)
    val charListBuffer = ListBuffer[Char]()
    
    /*	Get information from console input	*/
    println("Please input the name the file you want to download:")
    var fileName = StdIn.readLine()
      
    /*	While fileName is not null	*/
    while (fileName != null) {
      
      /*	Open a socket channel	 */
      val socketChannel = SocketChannel.open()

      try {     
        /*	Configure the socket channel: connect to which address, blocking or not	 */
        socketChannel.connect(new InetSocketAddress(host, port))
        socketChannel.configureBlocking(true)
        
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

        /*	NECESSARY here: to shutdown the writing to the channel and prepare the subsequent reading from channel	*/
        socketChannel.shutdownOutput()
        
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
        
        /*	Predicate if the accepted file name is the same as the file name input from console	 */
        if (charListBuffer.mkString("").equals(fileName)) {
          println("Donwload " + fileName + " successfully from server " + host + "\n")
        } else {
          println("Fail to download " + fileName + " from " + host + "\n")
        }
      } catch {
        case t: Throwable => {
          println(s"Server ${host} disconnected...")
        }
      } finally {
        /*	Close necessary resources	 */
        socketChannel.close()
      }
      
      /*	Get information from console input again	*/
      println("Please input the name the file you want to download:")
      fileName = StdIn.readLine()
    }
  }
}