package com.java.se.driver.test;

/**
 * 	This is a class to test the correctness of arguments for main method
 * 
 * @author vinsy
 *
 */
public class TestMainArgs {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int count = args.length;
		System.out.println("The number of args: " + count);
		
		if (count > 0) {
			for (int i = 0; i < args.length; i++) {
				System.out.println("The " + (i + 1) + " argument: " + args[i]);
			}
		}
	}
}
