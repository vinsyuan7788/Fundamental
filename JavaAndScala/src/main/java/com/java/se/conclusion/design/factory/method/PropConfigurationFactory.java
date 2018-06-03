package com.java.se.conclusion.design.factory.method;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * 	This is a class to implement factory method pattern
 *  -- This class must implement a parent interface
 *  
 * 	Assuming the properties configuration file follows the following rules:
 * 	-- For the class: property name is "class" and value is the full class name of the class that needs to be instantiated
 * 	-- For the field: property name is the field name and value is the field value for the field of the class that needs to be instantiated
 *  
 * @author VinceYuan
 *
 */
public class PropConfigurationFactory implements ConfigurationFactory {

	/**
	 * 	Override the factory method to get an instance from a specific properties file
	 *  -- Read the properties configuration file
	 *  -- Get the instance and inject the field values according to read contents
	 *     -- Get the Class object from the value of "class" property
	 *     -- Get the instance from the Class object
	 *     -- Inject the values to the fields by iterating the rest of the property names
	 *  -- Return the instance
	 */
	@Override
	public Object getInstance(String configFileName) {
		
		try {
			/*	Read the property file	*/
			Properties properties = new Properties();
			properties.load(new BufferedInputStream(new FileInputStream("src/main/java/com/java/se/conclusion/design/factory/method/config/" + configFileName + ".properties")));
			
			/*	Get the Class object from the full class name from "class" property	 */
			Class<?> clazz = Class.forName(properties.getProperty("class"));
			
			/*	Get the instance from the Class object	*/
			Constructor<?> constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);			// Set to allow to access private constructors
			Object object = constructor.newInstance();
			
			/*	Iterate the property names to set the value for each field	*/
			for (String propertyName : properties.stringPropertyNames()) {
				if (propertyName != "class" && !propertyName.equals("class")) {
					Field field = clazz.getDeclaredField(propertyName);
					field.setAccessible(true);				// Set to allow to access private fields
					if (field.getType() == int.class || field.getType() == Integer.class) {
						field.set(object, Integer.parseInt(properties.getProperty(propertyName)));
					} 
					if (field.getType() == char.class || field.getType() == Character.class) {
						field.set(object, properties.getProperty(propertyName).charAt(0));
					}
					if (field.getType() == String.class) {
						field.set(object, properties.getProperty(propertyName));
					}
				}
			}
			
			/*	Return the instance	 */
			return object;
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*	If there is any exception, return null	*/
		return null;
	}
}
