package com.sun.jna.demo;

import com.sun.jna.Platform;
import com.sun.jna.demo.library.DemoLibrary;
import com.sun.jna.utils.ProjectUtils;

public class TestDemo {
	
	private static DemoLibrary demoLibrary;
	
	/**
	 * 	This is the static block to load necessary DLL (for Windows) or SO (for Linux) file before the loading of JNA
	 * 	-- Since it can check the dependent DLL or SO for the desired DLL or SO that needs to be loaded
	 *     -- Which will ensure the exactly correct exception will be thrown if there is any dependency missing
	 *        -- E.g., "XXX so is required by XXX", which will let anyone concerned know what exactly is not satisfied and needs to be installed or updated
	 *  -- This static block can be commented if all dependencies are secured
	 *     -- However commenting this block is still strongly NOT recommended
	 *        -- Since if there is any dependency missing, only using JNA to load DLL or SO will throw an indirect or irrelevant exception
	 *           -- E.g, "XXX is found in resource path (...)" or "NoClassDefFoundException", which actually is not the root reason since any concerned mostly may find XXX is actually in the specified path
	 *              -- The reason why this type of exceptions are thrown is that the lack of dependencies cause the incompleteness of compilation during loading and instantiation by JNA directly
	 *                 -- Hence whenever the compiled class is used, some definition in this class will be NOT found due to its incompleteness  
	 */
	static {
		System.load(Platform.isWindows() ?
				ProjectUtils.DLL_DIRECTORY + "DynamicLinkLibraryDemo.dll" :
				ProjectUtils.SO_DIRECTORY + "SharedObjectDemo.so");
		demoLibrary = DemoLibrary.INSTANCE;
	}
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) { 
		
		double[] arr = { 1d, 2d, 4d, 8d, 16d };
		
		double sum = demoLibrary.sum(arr, arr.length);
		System.out.println("sum: " + sum);
		
		double mean = demoLibrary.mean(arr, arr.length);
		System.out.println("mean: " + mean);
	}
}
