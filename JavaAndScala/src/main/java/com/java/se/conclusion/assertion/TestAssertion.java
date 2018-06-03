package com.java.se.conclusion.assertion;

/**
 * 	This is a class to test assertion
 *  -- Assertion is disabled by default:
 *     -- Should enable assertion to use it: can easily search how to enable it online
 * 	-- If the assertion fails, throw an AssertionError
 *     -- Should be used during development and debug, not after being released|launched
 *  -- Should NOT be used for input validation to a public method
 *     -- Better option: IllegalArgumenetException, etc.
 */
public class TestAssertion {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestAssertion testAssertion = new TestAssertion();
		testAssertion.testAssertion();
	}
	
	/**
	 * 	This is a method to test assertion
	 * 	-- This test will fail and throw an AssertionError with a custom message in the Failure Trace 
	 */
	private void testAssertion() {
		
		String string = null;
		/*	Customize error message with assertion	*/
		assert (string != null): "The string is null!";
		System.out.println(string);
	}
}
