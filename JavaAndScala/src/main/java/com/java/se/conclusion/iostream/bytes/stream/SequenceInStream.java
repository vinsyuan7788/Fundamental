package com.java.se.conclusion.iostream.bytes.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;

import com.java.se.common.utils.FileUtils;
import com.java.se.conclusion.iostream.bytes.stream.util.SequenceInStreamUtils;

/**
 * 	This is a class to implement sequence input stream
 *  -- Implemented functionality: concatenate files
 *  
 * @author VinceYuan
 *
 */
public class SequenceInStream {

	/**
	 * 	This is a static method to concatenate files using SequenceInputStream
	 * @param bufferSize
	 * @param originalFilePaths
	 * @param newFilePath
	 */
	public static void concatenateFiles(int bufferSize, String[] originalFilePaths, String newFilePath) {
		
		/*	Create a file if the file does not exist	*/
		FileUtils.createFileIfNotExists(newFilePath);
		
		/*	Prepare the input stream to be concatenated	 */
		Enumeration<FileInputStream> fileInputStreams = SequenceInStreamUtils.concatInputStream(FileInputStream.class, originalFilePaths);
		
		/*	Set up the sequence input stream & file output stream	*/
		try (SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStreams);
				FileOutputStream fileOutputStream = new FileOutputStream(new File(newFilePath))) {
			
			/*	
			 * 	Read & write data simultaneously to concatenate the file	
			 * 	1. Use a byte array to allow to read multiple data once
			 * 	2. Use an int-type data to record the actual read-in data length
			 *  3. Use while loop to completely copy the file
			 *     -- When read to the end of the file, it will return -1
			 *     -- After read the data, write whatever is read, until the loop is over	
			 */
			byte[] buffer = new byte[bufferSize];
			int lengthOfActualReadInData = 0;
			while ((lengthOfActualReadInData = sequenceInputStream.read(buffer)) != -1) {
				fileOutputStream.write(buffer, 0, lengthOfActualReadInData);
			}
			
			/*	Close the stream: release the resource (i.e., the files & the input streams to be concatenated)	 */
//			fileOutputStream.close();
//			sequenceInputStream.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
