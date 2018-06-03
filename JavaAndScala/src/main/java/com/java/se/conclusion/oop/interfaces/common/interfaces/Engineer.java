package com.java.se.conclusion.oop.interfaces.common.interfaces;

/**
 * 	This is an interface to be used to test interface
 *  -- This interface must inherit its parent interface
 *  
 * @author VinceYuan
 *
 */
public interface Engineer extends Programming {

	/*	Static variables: MUST be non-private and initialized	*/
	public static String salary = "secret";
	
	/*	Static methods	*/
	public static void getInfo() {
		System.out.println("This is an engineer...");
	};
}
