package com.java.se.conclusion.oop.constructor;

import com.java.se.conclusion.oop.constructor.bean.Apartment;

/**
 * 	This is a class to test constructor
 * 
 * 	There are 3 types of constructors:
 *  -- Parameterless constructor: default constructor in any class
 *  -- Parameter constructor: constructor with parameters
 *     -- It will cover parameterless constructor if it is declared 
 *        -- Unless parameterless constructor is explicitly declared too
 *     -- Copy constructor: used to copy an instance
 *    
 * @author VinceYuan
 *
 */
public class TestConstructor {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestConstructor testConstructor = new TestConstructor();
		testConstructor.testConstructor();
	}
	
	/**
	 * 	Test constructor
	 */
	private void testConstructor() {
		
		Apartment apartment_1 = new Apartment();
		apartment_1.setLength(30.0);
		apartment_1.setWidth(30.0);
		apartment_1.setHeight(30.0);
		System.out.println("The apartment:\n" + apartment_1);
		Apartment apartment_2 = new Apartment(20.0, 30.0, 40.0);
		System.out.println("The apartment:\n" + apartment_2);
		Apartment apartment_2_copy = new Apartment(apartment_2);
		System.out.println("The apartment copy:\n" + apartment_2_copy);
	}
}
