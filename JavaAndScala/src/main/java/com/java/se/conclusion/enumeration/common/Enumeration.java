package com.java.se.conclusion.enumeration.common;

import java.util.Random;

/**
 * 	This is a class to implement enumeration
 * 
 * @author VinceYuan
 *
 */
public class Enumeration {
	
	/**
	 * 	This is the static method to traverse the enumeration value
	 */
	public static void traverseLight() {
		
		try {
			/*	Get all enumeration value from the enumeration class	*/
			Light[] lights = Light.values();
			
			/*	Traverse all enumeration value	*/
			for (Light light : lights) {
				System.out.println("Current light: " + light);
				System.out.println("Name of current light: " + light.name());
				System.out.println("Value of current light: " + light.value);
				System.out.println("Ordinal of current light: " + light.ordinal());
				System.out.println("Return result of the methods of current light: " + light.flash());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is the static method to apply "switch...case..." on enumeration values
	 */
	public static void SwitchCase(Light light) {
		
		/*	
		 * 	Apply "switch...case..." on enumeration values
		 * 	1. Here the case cannot specify "Light.RED", etc.: because switch(light) has specified that the enumeration values MUST come from Light enumeration class
		 *     -- In case that put the object of an enumeration class (e.g., Light) on switch but put other enumeration values (e.g., Gender.MAN, etc.) on case, which will bring compilation confusion: complier will not know what enumeration (Light or Gender) should be enumerated	
		 */
		switch (light) {
			case RED:
				System.out.println("The light is red.");
				break;
			case YELLOW:
				System.out.println("The light is yellow.");
				break;
			case GREEN:
				System.out.println("The light is green.");
				break;
			default:
				break;
		}
	}
	
	/**
	 * 	This is an enumeration class Light
	 * 	-- Enumeration is sub-class (can be public, private, etc.): hence can have (since sub-class is still a class) 
	 *     -- Constructors (MUST be private)
	 *     -- Static or instance variables
	 *     -- Static or instance or abstract methods
	 *  -- Enumeration value is the object of current class created by a privatized constructor
	 *  -- Enumeration can be used in "switch...case..."
	 *  
	 * @author VinceYuan
	 *
	 */
	public enum Light {

		/*	
		 * 	Declare enumeration values, which are equivalent to:
		 * 	-- public static final Light RED = new Light("red");
		 *  -- public static final Light YELLOW = new Gender("yellow");	
		 *  -- private Light () {};
		 *     -- Namely use a privatized no-argument constructor to instantiate 2 objects of current class
		 *     -- If the no-argument constructor is replaced by with-argument constructor, should assign an argument to enumeration value
		 *     -- If there is an abstract method, then enumeration value MUST override it
		 *     -- Enumeration MUST lie at the top inside the enumeration class
		 */
		RED("red") {
			@Override
			public String flash() throws Exception {
				return "Red light is flashing...";
			}
		}, 
		
		YELLOW("yellow") {
			@Override
			public String flash() throws Exception {
				return "Yellow light is flashing...";
			}
		},
		
		GREEN("green") {
			@Override
			public String flash() throws Exception {
				return "Green light is flashing...";
			}
		};
		
		/*	Declare static|instance variables	*/
		private static final String[] light = {"RED", "YELLOW", "GREEN"};
		public static final String DEFAULT_COLOR = "GREEN";
		public String value;
		
		/*	Declare constructor: MUST be private	*/
		private Light(String value) {
			this.value = value;
		}
		
		/*	Declare static or instance or abstract methods	*/
		/**
		 * 	This is a static method to randomly get a light
		 * @return
		 * @throws Exception
		 */
		public static String getLight() {
			return light[new Random().nextInt(light.length)]; 
		}

		/**
		 * 	This is a dynamic method to get the value of instance variable
		 * @return
		 */
		public String getValue() {
			return value;
		}
		
		/**
		 * 	This is an abstract method to be overridden (by enumeration value)
		 * @throws Exception
		 */
		public abstract String flash() throws Exception;
	}
}

