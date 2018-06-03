package org.lang.scala.conclusion.network.tcp.scenario.download.server

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.ServerSocket
import java.net.Socket

/**
 * 	This is a companion class to implement a TCP (multi-threaded) server: 
 *  -- TCP server can be both sender and receiver
 * 	-- "\r\n" is necessary for the line recognition of client: to make "readLine()" work
 * 	-- Flush the stream to make sure the data written to buffer are transmitted if using character stream
 * 	
 * 	@author VinceYuan
 */
class FileServer private(

    val socket: Socket
    
) extends Thread {
  
  /**
   * 	This is an overridden method to inform the thread what needs to be done
   */
  override def run() = {
    
    /*	Initialize necessary null references	*/
    var socketReader: BufferedReader = null
    var socketWriter: BufferedWriter = null
    var keyboardReader: BufferedReader = null
    
    try {
      /*	Initiate character stream for socket communication  	*/
			socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
			socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
			
			/*	Initiate character stream for keyboard input	*/
			keyboardReader = new BufferedReader(new InputStreamReader(System.in))
			
			/*	Socket communication	*/
			var line: String = null
			do {
				line = socketReader.readLine()
				println("File name from client " + socket.getInetAddress().getHostAddress() + ":\n" + line)
				println("Please reply with the file name:")
				line = keyboardReader.readLine()
				socketWriter.write(line + "\r\n")
				socketWriter.flush()
			  println()
			} while (line != null)
    } catch {
      case t: Throwable => {
        println(s"Client ${socket.getInetAddress.getHostAddress} disconnected...")
      }
    } finally {
      /*	Close necessary resources	 */
      if (socketReader != null) socketReader.close()
      if (socketWriter != null) socketWriter.close()
      if (keyboardReader != null) keyboardReader.close()
      if (socket != null) socket.close()
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
   * 	This is a method to start a TCP server
   */
  def startServer(port: Int) = {
    
    /*	Initialize necessary null references	*/
    var serverSocket: ServerSocket = null
    
    try {      
      /*	Set up a TCP server  */
      serverSocket = new ServerSocket(port)
      
      /*	Forever loop to accept in-coming requests	 */
      while (true) {
        
        /*	
         * 	Wait until an incoming request is accepted and return the corresponding socket
         * 	-- This method is a blocking method: wait until accepting an incoming request
         */
        val incomingSocket = serverSocket.accept()
        
        /*	Open a new server thread to process the request from client	 */
  			new FileServer(incomingSocket).start()
      }
    } catch {
      case t: Throwable => t.printStackTrace()
    } finally {
      /*	Close necessary resources  */
      if (serverSocket != null) serverSocket.close()    
    }
  }
}