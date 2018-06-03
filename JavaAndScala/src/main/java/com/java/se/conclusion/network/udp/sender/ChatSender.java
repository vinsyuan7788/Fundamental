package com.java.se.conclusion.network.udp.sender;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 	This is a class to implement UDP (multi-threaded) sender
 * 
 * @author VinceYuan
 *
 */
public class ChatSender extends Thread {

	/*	Necessary instance variables	*/
	private InetAddress serverAddress;
	private Integer port;
	
	/*	Constructors	*/
	private ChatSender(InetAddress serverAddress, Integer port) {
		this.serverAddress = serverAddress;
		this.port = port;
	}
	
	@Override
	public void run() {
		
		/*	Set up an UDP socket	 */
		try (DatagramSocket datagramSocket = new DatagramSocket()) {
			
			/*	Initialize character stream to accept data from keyboard	*/
			BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));
			
			/*	Send the data to receiver	*/
			String line = null;
			DatagramPacket datagramPacket;
			System.out.println("Welcome to " + serverAddress.getHostAddress() + "! You can start group chat now.");
			do {
				line = keyboardReader.readLine();
				datagramPacket = new DatagramPacket(line.getBytes(), line.getBytes().length, serverAddress, port);
				datagramSocket.send(datagramPacket);
			} while (line != null);
			
			/*	Close the socket: release the occupied port	 */
//			datagramSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 	This is a method to start a sender
	 * @param serverAddress
	 * @param port
	 */
	public static void startSender(InetAddress serverAddress, int port) {
		new ChatSender(serverAddress, port).start();
	}
}
