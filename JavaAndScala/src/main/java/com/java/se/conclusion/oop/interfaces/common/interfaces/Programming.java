package com.java.se.conclusion.oop.interfaces.common.interfaces;

/**
 * 	This is an interface to be used to test interface
 * 
 * @author VinceYuan
 *
 */
public interface Programming {
	
	/*	Instance variables: MUST be non-private and initialized	 */
	public String language = "Java";

	/*	Default methods  */
	public default void prepare() {
		System.out.println("A programmer is preparing for programming...");
	}
	
	/*	Instance methods	*/
	public void program();
}
