package com.java.se.common;

import org.junit.Test;

import com.java.se.common.utils.OrdinalUtils;

/**
 * 	This is a class to test common utility classes
 * 
 * @author VinceYuan
 *
 */
public class TestCommonUtils {

	/**
	 * 	This is a method to test OrdinalUtils class
	 */
	@Test
	public void testOrdinalUtils() {
		
		int num1 = 1;
		int num2 = 11;
		int num3 = 21;
		
		System.out.println(num1 + " ---> " + OrdinalUtils.toOrdinal(num1));
		System.out.println(num2 + " ---> " + OrdinalUtils.toOrdinal(num2));
		System.out.println(num3 + " ---> " + OrdinalUtils.toOrdinal(num3));
	}
}
