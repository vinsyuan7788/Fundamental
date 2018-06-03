package com.java.se.conclusion.design.factory.simple.common.vehicle;

/**
 * 	This is a class to be used to test the implementation of simple factory pattern
 *  -- This class must inherit a parent abstract class
 *  
 * @author VinceYuan
 *
 */
public class Truck extends Vehicle {

	@Override
	public void turn() {
		System.out.println("A truck is turning left...");
	}

	@Override
	public void inspect() {
		System.out.println("A truck is under inspection...");
	}
}
