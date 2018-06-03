package com.java.se.conclusion.annotation.utils;

import java.lang.reflect.Field;

import com.java.se.conclusion.annotation.annotations.InjectValueForInteger;
import com.java.se.conclusion.annotation.annotations.InjectValueForString;


/**
 * 	This is a class to parse multiple field annotation using reflection
 *  1. For each field, if there is desired field annotation, then do the injection through reflection
 *     -- Otherwise do nothing
 * 	2. This code explains why annotation DI does not need setter|getter: due to reflection
 * 
 * @author VinceYuan
 *
 */
public class FieldAnnotationParser {

	/**
	 * 	This is a method to inject values to the fields
	 * @param instance
	 * @throws Exception
	 */
	public static void injectValuesToFields(Object instance) {
		
		try {
			/*	Get all the declared fields from the instance	*/
			Field[] fields = instance.getClass().getDeclaredFields();
			
			/*	Traverse the declared fields	 */
			for (Field field : fields) {
				
				/*	Set accessible to ALL fields (including the private fields)	 */
				field.setAccessible(true);
				
				/*	If there is a desired annotation above the field, continue	*/
				if (field.isAnnotationPresent(InjectValueForInteger.class)) {
				
					/*	Get the annotation class	*/
					InjectValueForInteger injectValueForInteger = field.getAnnotation(InjectValueForInteger.class);
					
					/*	Do the injection through reflection	 */
					field.set(instance, injectValueForInteger.value());
					
				/*	If there is a desired annotation above the field, continue	*/
				} else if (field.isAnnotationPresent(InjectValueForString.class)) {
					
					/*	Get the annotation class	*/
					InjectValueForString injectValueForString = field.getAnnotation(InjectValueForString.class);
					
					/*	Do the injection through reflection	 */
					field.set(instance, injectValueForString.value());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
