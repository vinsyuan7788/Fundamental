package org.lang.scala.conclusion.network.tcp.scenario.download.client

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.InetAddress
import java.net.Socket

/**
 * 	This is a stand-alone object to implement a TCP client: 
 *  -- TCP client can be both sender and receiver
 * 	-- "\r\n" is necessary for the line recognition of server: to make "readLine()" work
 * 	-- Flush the stream to make sure the data written to buffer are transmitted if using character stream
 * 
 * 	@author VinceYuan
 */
object FileClient {
  
  /**
   * 	This is a method to start a TCP client
   */
  def startClient(serverAddress: InetAddress, port: Int) = {
    
    /*	Initialize necessary null references	*/
    var socket: Socket = null
    var socketWriter: BufferedWriter = null
    var socketReader: BufferedReader = null
    var keyboardReader: BufferedReader = null
    
    try {
      /*	Set up a TCP client	 */
      socket = new Socket(serverAddress, port)
      
      /*	Initiate character stream for socket communication  	*/
		  socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
		  socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
			
			/*	Initiate character stream for keyboard input	*/
			keyboardReader = new BufferedReader(new InputStreamReader(System.in))
			
			/*	Socket communication:	 */
			var fileName: String = null
			do {
				println("Please input the name the file you want to download:")
				fileName = keyboardReader.readLine()
				socketWriter.write(fileName + "\r\n")
				socketWriter.flush();
				if (socketReader.readLine().equals(fileName)) {
					println("Donwload " + fileName + " successfully from server " + serverAddress.getHostAddress() + "\n")
				} else {
					println("Fail to download " + fileName + " from " + serverAddress.getHostAddress() + "\n")
				}
			} while (fileName != null)			  
    } catch {
      case t: Throwable => {
        println(s"Server ${serverAddress.getHostAddress} disconnected...")
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