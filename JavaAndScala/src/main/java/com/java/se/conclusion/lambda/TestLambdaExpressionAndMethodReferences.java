package com.java.se.conclusion.lambda;

import java.util.Arrays;

import com.java.se.common.utils.CollectionUtils;

/**
 * 	This is a class to test lambda expression and method references
 * 
 * 	Lambda expression: One lambda expression represents the implementation of an anonymous class
 *  -- There is no parameter: () -> [{] ... [; ...; ...; }]
 *     -- E.g., "() -> customer.getName()", "() -> new Trainee("Violet", "He", 8.5)", "() -> { String name = customer.getName(); return name; }", etc.
 *  -- There are parameters: [(] var1 [, var2, ... [)] -> [{] ... [; ...; ...; }]
 *     -- E.g., "string -> string.length() > 0", "(int1, int2) -> int1.compareTo(int2)", etc.
 *     -- E.g., "(str1, str2) -> { Integer len1 = str1.length(); Integer len2 = str2.length(); return len1.compareTo(len2); }"
 *  
 *  Method reference: reference to a method inside a class
 *  -- Static method reference: [ClassName]::[methodName] 
 *     -- E.g., "Integer::valueOf", etc.
 *  -- Instance method reference: [instanceName|InstanceType]::[methodName]
 *     -- E.g., "customer::getName", "String::compareToIgnoreCase", etc.
 *  -- Constructor method reference: [ClassName]::new
 *     -- E.g., "String::new", etc.
 *     
 * @author VinceYuan
 *
 */
public class TestLambdaExpressionAndMethodReferences {
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestLambdaExpressionAndMethodReferences testLambdaExpressionAndMethodReferences = new TestLambdaExpressionAndMethodReferences();
		testLambdaExpressionAndMethodReferences.testMethodReference();
	}
	
	/**
	 * 	Test method references
	 */
	private void testMethodReference() {
		
		/*	Test method reference for instance method of a particular type: [InstanceType]::[methodName]	*/
		String[] stringArray = { "Barbara", "James", "Mary", "John","Patricia", "Robert", "Michael", "Linda" };
		Arrays.sort(stringArray, String::compareToIgnoreCase);
		System.out.println(CollectionUtils.toString(Arrays.asList(stringArray)));
	}
}
