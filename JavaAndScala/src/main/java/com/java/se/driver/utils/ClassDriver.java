package com.java.se.driver.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 	This is a class driver to store classes
 * 
 * @author vinsy
 *
 */
public class ClassDriver {

	// Necessary static variables
	private final static Map<String, Class<?>> classMap = new HashMap<>();
	
	/**
	 * 	This is a method to add a class
	 * 
	 * @param name
	 * @param clazz
	 */
	public static void addClass(String name, Class<?> clazz) {
		classMap.put(name, clazz);
	}
	
	/**
	 * 	This is a method to run corresponding class according to the argument
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void run(String[] args) throws Exception {
		
		// If the argument is valid
		if (isArgsValid(args)) {
			
			// Get the name of the class from the class map
			String className = args[0];
			
			// Get the class according to the name
			Class<?> clazz = classMap.get(className);
			
			// If the class exists
			if (clazz != null) {
			
				// Get the main method from the class
				Method mainMethod = clazz.getMethod("main", String[].class);
				
				// Get the arguments for the main method
				String[] mainArgs = new String[args.length - 1];
				for (int i = 0; i < args.length - 1; i++) {
					mainArgs[i] = args[1 + i];
				}
				
				// Execute the main method
				mainMethod.invoke(null, new Object[] { mainArgs });
				
			// If the class is null
			} else {	
				// Print a message
				System.out.println("Cannot find the corresponding class by the name. Please enter another class name!");
			}
		// If the argument is invalid
		} else {
			// Print a message
			System.out.println("The number of the arguments must be equal to or greater than 1!");
		}
	}
	
	/**
	 * 	This is a method to check if the argument is valid
	 * 
	 * @param args
	 * @return
	 */
	private static boolean isArgsValid(String[] args) {
		return (args.length >= 1) ? true : false;
	}
}
