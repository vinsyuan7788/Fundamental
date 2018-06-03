package com.java.se.common.utils;

/**
 * 	This is a class to implement string utility methods
 * 
 * @author VinceYuan
 *
 */
public class StringUtils {

	/**
	 * 	This is a method to append indents
	 * @param numberOfIndent
	 * @return
	 */
	public static String appendIndents(int numberOfIndent) {
		
		/*	Initialize an empty string buffer	*/
		StringBuffer stringBuffer = new StringBuffer();
	
		/*	If the number is negative, return a string from the string buffer directly  */
		if (numberOfIndent <= 0) return stringBuffer.toString();
		
		/*	Otherwise append the indents and return a string	*/
		for (int i = 0; i < numberOfIndent ; i++) {
			stringBuffer.append("    ");
		}
		return stringBuffer.toString();
	}
}
