package com.java.se.conclusion.iostream.character.stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.java.se.common.utils.FileUtils;

/**
 * 	This is a class to implement file reader and writer
 *  -- Implemented functionality: write, read, copy
 *  
 * @author VinceYuan
 *
 */
public class FileReaderWriter {

	/**
	 * 	This is a static method to write the data to a file on disk using FileWriter
	 * 	-- Inside FileWriter, there is a cache buffer (refer to source code), so may need to invoke "flush()" to write the data out
	 * @param data
	 * @param filePath
	 */
	public static void writeToFile(String data, String filePath) {
		
		/*	Create a file if the file does not exist	*/
		FileUtils.createFileIfNotExists(filePath);
		
		/*	Set up the stream (namely data channel) for the file	*/
		try (FileWriter fileWriter = new FileWriter(new File(filePath))) {
		
			/*	
			 * 	Write the data to the file
			 * 	-- The data written to the file will completely cover the previous data in the file
			 *     -- If want to append new data in the existing file, use the constructor "new FileWriter(file, true)"	
			 *  -- When to actually write out the data to a file (i.e., flush out the data from the internal buffer to a file) 
			 *     -- When invoke "flush()" (refer to source code)
			 *     -- When the internal buffer is full, then flush out the data automatically (refer to source code)
			 *     -- When invoke "close()", it will flush the data before closing the stream (refer to source code)
			 */
			fileWriter.write(data);	
//			fileWriter.flush();				// If need to flush out the data without closing the stream, invoke this method
			
			/*	Close the stream: release the resource (i.e., the file)	 */
//			fileWriter.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a static method to read a file from disk using FileReader
	 *  -- Buffer + while loop is a relatively better way to read files
	 *     -- More time-efficient & less CPU-consuming at the cost of space (namely buffer)
	 *  -- FileReader will automatically process the encoding and decoding
	 * @param bufferSize
	 * @param filePath
	 */
	public static void readFromFile(int bufferSize, String filePath) {
		
		/*	Set up the stream (namely data channel) for the file	*/
		try (FileReader fileReader = new FileReader(new File(filePath))) {
			
			/*	
			 * 	Read the data in the file
			 * 	1. Use a character array to allow to read multiple data once
			 * 	2. Use an int-type data to record the actual read-in data length
			 *  3. Use while loop to completely read the file
			 *     -- When read to the end of the file, it will return -1	
			 */
			char[] buffer = new char[bufferSize];
			int lengthOfActualReadInData = 0;
			while ((lengthOfActualReadInData = fileReader.read(buffer)) != -1) {
				System.out.print(new String(buffer, 0, lengthOfActualReadInData));
			}
			
			/*	Close the stream: release the resource (i.e., the file)	 */
//			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a static method to copy a file using both FileReader and FileWriter
	 * @param bufferSize
	 * @param originalFilePath
	 * @param copyFilePath
	 */
	public static void copyFile(int bufferSize, String originalFilePath, String copyFilePath) {
		
		/*	Create a file if the file does not exist	*/
		FileUtils.createFileIfNotExists(copyFilePath);
		
		/*	Set up the stream (namely data channel) for the file	*/
		try (FileReader fileReader = new FileReader(new File(originalFilePath));
				FileWriter fileWriter = new FileWriter(new File(copyFilePath))) {
		
			/*	
			 * 	Read and write data simultaneously to copy the file	
			 * 	1. Use a character array to allow to read multiple data once
			 * 	2. Use an int-type data to record the actual read-in data length
			 *  3. Use while loop to completely copy the file
			 *     -- When read to the end of the file, it will return -1
			 *     -- After read the data, write whatever is read, until the loop is over	
			 */
			char[] buffer = new char[bufferSize];
			int lengthOfActualReadInData = 0;
			while ((lengthOfActualReadInData = fileReader.read(buffer)) != -1) {
				fileWriter.write(buffer, 0, lengthOfActualReadInData);
			}
			
			/*	Close the stream: release the resource (i.e., the files)	 */
//			fileWriter.close();
//			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
