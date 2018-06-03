package com.java.se.conclusion.annotation.utils;

import com.java.se.conclusion.annotation.annotations.IsClassSingleton;
import com.java.se.conclusion.design.factory.singleton.LazySingletonFactory;

/**
 * 	This is a class to parse one class annotation using reflection
 * 	1. If there is a @ClassAnnotation & "singleton=true": return a singleton instance
 *  2. If there is a @ClassAnnotation & "singleton=false": return a multiton instance
 *  3. If there is no @ClassAnnotation: return a multiton instance
 * 
 * @author VinceYuan
 *
 */
public class ClassAnnotationParser {

	/**
	 * 	This is a method to get an instance from a class
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static Object getInstance(Class<?> clazz) {
		
		try {
			/*	If there is a @IsClassSingleton annotation, continue	 */
			if (clazz.isAnnotationPresent(IsClassSingleton.class)) {
				
				/*	Get the annotation class	*/
				IsClassSingleton isClassSingleton = (IsClassSingleton) clazz.getAnnotation(IsClassSingleton.class);
				
				/*	If "singleton=true", then return a singleton instance	*/
				if (isClassSingleton.singleton() == true) {
					return LazySingletonFactory.getInstance(clazz);
				
				/*	Else return a multiton instance	 */
				} else {
					return clazz.newInstance();
				}
				
			/*	If there is no @IsClassSingleton annotation: return a multiton instance	 */
			} else {
				return clazz.newInstance();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		/*	If any exception is caught, return null	 */
		return null;
	}
}
