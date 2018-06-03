package com.java.se.conclusion.iostream.bytes.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.java.se.common.utils.FileUtils;

/**
 * 	This is a class to implement print stream
 *  -- Implemented functionality: print to a file, print to a log
 * 	-- PrintStream will automatically convert the data to bytes before printing out
 *  -- System.out: this "out" is an object of PrintStream
 *  
 *  Functions of PrintStream:
 *  -- Automatic conversion for output
 *  -- Collect exception information
 *  
 * @author VinceYuan
 *
 */
public class PrintOutStream {

	/**
	 * 	This is a static method to print out any type of data with PrintStream
	 * @param data
	 * @param filePath
	 */
	public static void printToFile(Object data, String filePath) {
		
		/*	Create a file if the file does not exist	*/
		FileUtils.createFileIfNotExists(filePath);
		
		/*	Set up the stream (data channel)  */
		try (PrintStream printStream = new PrintStream(new File(filePath))) {
			
			/*	
			 * 	Print out the data
			 * 	-- The data written to the file will completely cover the previous data in the file
			 *     -- If want to append new data in the existing file, use "new FileOutputStream(file, true)" for PrintStream constructor	
			 */
			printStream.println(data);
			
			/*	Close the stream: release the resource (e.g., the file)	 */
//			printStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 	This is a static method to print out exception information
	 * @param logFilePath
	 */
	public static void printExceptionLog(String logFilePath) {
		
		/*	Create a file if the file does not exist	*/
		FileUtils.createFileIfNotExists(logFilePath);

		/*	
		 * 	Specify a PrintStream object to print the exception information to a file on disk 
		 * 	-- The data written to the file will completely cover the previous data in the file
		 *     -- If want to append new data in the existing file, use "new FileOutputStream(file, true)" for PrintStream constructor, like this case	
		 */
		try (PrintStream printStream = new PrintStream(new FileOutputStream(new File(logFilePath), true))) {
			
			/*	Loop to generate exceptions and print the exception information to the log file	*/
			for (int i = 0; i < 100; i++) {
				try {
					System.out.println("The division result: " + 4 / 0);
				} catch (Exception e) {
					e.printStackTrace(printStream);
				}
			}
			
			/*	Close the stream: release the resource (e.g., the log file)	 */
//			printStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
