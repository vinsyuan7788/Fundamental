package com.java.se.conclusion.math;

import com.java.se.conclusion.math.common.Captcha;

/**
 * 	This is the class to perform testing regarding math
 * 	-- Math.random()
 *  -- new Random().nextInt(int n)
 *  
 * @author VinceYuan
 *
 */
public class TestMath {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestMath testMath = new TestMath();
		testMath.testGenerateCaptcha();
	}
	
	/**
	 * 	Test generate captcha with random sampling from an array
	 */
	private void testGenerateCaptcha() {
		
		/*	Randomly generate a captcha	 */
		String captcha = Captcha.getCaptcha();
		
		/*	Output the captcha	*/
		System.out.println("The captcha: " + captcha);
	}
}
