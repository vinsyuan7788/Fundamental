package com.java.se.conclusion.network.tcp.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 	This is a class to implement TCP client: 
 *  -- TCP client can be both sender and receiver
 * 	-- "\r\n" is necessary for the line recognition of server: to make "readLine()" work
 * 	-- Flush the stream to make sure the data written to buffer are transmitted if using character stream
 * 
 * @author VinceYuan
 *
 */
public class FileClient {

	/**
	 * 	This is a method to start a TCP client
	 */
	public static void startClient(InetAddress serverAddress, int port) {

		/*	Set up a TCP client	 */
		try (Socket socket = new Socket(serverAddress, port)) {
			
			/*	Initiate character stream for socket communication  	*/
			BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			/*	Initiate character stream for keyboard input	*/
			BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));
			
			/*	Socket communication	*/
			String line = null;
			do {
				System.out.println("Please input the name the file you want to download:");
				line = keyboardReader.readLine();
				socketWriter.write(line + "\r\n");
				socketWriter.flush();
				if (socketReader.readLine().equals(line)) {
					System.out.println("\nDonwload " + line + " successfully from server " + serverAddress.getHostAddress());
				} else {
					System.out.println("\nFail to download " + line + " from " + serverAddress.getHostAddress());
				}
			} while (line != null);
			
			/*	Close the socket: release the occupied port   */
//			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
