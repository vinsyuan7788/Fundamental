package com.java.se.conclusion.iostream.character.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.java.se.common.utils.FileUtils;

/**
 * 	This is a class to implement buffered reader and writer
 *  -- Implemented functionality: write, read, copy
 *  
 * @author VinceYuan
 *
 */
public class BufferedReaderWriter {

	/**
	 * 	This is a static method to write the data to a file on disk using BufferedWriter
	 * 	-- BufferedWriter extends the ability: "newLine()"
	 * @param data
	 * @param filePath
	 */
	public static void writeToFile(String data, String filePath) {
		
		/*	Create a file if the file does not exist	*/
		FileUtils.createFileIfNotExists(filePath);
		
		/*	Set up the stream (namely data channel) for the file	*/
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(filePath)))) {
			
			/*	
			 * 	Write the data to the file
			 * 	-- The data written to the file will completely cover the previous data in the file
			 *     -- If want to append new data in the existing file, use "new FileWriter(file, true)" as the argument for BufferedWriter constructor
			 *  -- When to actually write out the data to a file (i.e., flush out the data from the internal buffer to a file) 
			 *     -- When invoke "flush()" (refer to source code)
			 *     -- When the internal buffer is full, then flush out the data automatically (refer to source code)
			 *     -- When invoke "close()", it will flush the data before closing the stream (refer to source code)  	
			 */
			bufferedWriter.write(data);		
//			bufferedWriter.flush();			// If need to flush out the data without closing the stream, invoke this method

			/*	Close the stream: release the resource (i.e., the file)	 */
//			bufferedWriter.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a static method to read a file from disk using BufferedReader
	 * 	-- BufferedReader extends the ability: "readLine()"
	 * @param filePath
	 */
	public static void readFromFile(String filePath) {
		
		/*	Set up the stream (namely data channel) for the file	*/
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)))) {
		
			/*	
			 * 	Read the data in the file
			 * 	1. Use an String-type data to record the actual read-in data line
			 *  2. Use while loop to completely read the file
			 *     -- When read to the end of the file, it will return -1	
			 */
			String lineOfActualReadInData = null;
			while ((lineOfActualReadInData = bufferedReader.readLine()) != null) {
				System.out.println(lineOfActualReadInData);
			}
			
			/*	Close the stream: release the resource (i.e., the file)	 */
//			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a static method to copy a file using both BufferedReader and BufferedWriter
	 * @param bufferSize
	 * @param originalFilePath
	 * @param copyFilePath
	 */
	public static void copyFile(String originalFilePath, String copyFilePath) {
		
		/*	Create a file if the file does not exist	*/
		FileUtils.createFileIfNotExists(copyFilePath);
		
		/*	Set up the stream (namely data channel) for the file	*/
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(originalFilePath)));
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(copyFilePath)))) {
		
			/*	
			 * 	Read and write data simultaneously to copy the file	
			 * 	1. Use an String-type data to record the actual read-in data line
			 *  2. Use while loop to completely copy the file
			 *     -- When read to the end of the file, it will return -1
			 *     -- After read the data, write whatever is read, until the loop is over	
			 */
			String lineOfActualReadInData = null;
			while ((lineOfActualReadInData = bufferedReader.readLine()) != null) {
				bufferedWriter.write(lineOfActualReadInData);
			}
			
			/*	Close the stream: release the resource (i.e., the files)	 */
//			bufferedWriter.close();
//			bufferedReader.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
