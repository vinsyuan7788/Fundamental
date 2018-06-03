package com.java.se.conclusion.string;

import java.util.StringTokenizer;

/**
 * 	This is a class to test StringTokenizer
 * 	-- Can be used to parse a string (customized by programmer or read from a text file, etc.)
 * 
 * 	Exemplary application scenario:
 * 	-- Count the word in a text file
 * 
 * @author VinceYuan
 *
 */
public class TestStringTokenizer {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestStringTokenizer testStringTokenizer = new TestStringTokenizer();
		testStringTokenizer.testStringTokenizer();
	}
	
	/**
	 * 	Test StringTokenizer class
	 */
	private void testStringTokenizer() {
		
		/*	Get a string & parse the string using " " with StringTokenizer	*/
		String line = "I love China & I love the world!";
		StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
		
		/*	Count the total remaining tokens after current position: current position is 0 by default & can move to next position by "nextToken()"	 */
		System.out.println("The total of words: " + stringTokenizer.countTokens());
		
		/*	See if there is at least one token after current position: current position is 0 by default & can move to next position by "nextToken()"	*/
		System.out.println("At least one token after current position? " + stringTokenizer.hasMoreTokens() + "\n");
		
		/*	Get the parsed words in the string	 */
		while (stringTokenizer.hasMoreTokens()) {
			String nextWord = stringTokenizer.nextToken();
			System.out.println("The parsed word in the string: " + nextWord);
			System.out.println("The total remaining words: " + stringTokenizer.countTokens());
			System.out.println("At least one word after current position? " + stringTokenizer.hasMoreTokens());
		}

	}
}
