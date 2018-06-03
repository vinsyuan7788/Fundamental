package com.java.se.conclusion.network.tcp.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 	This is a class to implement TCP (multi-threaded) server: 
 *  -- TCP server can be both sender and receiver
 * 	-- "\r\n" is necessary for the line recognition of client: to make "readLine()" work
 * 	-- Flush the stream to make sure the data written to buffer are transmitted if using character stream
 * 	
 * @author VinceYuan
 *
 */
public class FileServer extends Thread {

	/*	Instance variables	*/
	private Socket socket;
	
	/*	Constructors	*/
	private FileServer(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {

		try {
			/*	Initiate character stream for socket communication  	*/
			BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			/*	Initiate character stream for keyboard input	*/
			BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));
			
			/*	Socket communication	*/
			String line = null;
			do {
				line = socketReader.readLine();
				System.out.println("File name from client " + socket.getInetAddress().getHostAddress() + ": " + line);
				System.out.println("Please reply with the file name:");
				line = keyboardReader.readLine();
				socketWriter.write(line + "\r\n");
				socketWriter.flush();
				System.out.println();
			} while (line != null);
			
			/*	Close the socket: release the occupied port	 */
			socket.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 	This is a method to start a TCP server
	 */
	public static void startServer(int port) {
		
		/*	Set up a TCP server  */
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			
			/*	Forever loop to listen to the request	*/
			while (true) {
			
				/*	Wait to accept the data from client	 */
				Socket socket = serverSocket.accept();
				
				/*	Open a new server thread to process the request from client	 */
				new FileServer(socket).start();	
			}
			
			/*	Close the server socket: release the occupied port	*/
//			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
