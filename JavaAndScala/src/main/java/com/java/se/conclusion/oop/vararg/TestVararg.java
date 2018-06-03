package com.java.se.conclusion.oop.vararg;

import com.java.se.conclusion.oop.vararg.bean.Doctor;

/**
 * 	This is a class to test vararg (variable argument)
 * 
 * 	Variable-argument: allow to call a method with any number of arguments with the same type
 *  -- Variable argument is treated as an array
 *  -- If there are multiple arguments, variable-argument MUST be put at the end
 *  
 * @author VinceYuan
 *
 */
public class TestVararg {

	/**
	 * 	This is a main method for execution
	 * @param args
	 */
	public static void main(String[] args) {
		TestVararg testVararg = new TestVararg();
		testVararg.testVariableArgument();
	}
	
	/**
	 * 	Test variable argument
	 */
	private void testVariableArgument() {
		
		Doctor.diagnose("Vince", 10, "Violet", "Kelly", "Johnny");
	}
}
