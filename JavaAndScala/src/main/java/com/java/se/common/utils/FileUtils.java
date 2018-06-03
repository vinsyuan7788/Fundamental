package com.java.se.common.utils;

import java.io.File;

/**
 * 	This is a class to implement file utility methods
 * 
 * @author VinceYuan
 *
 */
public class FileUtils {

	/**
	 *	This is a method to create a file if the file does not exist
	 *  -- If the file exists, then do nothing
	 * @param filePath
	 */
	public static final void createFileIfNotExists(String filePath) {
		
		try {
			/*	Create a new file if the file does not exist	*/
			File file = new File(filePath);
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
