package com.java.se.conclusion.annotation.utils;

import java.lang.reflect.Method;

import com.java.se.conclusion.annotation.annotations.IfGetMethodName;

/**
 * 	This is a class to parse one method annotation using reflection
 * 	1. For each method, if there is @IfGetMethodName & "getName=true", then get the method name
 *     -- Otherwise do nothing
 *     
 * @author VinceYuan
 *
 */
public class MethodAnnotationParser {

	/**
	 * 	This is a method to get the method name of all declared methods
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static String getMethodName(Class<?> clazz) {
		
		/*	Get all the methods from the class	 */
		Method[] declaredMethods = clazz.getDeclaredMethods();
		
		/*	Instantiate a string buffer to store all the method names	*/
		StringBuffer methodNames = new StringBuffer();
		
		/*	Traverse the declared methods	*/
		for (Method method : declaredMethods) {
			
			/*	Set accessible to ALL methods (including the private method)	*/
			method.setAccessible(true);
			
			/*	If there is a @IfGetMethodName annotation, continue	 */
			if (method.isAnnotationPresent(IfGetMethodName.class)) {
				
				/*	Get the annotation class	*/
				IfGetMethodName ifGetMethodName = method.getAnnotation(IfGetMethodName.class);
				
				/*	If "getName=true", then store the name to the string buffer	 */
				if (ifGetMethodName.getName() == true) {
					if (methodNames.length() > 0) methodNames.append(", ");
					methodNames.append(method.getName());
				}
			}
		}
		
		/*	Return the string converted from string buffer	 */
		return methodNames.toString();
	}
}
