package com.java.se.common.utils;

import java.util.Collection;

/**
 * 	This is a class to implement Collection utility methods
 * 
 * @author VinceYuan
 *
 */
public class CollectionUtils {

	/**
	 * 	This is a method to concatenate the elements to a string
	 * @param collection
	 * @return
	 */
	public final static <T extends Collection<?>> String toString(T collection) {
		
		/*	Initialize a string buffer	*/
		StringBuffer stringBuffer = new StringBuffer();
		
		/*	Concatenate the elements to a string	*/
		int index = 0;
		for (Object element : collection) {
			if (index > 0) stringBuffer.append(", ");
			stringBuffer.append(element);
			index++;
		}
		
		/*	Return the string	*/
		return stringBuffer.toString();
	}
}
