package com.sun.jna.demo;

import com.sun.jna.Platform;
import com.sun.jna.demo.library.DemoLibrary;
import com.sun.jna.utils.ProjectUtils;

public class TestDemo {
	
	static {
		System.load(Platform.isWindows() ?
				ProjectUtils.DLL_DIRECTORY + "DynamicLinkLibraryDemo.dll" :
				ProjectUtils.SO_DIRECTORY + "SharedObjectDemo.so");
	}
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		DemoLibrary demoLibrary = DemoLibrary.INSTANCE;
		
		double[] arr = { 1d, 2d, 4d, 8d, 16d };
		
		double sum = demoLibrary.sum(arr, arr.length);
		System.out.println("sum: " + sum);
		
		double mean = demoLibrary.mean(arr, arr.length);
		System.out.println("mean: " + mean);
	}
}
