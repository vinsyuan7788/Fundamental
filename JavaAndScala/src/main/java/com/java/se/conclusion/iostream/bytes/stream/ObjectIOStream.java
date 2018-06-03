package com.java.se.conclusion.iostream.bytes.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.java.se.common.utils.FileUtils;
import com.java.se.conclusion.iostream.bytes.common.User;

/**
 * 	This is a class to implement object IO stream
 *  -- Implemented functionality: write, read
 *  
 * @author VinceYuan
 *
 */
public class ObjectIOStream {
	
	/**
	 * 	This is a static method to write the object to a file with ObjectOutputStream
	 * 	-- Only the object implement Serializable interface can be written to file on disk
	 * @param object
	 * @param filePath
	 */
	public static void writeToFile(Serializable object, String filePath) {
		
		/*	Create a file if the file does not exist	*/
		FileUtils.createFileIfNotExists(filePath);
		
		/*	Set up the stream (namely data channel) for the file	*/
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(filePath)))) {
			
			/*	Write the object to the file	*/
			objectOutputStream.writeObject(object);
			
			/*	Close the stream: release the resource (i.e., the file)	 */
//			objectOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a static method to read the object from file on disk with ObjectInputStream
	 * @param filePath
	 */
	public static void readFromFile(String filePath) {
		
		/*	Set up the stream (namely data channel) for the file	*/
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(filePath)))) {
		
			/*	Read the object in the file	 */
			Object object = objectInputStream.readObject();
			if (object instanceof User) {
				object = (User) object;
			}
			System.out.println("The read object: " + object);
			System.out.println("The class of read object: " + object.getClass());
			
			/*	Close the stream: release the resource (i.e., the file)	 */
//			objectInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
