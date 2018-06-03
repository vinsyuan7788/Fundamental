package com.java.se.conclusion.design.factory.abstracts.common;

/**
 * 	This is an abstract class to be used to test the implementation of abstract factory pattern
 *  -- This class must be inherited by its child classes
 *  
 * @author VinceYuan
 *
 */
public abstract class Button {

	/*	Instance variables	*/
	public String name;
	public String brand;
	public String color;

	/*	Instance methods	*/
	public void click() {
		System.out.println("A button is being clicked...");
	}
	
	/*	abstract methods	*/
	public abstract void design();
}
