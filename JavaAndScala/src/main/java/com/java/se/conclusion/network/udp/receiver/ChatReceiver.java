package com.java.se.conclusion.network.udp.receiver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 	This is a class to implement UDP (multi-threaded) receiver
 * 
 * @author VinceYuan
 *
 */
public class ChatReceiver extends Thread {
	
	/*	Necessary instance variables	*/
	private Integer port;
	
	/*	Constructors	*/
	private ChatReceiver(Integer port) {
		this.port = port;
	}

	@Override
	public void run() {
		
		/*	Set up an UDP socket	 */
		try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
			
			/*	Initiate an data-gram packet to receive the data	*/
			byte[] buff = new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length);
			
			/*	Receive the data from sender	*/
			while (true) {
				datagramSocket.receive(datagramPacket);
				System.out.println(datagramPacket.getAddress().getHostAddress() + " says:\n"+ new String(buff, 0, datagramPacket.getLength()) + "\n");
			}

			/*	Close the socket: release the occupied port	 */
//			datagramSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 	This is a method to start a receiver
	 * @param port
	 */
	public static void startReceiver(int port) {
		new ChatReceiver(port).start();
	}
}
