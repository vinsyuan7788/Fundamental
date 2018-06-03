package com.java.se.driver;

import com.java.se.conclusion.date.TestDateAndCalendarAndString;
import com.java.se.conclusion.message.TestMessageFormat;
import com.java.se.driver.test.TestMainArgs;
import com.java.se.driver.utils.ClassDriver;

/**
 * 	This is a class that can be used to specify a main class to run
 * 
 * @author vinsy
 *
 */
public class ApplicationDriver {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		// Add classes into the class driver
		ClassDriver.addClass("TestMessageFormat", TestMessageFormat.class);
		ClassDriver.addClass("TestDateAndCalendarAndString", TestDateAndCalendarAndString.class);
		ClassDriver.addClass("TestMainArgs", TestMainArgs.class);
		
		// Run the driver according to the argument
		ClassDriver.run(args);
	}
}
