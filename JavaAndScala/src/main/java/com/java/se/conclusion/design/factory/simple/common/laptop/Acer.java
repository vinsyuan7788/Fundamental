package com.java.se.conclusion.design.factory.simple.common.laptop;

/**
 * 	This is a class to be used to test the implementation of simple factory pattern
 *  -- This class must implement a parent interface
 *  
 * @author VinceYuan
 *
 */
public class Acer implements Laptop {

	@Override
	public void startup() {
		System.out.println("An Acer laptop is starting up...");
	}

	@Override
	public void shutdown() {
		System.out.println("An Acer laptop is shutting down...");
	}
}
