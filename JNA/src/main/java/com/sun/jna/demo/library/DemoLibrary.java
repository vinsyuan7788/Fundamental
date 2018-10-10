package com.sun.jna.demo.library;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.utils.ProjectUtils;

public interface DemoLibrary extends Library {

	DemoLibrary INSTANCE = Native.loadLibrary(Platform.isWindows() ? 
			ProjectUtils.DLL_DIRECTORY + "DynamicLinkLibraryDemo.dll" : 
			ProjectUtils.SO_DIRECTORY + "SharedObjectDemo.so", 
			DemoLibrary.class);
	
	double sum(double arr[], int arrLen);
	
	double mean(double arr[], int arrLen);
}
