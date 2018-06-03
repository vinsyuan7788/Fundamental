package com.java.se.conclusion.dandc.common.utils;

import com.java.se.conclusion.dandc.common.classes.ProcessOptions;

/**
 * 	This is a class that contains utility methods to parse arguments to options
 * 
 * @author VinceYuan
 *
 */
public class ProcessOptionsParser {

	/**
	 * 	This is a method to parse arguments to options
	 * 
	 * @param args
	 * @return
	 */
	public static ProcessOptions parseArgumentsToOptions(String[] args) {
		return new ProcessOptions(args);
	}
}
