package com.java.se.conclusion.string;

/**
 * 	This is a class to test String API
 * 
 * @author VinceYuan
 *
 */
public class TestStringAPI {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestStringAPI testStringAPI = new TestStringAPI();
		System.out.println("Here tests conversion of first letter to upper case:");
		testStringAPI.testFirstLetterUpperCaseConverstion();
		System.out.println("\nHere tests \"isEmpty()\":");
		testStringAPI.testStringIsEmpty();
		System.out.println("\nHere test \"String.format\":");
		testStringAPI.testStringFormat();
	}
	
	/**
	 * 	Test the upper case conversion of the first letter
	 */
	private void testFirstLetterUpperCaseConverstion() {
		
		/*	Get the setter name for the corresponding field name	*/
		String fieldName = "xxxx";
		String setterName = "set" + fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase());
		
		/*	Output the information	*/
		System.out.println("The field name: " + fieldName);
		System.out.println("The setter name: " + setterName);
	}
	
	/**
	 * 	Test the API "isEmpty()"
	 */
	private void testStringIsEmpty() {
	
	    String str1 = "";
	    String str2 = "				".trim();
	    String str3 = "				";
	    String str4 = "abcdefg";
	    
	    System.out.println("If " + str1 + " is empty: " + str1.isEmpty());
	    System.out.println("If " + str2 + " is empty: " + str2.isEmpty());
	    System.out.println("If " + str3 + " is empty: " + str3.isEmpty());
	    System.out.println("If " + str4 + " is empty: " + str4.isEmpty());
	}
	
	/**
	 * 	This is a method to test "String.format" for string interpolation
	 */
	private void testStringFormat() {

		String pattern = "%s is %d-year-old.";
		Object[] arguments = new Object[]{ "Vince", 27 };
		String output = String.format(pattern, arguments);
		System.out.println(output);
	}
}
