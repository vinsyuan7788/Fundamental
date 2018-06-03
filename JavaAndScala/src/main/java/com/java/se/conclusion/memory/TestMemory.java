package com.java.se.conclusion.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 	This is a class to test memory (stack and heap)
 * 	-- Reference: the variable in stack memory refers to the object or instance in heap memory
 *     -- String reference behaves differently from other primitive types ONLY on type comparison using "==" IN JAVA
 *        -- Since string-typed comparison compare both reference and value if using "=="
 *      -- In Scala, String behaves exactly the same as other primitive types
 * 
 * 	JVM memory rough composition: stack, heap & method area:
 * 	-- Stack: to store variables
 *     -- FILO 
 *     -- Automatically-assigned by JVM|OS
 * 	-- Heap: to store objects or instances
 *     -- FIFO 
 *     -- Manually-assigned by programmer
 *  -- Method Area: to store compiled java files
 *     -- Refer to "testReflection.java"
 *     
 * @author VinceYuan
 *
 */
public class TestMemory {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestMemory testMemory = new TestMemory();
		System.out.println("Here tests primitive type reference");
		testMemory.testPrimitiveTypeReference();
		System.out.println("\nHere tests reference and value comparison for integers:");
		testMemory.testReferenceAndValueComparisonForInteger();
		System.out.println("\nHere tests reference and value comparison for strings:");
		testMemory.testReferenceAndValueComparisonForString();
	}
	
	/**
	 * 	Test primitive type reference
	 */
	private void testPrimitiveTypeReference() {
		
		/*	Int-type reference	*/
	    int intA = 1;                                  // intA = 1
	    int intB = intA;	                           // intB = 1
	    System.out.println("Int-type reference:");
	    System.out.println("Before: A=" + intA + ", B=" + intB);      // A=1, B=1
	    intA = 2;
	    System.out.println("After: A=" + intA + ", B=" + intB);       // A=2, B=1
	    
	    /*	String-type reference	 */
	    String strA = "Hello Java";                       // strA = "Hello Scala"
	    String strB = strA;                               // strB = "Hello Scala"
	    System.out.println("String-type reference:");
	    System.out.println("Before: A=" + strA + ", B=" + strB);      // A="Hello Scala", B="Hello Scala"
	    strA = "Hello BigData";
		System.out.println("After: A=" + strA + ", B=" + strB);       // A="Hello BigData", B="Hello Scala"
		
		/*	String-type reference	 */
	    String strC = new StringBuilder("Hello Java").toString();     // strC = "Hello Scala"
	    String strD = strC;                               // strD = "Hello Scala"
	    System.out.println("String-type reference:");
	    System.out.println("Before: A=" + strC + ", B=" + strD);      // A="Hello Scala", B="Hello Scala"
	    strC = "Hello BigData";
		System.out.println("After: A=" + strC + ", B=" + strD);       // A="Hello BigData", B="Hello Scala"
	}
	
	/**
	 * 	Test the difference between "==" and "equals()" for String objects
	 */
	private void testReferenceAndValueComparisonForString() {
		
		/*	Create 2 null string references	 */
		String string1 = null;
		String string2 = null;
		String string3 = null;
		
		/*	
		 * 	Do the comparison between the strings with same reference and value
		 * 
		 * 		stack			heap
		 * 		string1 ----->  "This is a test String"
		 * 								  |
		 * 		string2 ----->------------|
		 */
		string1 = "This is a test String";
		string2 = "This is a test String";
		System.out.println("1st comparison:");
		if (string1 == string2) {
			System.out.println("string1 and string2 have the same reference");
		} else {
			System.out.println("string1 and string2 have different references");
		}
		if (string1.equals(string2)) {
			System.out.println("string1 and string2 have the same value");
		} else {
			System.out.println("string1 and string2 have difference values");
		}
		
		/*	
		 * 	Do the comparison between the strings with different references and same value
		 * 	
		 * 		stack			heap
		 * 		string1 ----->  "This is a test String"
		 * 								 
		 * 		string2 ----->	"This is a test String"
		 */
		string1 = "This is a test String";
		string2 = new String("This is a test String");
		System.out.println("2nd comparison:");
		if (string1 == string2) {
			System.out.println("string1 and string2 have the same reference");
		} else {
			System.out.println("string1 and string2 have different references");
		}
		if (string1.equals(string2)) {
			System.out.println("string1 and string2 have the same value");
		} else {
			System.out.println("string1 and string2 have difference values");
		}
		
		/*	
		 * 	Do the comparison between the strings with different references and same value
		 * 
		 * 		stack			heap
		 * 		string1 ----->  "This is a test String"
		 * 								 
		 * 		string2 ----->	"This is a test String"
		 */
		string1 = new String("This is a test String");
		string2 = new String("This is a test String");
		System.out.println("3rd comparison:");
		if (string1 == string2) {
			System.out.println("string1 and string2 have the same reference");
		} else {
			System.out.println("string1 and string2 have different references");
		}
		if (string1.equals(string2)) {
			System.out.println("string1 and string2 have the same value");
		} else {
			System.out.println("string1 and string2 have difference values");
		}
		
		/*	
		 * 	Do the comparison between the strings with different references and same value
		 * 
		 * 		stack			heap
		 * 		string1 ----->  "This is a test String"
		 * 								 
		 * 		string2 ----->	"This is a test String"	
		 * 
		 * 		string3 ----->	"This is a test String"
		 */
		string1 = new StringBuffer("This is a test String").toString();
		string2 = new String("This is a test String");
		string3 = "This is a test String";
		System.out.println("4th comparison:");
		if (string1 == string2) {
			System.out.println("string1 and string2 have the same reference");
		} else {
			System.out.println("string1 and string2 have different references");
		}
		if (string1.equals(string2)) {
			System.out.println("string1 and string2 have the same value");
		} else {
			System.out.println("string1 and string2 have difference values");
		}
		if (string1 == string3) {
			System.out.println("string1 and string3 have the same reference");
		} else {
			System.out.println("string1 and string3 have different references");
		}
		if (string1.equals(string3)) {
			System.out.println("string1 and string3 have the same value");
		} else {
			System.out.println("string1 and string3 have difference values");
		}
		if (string2 == string3) {
			System.out.println("string2 and string3 have the same reference");
		} else {
			System.out.println("string2 and string3 have different references");
		}
		if (string2.equals(string3)) {
			System.out.println("string2 and string3 have the same value");
		} else {
			System.out.println("string2 and string3 have difference values");
		}
	}
	
	/**
	 * 	Test the "==" for Integer objects
	 * 	-- If the integer value is within the range between -128 and 127, the objects will be stored in IntegerCache class
	 * 	   so that the value can be referenced repeatedly and improve the reusabilty
	 *  -- If the integer value is out of range (-128, 127), the JVM will assign a new reference to the integer object
	 */
	private void testReferenceAndValueComparisonForInteger() {
		
		/*	Create 2 null integer references  */
		Integer a = null;
		Integer b = null;
		
		/*	Compare the references of value with range [-200, 199) 	 */
		int sameReferenceCount = 0;
		int diffReferenceCount = 0;
		List<Integer> sameReferenceValues = new ArrayList<Integer>();
		for (a = -200, b = -200; a < 200 && b < 200; a++, b++) {
			if (a == b) {
				sameReferenceCount += 1;
				sameReferenceValues.add(a);
			} else {
				diffReferenceCount += 1;
			}	
		}
		System.out.println("The same reference count: " + sameReferenceCount);
		System.out.println("The different reference count: " + diffReferenceCount);
		System.out.println("Total counts: " + (sameReferenceCount + diffReferenceCount));
		System.out.println("The range of values for same reference: [" + sameReferenceValues.get(0) + ", " + sameReferenceValues.get(sameReferenceValues.size()-1) + "]");
		System.out.println("The values out of above range have different references");
	}
}
