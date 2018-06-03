package com.java.se.conclusion.design.factory.simple;

import com.java.se.conclusion.design.factory.simple.common.laptop.Acer;
import com.java.se.conclusion.design.factory.simple.common.laptop.Dell;
import com.java.se.conclusion.design.factory.simple.common.laptop.Laptop;
import com.java.se.conclusion.design.factory.simple.common.laptop.Lenovo;

/**
 * 	This is a class to implement simple factory pattern
 *  -- Declare a public and static factory method to return an instance of different classes according to different arguments 
 *     -- Make use of polymorphism inside the factory method
 * @author VinceYuan
 *
 */
public class LaptopFactory {
 
	/**
	 * 	This is a public and static factory method
	 *  -- Declare an reference of parent interface
	 *  -- Reference to an instance of different child classes according to the argument
	 *  -- Return the instance
	 * @param brand
	 * @return
	 */
	public static Laptop getLaptop(String brand) {
		
		/*	Declare an reference of parent interface	*/
		Laptop laptop;
		
		/*	Reference to an instance of different child classes according to the argument	*/
		switch (brand.toUpperCase()) {
		case "ACER":
			laptop = new Acer();
			break;
		case "DELL":
			laptop = new Dell();
			break;
		case "LENOVO":
			laptop = new Lenovo();
			break;
		default:
			laptop = null;
			break;
		}
		
		/*	Return the instance	 */
		return laptop;
	}
}
