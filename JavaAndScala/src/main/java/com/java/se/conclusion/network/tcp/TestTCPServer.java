package com.java.se.conclusion.network.tcp;

import com.java.se.conclusion.network.tcp.server.FileServer;

/**
 * 	This is a class to test TCP server
 *  -- To see the test effect: run the server first, then run the client
 *  
 * @author VinceYuan
 *
 */
public class TestTCPServer {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FileServer.startServer(9090);
	}
}
