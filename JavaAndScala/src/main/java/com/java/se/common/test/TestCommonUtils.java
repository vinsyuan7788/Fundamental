package com.java.se.common.test;

import java.util.Date;
import java.util.UUID;

import com.java.se.common.test.classes.Person;
import com.java.se.common.utils.OrdinalUtils;
import com.java.se.common.utils.SerDeUtils;

/**
 * 	This is a class to test common utility classes
 * 
 * @author VinceYuan
 *
 */
public class TestCommonUtils {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Here tests OrdinalUtils:");
		testOrdinalUtils();
		System.out.println("\nHere tests SerDeUtils:");
		testSerDeUtils();
	}
	
	/**
	 * 	This is a method to test OrdinalUtils class
	 */
	private static void testOrdinalUtils() {
		
		int num1 = 1;
		int num2 = 11;
		int num3 = 21;
		
		System.out.println(num1 + " ---> " + OrdinalUtils.toOrdinal(num1));
		System.out.println(num2 + " ---> " + OrdinalUtils.toOrdinal(num2));
		System.out.println(num3 + " ---> " + OrdinalUtils.toOrdinal(num3));
	}
	
	/**
	 * 	This is a method to test SerDeUtils class
	 */
	private static void testSerDeUtils() {
		
		Person vince = new Person(UUID.randomUUID().toString(), "Vince", 27, new Date());
		System.out.println("Origianl object:\n" + vince);
		
		byte[] personBytes = SerDeUtils.toByteArray(vince);
		System.out.println("To bytes:\n" + personBytes);
		
		Person person = SerDeUtils.toObject(personBytes);
		System.out.println("Back to object:\n" + person);
	}
}
