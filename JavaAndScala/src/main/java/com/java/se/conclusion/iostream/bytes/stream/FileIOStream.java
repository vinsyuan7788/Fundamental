package com.java.se.conclusion.iostream.bytes.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.java.se.common.utils.FileUtils;

/**
 * 	This is a class to implement file IO stream
 *  -- Implemented functionality: write, read, copy
 *  
 * @author VinceYuan
 *
 */
public class FileIOStream {

	/**
	 * 	This is a static method to write data to a file on disk using FileOutputStream
	 * @param data
	 * @param filePath
	 */
	public static void writeToFile(String data, String filePath) {
		
		/*	Create a file if the file does not exist	*/
		FileUtils.createFileIfNotExists(filePath);
		
		/*	Set up the stream (namely data channel) for the file	*/
		try (FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath))) {
			
			/*	
			 * 	Write the data to the file
			 *  -- The data written to the file will completely cover the previous data in the file
			 *     -- If want to append new data in the existing file, use the constructor "new FileOutputStream(file, true)"	
			 */
			fileOutputStream.write(data.getBytes());		// Here "getByte()" does the encoding
			
			/*	Close the stream: release the resource (i.e., the file)	 */
//			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 	This is a static method to read a file from disk using FileInputStream
	 *  -- Buffer + while loop is a relatively better way to read files
	 *     -- More time-efficient & less CPU-consuming at the cost of space (namely buffer)
	 * @param bufferSize
	 * @param filePath
	 */
	public static void readFromFile(int bufferSize, String filePath) {
		
		/*	Set up the stream (namely data channel) for the file	*/
		try (FileInputStream fileInputStream = new FileInputStream(new File(filePath))) {
			
			/*	
			 * 	Read the data in the file
			 * 	1. Use a byte array to allow to read multiple data once
			 * 	2. Use an int-type data to record the actual read-in data length
			 *  3. Use while loop to completely read the file
			 *     -- When read to the end of the file, it will return -1	
			 */
			byte[] buffer = new byte[bufferSize];
			int lengthOfActualReadInData = 0;
			while ((lengthOfActualReadInData = fileInputStream.read(buffer)) != -1) {
				System.out.print(new String(buffer, 0, lengthOfActualReadInData));	// Here use the default decoding rules (GBK) to get a string
			}
			
			/*	Close the stream: release the resource (i.e., the file)	 */
//			fileInputStream.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a static method to copy a file using both FileInputStream and FileOutputStream
	 * @param bufferSize
	 * @param originalFilePath
	 * @param copyFilePath
	 */
	public static void copyFile(int bufferSize, String originalFilePath, String copyFilePath) {
		
		/*	Create a file if the file does not exist	*/
		FileUtils.createFileIfNotExists(copyFilePath);
		
		/*	Set up the stream (namely data channel) for the file	*/
		try (FileInputStream fileInputStream = new FileInputStream(new File(originalFilePath));
				FileOutputStream fileOutputStream = new FileOutputStream(new File(copyFilePath))) {
			
			/*	
			 * 	Read and write data simultaneously to copy the file	
			 * 	1. Use a byte array to allow to read multiple data once
			 * 	2. Use an int-type data to record the actual read-in data length
			 *  3. Use while loop to completely copy the file
			 *     -- When read to the end of the file, it will return -1
			 *     -- After read the data, write whatever is read, until the loop is over	
			 */
			byte[] buffer = new byte[bufferSize];
			int lengthOfActualReadInData = 0;
			while ((lengthOfActualReadInData = fileInputStream.read(buffer)) != -1) {
				fileOutputStream.write(buffer, 0, lengthOfActualReadInData);
			}
			
			/*	Close the stream: release the resource (i.e., the files)	 */
//			fileOutputStream.close();
//			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
