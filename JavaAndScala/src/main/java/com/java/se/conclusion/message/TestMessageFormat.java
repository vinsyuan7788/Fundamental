package com.java.se.conclusion.message;

import java.text.MessageFormat;

/**
 * 	This is a class to test MessageFormat class
 * 	-- MessageFormat class is used to concatenate a message
 * 
 * @author VinceYuan
 *
 */
public class TestMessageFormat {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestMessageFormat testMessageFormat = new TestMessageFormat();
		testMessageFormat.testMessageFormat();
	}
	
	/**
	 * 	Test MessageFormat class
	 */
	private void testMessageFormat() {
		
		/*
		 * 	Provide the message pattern & arguments for the template
		 * 	-- {0}, {1}, ...: these are place-holders to be filled with arguments
		 * 	-- The number of place-holders MUST be equal to the number of arguments 
		 */
		MessageFormat messageFormat = new MessageFormat("{0}, {1} and {2} come from the same university.");
		Object[] arguments = new Object[] { "Vince", "Violet", "Larry" };
		
		/*	Get the complete message	*/
		String message = messageFormat.format(arguments);
		System.out.println("The complete message: " + message);

		/*	Another usage	*/
		String pattern = "{0}, {1} and {2} come from the same university.";
		arguments = new Object[] { "Vince", "Violet", "Marry" };
		message = MessageFormat.format(pattern, arguments);
		System.out.println("The complete message: " + message);
	}
}
