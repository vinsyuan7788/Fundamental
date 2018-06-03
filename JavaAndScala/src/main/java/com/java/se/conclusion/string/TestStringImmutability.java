package com.java.se.conclusion.string;

/**
 * 	This is a class to test String immutability
 * 	-- String is immutable, while StringBuilder or StringBuffer is not
 *     -- Pros: Can be applied in synchronization: 
 *        -- Refer to "TestThread.java"
 *     -- Cons: String is more stack-memory-consuming and less time-efficient in some situation: 
 *        -- Refer to "testStringBufferAndStringBuilderMutability()" method in "TestStringBufferAndStringBuilder.java"
 *     
 * @author VinceYuan
 *
 */
public class TestStringImmutability {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestStringImmutability testStringImmutability = new TestStringImmutability();
		testStringImmutability.testStringImutability();
	}
	
	/**
	 * 	Test the string immutability
	 * 	-- Once a String object is instantiated, it is unchanged
	 */
	private void testStringImutability() {
		
		/*	Create a String object & concatenate a string	*/
		String originalString = new String("abc");
		originalString.concat("d");
		
		/*	The original string is unchanged	*/
		System.out.println("The original string: " + originalString);
		
		/*	Need another reference to receive the change of string	*/ 
		String newString = originalString.concat("e");
		System.out.println("The new string: " + newString);
	}
}
