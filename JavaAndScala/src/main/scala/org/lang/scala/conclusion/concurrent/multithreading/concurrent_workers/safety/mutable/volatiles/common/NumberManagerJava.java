package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.volatiles.common;

/**
 * 	This is a class to test "volatile" keyword
 * 
 * 	@author VinceYuan
 */
public class NumberManagerJava {

	/*	Necessary instance variables	*/
	private volatile int number1 = 1;
	private volatile int number2 = 2;
	
	/**
	 * 	This is a method to change the numbers
	 */
	public void change() {
		number1 = 3;
		number2 = number1;
	}
	
	/**
	 * 	This is a method to print the numbers
	 */
	public void print() {
		System.out.println("1st nubmer: " + number1 + "; 2nd number: " + number2);
	}
}
