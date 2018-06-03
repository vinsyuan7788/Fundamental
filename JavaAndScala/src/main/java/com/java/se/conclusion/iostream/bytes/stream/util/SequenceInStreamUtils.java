package com.java.se.conclusion.iostream.bytes.stream.util;

import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 	This is a class to implement sequence input stream utility methods
 * 
 * @author VinceYuan
 *
 */
public class SequenceInStreamUtils {

	/**
	 * 	This is a method to return an enumeration of instances of a data type that inherits InputStream
	 *  -- "<? extends InputStream>" regulates the input data type must be the child classes of InputStream
	 *  -- "T"
	 * @param inputStreamType
	 * @param filePaths
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Enumeration<T> concatInputStream(Class<? extends InputStream> inputStreamType, String[] filePaths) {
		
		try {
			/*	
			 * 	Instantiate an Object-typed vector to store the instances of a specified child class of InputStream
			 *  -- Why Object-typed: The instance created through reflection is Object-typed
			 */
			Vector<Object> inputStreamVector = new Vector<>();
			for (int i = 0; i < filePaths.length; i++) {
				inputStreamVector.add(inputStreamType.getConstructor(File.class).newInstance(new File(filePaths[i])));
			}
			
			/*	Return the enumeration from the vector	*/
			return (Enumeration<T>) inputStreamVector.elements();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*	If there is any exception, return null	*/
		return null;
	}
}
