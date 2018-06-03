package com.java.se.conclusion.design.factory.simple.common.laptop;

/**
 * 	This is a class to be used to test the implementation of simple factory pattern
 *  -- This class must implement a parent interface
 *  
 * @author VinceYuan
 *
 */
public class Lenovo implements Laptop {

	@Override
	public void startup() {
		System.out.println("A Lenovo laptop is starting up...");
	}

	@Override
	public void shutdown() {
		System.out.println("A Lenovo laptop is shutting down...");
	}
}
