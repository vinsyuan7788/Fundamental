package com.java.se.conclusion.design.factory.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 	This is a class to implement text configuration factory pattern
 * 
 * 	Assuming the text configuration file follows the following rules:
 * 	-- The 1st line: provide the full class name of the class that needs to be instantiated
 * 	-- The following line: provide the field value for each field of the class that needs to be instantiated
 *  
 * @author VinceYuan
 *
 */
public class TxtConfigurationFactory {

	/**
	 * 	This is a method to get the instance from a specific text configuration file
	 *  -- Read the text configuration file by a character stream reader
	 *  -- Get the instance and inject the field values according to read contents
	 *     -- Get the Class object from the 1st line of the text configuration file
	 *     -- Get the instance from the Class object
	 *     -- Inject the values to the fields by reading the rest of the text configuration file
	 *  -- Close the reader and return the instance
	 * @param txtConfigFileName
	 * @return
	 */
	public static Object getInstance(String configFileName) {
		
		try {
			/*	Read the text configuration file	*/
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/main/java/com/java/se/conclusion/design/factory/configuration/config/" + configFileName + ".txt")));
			
			/*	Get the Class object from the full class name provided by the 1st line	*/
			Class<?> clazz = Class.forName(bufferedReader.readLine());
			
			/*	Get the instance from the Class object	*/
			Constructor<?> constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);			// Set to allow to access private constructors
			Object object = constructor.newInstance();
			
			/*	Read the following lines & set the value for each field	 */
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				String[] fieldInfo = line.split("=");
				Field field = clazz.getDeclaredField(fieldInfo[0]);
				field.setAccessible(true);				// Set to allow to access private fields
				if (field.getType() == int.class || field.getType() == Integer.class) {
					field.set(object, Integer.parseInt(fieldInfo[1]));
				} 
				if (field.getType() == char.class || field.getType() == Character.class) {
					field.set(object, fieldInfo[1].charAt(0));
				}
				if (field.getType() == String.class) {
					field.set(object, fieldInfo[1]);
				}
			}
			
			/*	Close the reader	*/
			bufferedReader.close();
			
			/*	Return the instance	 */
			return object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*	If there is any exception, return null	*/
		return null;
	}
}
