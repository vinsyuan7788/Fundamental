package com.java.se.conclusion.design.singleton.lazy.common;

/**
 * 	This is an abstract class to be inherited by its subclasses
 *  -- This class has common methods for its subclasses
 *  
 * @author VinceYuan
 *
 */
public abstract class HumanBeing {
	
	public abstract void run() throws Exception;
	
	public void walk() throws Exception {
		System.out.println("A human being is walking...");
	}
}
