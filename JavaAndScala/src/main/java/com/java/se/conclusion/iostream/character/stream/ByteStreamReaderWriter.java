package com.java.se.conclusion.iostream.character.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.java.se.common.utils.FileUtils;

/**
 * 	This is a class to implement InputStreamReader and OutputStreanWriter
 * 	-- Can convert the byte IO stream to character IO stream
 *  -- Can specify the coding (encoding or decoding) rules (UTF-8, GBK, etc.)
 *  
 * @author VinceYuan
 *
 */
public class ByteStreamReaderWriter {

	/**
	 * 	This is a static method to write data to a file through OutputStreamWriter
	 * 	-- Use OutputStreamReader to convert the byte output stream to character output stream: byte output stream --> character output stream
	 *     -- Hence the characters can be written out becoming bytes: characters --> bytes
	 * @param data
	 * @param filePath
	 * @param charset
	 */
	public static void writeToFile(String data, String filePath, String charset) {
		
		/*	Create a file if the file does not exist	*/
		FileUtils.createFileIfNotExists(filePath);
		
		/*	
		 * 	Get an BufferedWriter instance from FileOutputStream through OutputStreamWriter
		 *  -- byte output stream --- (OutputStreamWriter) ---> character output stream	 
		 */
		try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(filePath)), charset))) {
			
			/*	
			 * 	Write the data to the file	 
			 * 	-- The data written to the file will completely cover the previous data in the file
			 *     -- If want to append new data in the existing file, use "new FileOutputStream(file, true)" for OutputStreamWriter constructor
			 *  -- When to actually write out the data to a file (i.e., flush out the data from the internal buffer to a file) 
			 *     -- When invoke "flush()" (refer to source code)
			 *     -- When the internal buffer is full, then flush out the data automatically (refer to source code)
			 *     -- When invoke "close()", it will flush the data before closing the stream (refer to source code) 
			 */
			bufferedWriter.write(data);
//			bufferedWriter.flush();			// If need to flush out the data without closing the stream, invoke this method
			
			/*	Close the stream: release the resource	*/
//			bufferedWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a static method to read the data from a file through InputStreamReader
	 * 	-- Use InputStreamReader to convert the byte input stream to character input stream: byte input stream --> character input stream
	 *     -- Hence the input bytes will be converted to characters: bytes --> characters
	 * @param filePath
	 * @param charset
	 */
	public static void readFromFile(String filePath, String charset) {
		
		/*	
		 * 	Get an BufferedReader instance from FileInputStream through InputStreamReader
		 * 	-- byte input stream --- (InputStreamReader) ---> character input stream
		 */
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)), charset))) {

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
	 * 	This is a static method to read line from console through InputStreamReader
	 * 	-- Use InputStreamReader to convert the byte input stream to character input stream: byte input stream --> character input stream
	 *     -- Hence the input bytes will be converted to characters: bytes --> characters
	 */
	public static void readFromConsole() {
		
		/*
		 * 	Get the BufferedReader instance from System input stream through InputStreamReader: 
		 * 	-- byte input stream --- (InputStreamReader) ---> character input stream
		 */
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
		
			/*	Loop to read whatever is input from console	 */
			System.out.println("Please input some words (Input \"exit\" to exit):");
			String lineOfActualReadInData = null;
			while ((lineOfActualReadInData = bufferedReader.readLine()) != null) {
				
				/*	If input is "exit", then exit the program	*/
				if (lineOfActualReadInData.equalsIgnoreCase("exit")) {
					break;
					
				/*	Else output whatever is input from console	*/
				} else {
					System.out.println(lineOfActualReadInData);
				}	
				System.out.println("Please input some words (Input \"exit\" to exit):");
			}
			
			/*	Close the stream: release the resource	*/
//			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
