package com.java.se.conclusion.design.factory.simple.common.vehicle;

/**
 * 	This is an abstract class to be used to test the implementation of simple factory pattern
 * 	-- This abstract class must be inherited by its child classes
 * 
 * @author VinceYuan
 *
 */
public abstract class Vehicle {

	/*	Instance variables	*/
	public String id;
	public String brand;
	public int size;
	
	/*	Instance methods	*/
	public void Speedup() {
		System.out.println("A vehicle is speeding up...");
	}
	public void Slowdown() {
		System.out.println("A vehicle is slowing down...");
	}
	
	/*	Abstract methods	*/
	public abstract void turn();
	public abstract void inspect();
}
