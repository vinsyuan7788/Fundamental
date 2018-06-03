package com.java.se.conclusion.iostream.bytes.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.java.se.common.utils.FileUtils;

/**
 * 	This is a class to implement buffered IO stream
 *  -- Implemented functionality: write, read, copy
 *  -- Buffered IO stream are more commonly-used compared with file IO stream
 *     -- Even buffered IO stream can be replaced by file IO stream
 *  
 * @author VinceYuan
 *
 */
public class BufferedIOStream {

	/**
	 * 	This is a static method to write data to a file on disk using BufferedOutputStream
	 * @param data
	 * @param filePath
	 */
	public static void writeToFile(String data, String filePath) {
		
		/*	Create a file if the file does not exist	*/
		FileUtils.createFileIfNotExists(filePath);
		
		/*	Set up the stream (namely data channel) for the file	*/
		try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(filePath)))) {
			
			/*	
			 * 	Write the data to the file
			 * 	-- The data written to the file will completely cover the previous data in the file
			 *     -- If want to append new data in the existing file, use "new FileOutputStream(file, true)" as the argument for BufferedOutputStream constructor
			 *  -- When to actually write out the data to a file (i.e., flush out the data from the internal buffer to a file) 
			 *     -- When invoke "flush()" (refer to source code)
			 *     -- When the internal buffer is full, then flush out the data automatically (refer to source code)
			 *     -- When invoke "close()", it will flush the data before closing the stream (refer to source code)  	
			 */
			bufferedOutputStream.write(data.getBytes());		// Here "getByte()" does the encoding 
//			bufferedOutputStream.flush();						// If need to flush out the data without closing the stream, invoke this method
			
			/*	Close the stream: release the resource (i.e., the file)	 */
//			bufferedOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a static method to read a file from disk using BufferedInputStream
	 *  -- The efficiency of reading file is actually not as high as using FileInputStream
	 *     -- Since when use "read()", BufferedInputStream will do the predication each time (refer to the source code)
	 *     -- Lower efficient (than FileInputStream) but more convenient to write the codes (since there is a default value for the buffered size, refer to source code)
	 * @param filePath
	 */
	public static void readFromFile(String filePath) {
		
		/*	Set up the stream (namely data channel) for the file	*/
		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(filePath)))) {
			
			/*	
			 * 	Read the data in the file
			 * 	1. Use an int-type data to record the actual read-in data length
			 *  2. Use while loop to completely read the file
			 *     -- When read to the end of the file, it will return -1	
			 */
			int lengthOfActualReadInData = 0;
			while ((lengthOfActualReadInData = bufferedInputStream.read()) != -1) {
				System.out.print((char) lengthOfActualReadInData);
			}
			
			/*	Close the stream: release the resource (i.e., the file)	 */
//			bufferedInputStream.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a static method to copy a file using both BufferedInputStream and BufferedOutputStream
	 * @param originalFilePath
	 * @param copyFilePath
	 */
	public static void copyFile(String originalFilePath, String copyFilePath) {
		
		/*	Create a file if the file does not exist	*/
		FileUtils.createFileIfNotExists(copyFilePath);
		
		/*	Set up the stream (namely data channel) for the file	*/
		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(originalFilePath)));
				BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(copyFilePath)))) {
			
			/*	
			 * 	Read and write data simultaneously to copy the file	
			 * 	1. Use an int-type data to record the actual read-in data length
			 *  2. Use while loop to completely copy the file
			 *     -- When read to the end of the file, it will return -1
			 *     -- After read the data, write whatever is read, until the loop is over	
			 */
			int lengthOfActualReadInData = 0;
			while ((lengthOfActualReadInData = bufferedInputStream.read()) != -1) {
				bufferedOutputStream.write((char) lengthOfActualReadInData);
			}
			
			/*	Close the stream: release the resource (i.e., the files)	 */
//			bufferedOutputStream.close();
//			bufferedInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
