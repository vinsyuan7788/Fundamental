package com.java.se.conclusion.network.udp;

import java.net.InetAddress;

import com.java.se.conclusion.network.udp.receiver.ChatReceiver;
import com.java.se.conclusion.network.udp.sender.ChatSender;

/**
 * 	This is a class to test UDP sender and receiver
 * 
 * @author VinceYuan
 *
 */
public class TestUDPSenderAndReceiver {

	/**
	 * 	This is a main method for execution
	 *  -- Here is to test the data interaction between sender and receiver
	 *  -- Unlike TCP client-server interaction, UDP sender-receiver interaction MUST be initiated in a MAIN method TOGETHER for data interaction
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			/*	Specify server address and port	 */
			InetAddress serverAddress = InetAddress.getLocalHost();
			Integer port = 9090;
			
			/*	Start the receiver and sender	*/
			ChatReceiver.startReceiver(port);
			ChatSender.startSender(serverAddress, port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
