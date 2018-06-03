package com.java.se.conclusion.design.factory.abstracts.common;

/**
 * 	This is an abstract class to be used to test the implementation of abstract factory pattern
 *  -- This class must be inherited by its child classes
 *  
 * @author VinceYuan
 *
 */
public abstract class Border {

	/*	Instance variables	*/
	public String name;
	public String brand;
	public String color;

	/*	Instance methods	*/
	public void flash() {
		System.out.println("A border is flashing...");
	}
	
	/*	Abstract methods	*/
	public abstract void scroll();
}
