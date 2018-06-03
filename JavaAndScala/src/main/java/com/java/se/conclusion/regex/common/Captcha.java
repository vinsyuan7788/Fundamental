package com.java.se.conclusion.regex.common;

import java.util.Random;

/**
 * 	This is a class to randomly generate a captcha
 * 
 * @author VinceYuan
 *
 */
public class Captcha {
	
	/*	This is the object array to sample the number for each digit	 */
	private static Object[] objectArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A'};

	/**
	 * 	This is the static method to return a captcha
	 * 	-- The length of captcha is between 6 and 9
	 * 	-- The captcha may consist of number and letter (A)
	 * @return
	 */
	public static String getCaptcha() {
		
		/*	Randomly decide the number of digits for captcha: 6 - 9 digits  */
		int numberOfDigits = (int) (Math.random()*4 + 6);
		
		/*	Get the captcha	 */
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < numberOfDigits; i++) {
			stringBuffer.append(objectArray[new Random().nextInt(objectArray.length)]);
		}
		return stringBuffer.toString();
	}
}
