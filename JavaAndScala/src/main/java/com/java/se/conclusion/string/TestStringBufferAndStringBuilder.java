package com.java.se.conclusion.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 	This is a class to test StringBuffer and StringBuilder
 *  -- StringBuffer v.s. StringBuilder:
 *     -- StringBuffer is synchronized or thread-safe, while StringBuilder is not
 *     -- StringBuffer is not as efficient as StringBuilder (due to the synchronization of StringBuffer methods (or APIs))
 *     -- Hence:
 *        -- For single-threaded: StringBuilder > StringBuffer
 *        -- For multi-threaded: StringBuffer > StringBuilder; StringBuilder + synchronized block or methods
 *  
 * @author VinceYuan
 *
 */
public class TestStringBufferAndStringBuilder {
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestStringBufferAndStringBuilder testStringBufferAndStringBuilder = new TestStringBufferAndStringBuilder();
		testStringBufferAndStringBuilder.testStringBufferAndStringBuilderMutability();
	}
	
	/**
	 * 	Test the StringBuffer & StringBuilder mutability: using a loop concatenation case
	 * 	-- In this case, StringBuffer or StringBuilder is more efficient
	 */
	private void testStringBufferAndStringBuilderMutability() {
		
		/*	Create a StringBuffer, StringBuilder and String object respectively	*/
		StringBuffer stringBuffer = new StringBuffer();
		StringBuilder stringBuilder = new StringBuilder();
		String string = "";
		
		/*	Read the input from console	 */
		while (true) {
			
			/*	If the input is acceptable, then output and break the loop	*/
			try {
				System.out.println("Please input an integer greater than 0: (Recommendation: 10000)");
				int inputInteger = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
				
				/*	If the input is not greater than 0, output a message and continue the loop	*/
				if (inputInteger <= 0) {
					System.out.println("The input integer MUST be greater than 0.");
					continue;
				}
				
				/*	Loop to concatenate a string: in this case, StringBuffer or StringBuilder is more efficient	*/
				long startTimeForStringBuffer = System.nanoTime();
				for (int i = 0; i < inputInteger; i++) {
					if (i > 0) {
						stringBuffer.append(", ");
					}
					stringBuffer.append("a");
				}
				long endTimeForStringBuffer = System.nanoTime();
				
				long startTimeForStringBuilder = System.nanoTime();
				for (int i = 0; i < inputInteger; i++) {
					if (i > 0) {
						stringBuilder.append(", ");
					}
					stringBuilder.append("a");
				}
				long endTimeForStringBuilder = System.nanoTime();
				
				long startTimeForString = System.nanoTime();
				for (int i = 0; i < inputInteger; i++) {
					if (i > 0) {
						string = string.concat(", ");
					}
					string = string.concat("a");
				}
				long endTimeForString = System.nanoTime();
				
				/*	Output the information to console 	*/
				System.out.println("The string from StringBuffer: " + stringBuffer.toString());
				System.out.println("The string length: " + stringBuffer.toString().length());
				System.out.println("The elapse time: " + (endTimeForStringBuffer - startTimeForStringBuffer) + " ns");
				System.out.println("The order of maginitude of elapse time: " + String.valueOf(endTimeForStringBuffer - startTimeForStringBuffer).length());
				System.out.println("\nThe string from StringBuilder: " + stringBuilder.toString());
				System.out.println("The string length: " + stringBuilder.toString().length());
				System.out.println("The elapse time: " + (endTimeForStringBuilder - startTimeForStringBuilder) + " ns");
				System.out.println("The order of maginitude of elapse time: " + String.valueOf(endTimeForStringBuilder - startTimeForStringBuilder).length());
				System.out.println("\nThe string from String: " + string);
				System.out.println("The string length: " + string.length());
				System.out.println("The elapse time: " + (endTimeForString - startTimeForString) + " ns");
				System.out.println("The order of maginitude of elapse time: " + String.valueOf(endTimeForString - startTimeForString).length());
				
				/*	Break the loop	*/
				break;
				
			/*	If the input is acceptable, output a message & let the loop continue 	*/
			} catch (Exception e) {
				System.out.println("Your input is NOT an integer!");
			}
		}
	}
}
