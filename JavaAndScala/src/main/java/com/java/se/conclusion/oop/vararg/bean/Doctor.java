package com.java.se.conclusion.oop.vararg.bean;

import java.util.Arrays;

import com.java.se.common.utils.CollectionUtils;

/**
 * 	This is a class to be used to test vararg (variable argument)
 * 
 * @author VinceYuan
 *
 */
public class Doctor {

	public static void diagnose(String doctorName, Integer year, String... patientNames) {
		System.out.println("A " + year + " year-experience doctor " + doctorName 
				+ " is diagnosing " + CollectionUtils.toString(Arrays.asList(patientNames)));
	}
}
