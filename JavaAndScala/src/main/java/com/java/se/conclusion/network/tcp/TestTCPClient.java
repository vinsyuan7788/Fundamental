package com.java.se.conclusion.network.tcp;

import java.net.InetAddress;

import com.java.se.conclusion.network.tcp.client.FileClient;

/**
 * 	This is a class to test TCP client
 *  -- To see the test effect: run the server first, then run the client
 *  
 * @author VinceYuan
 *
 */
public class TestTCPClient {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		FileClient.startClient(InetAddress.getLocalHost(), 9090);
	}
}
