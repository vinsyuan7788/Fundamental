package com.java.se.common.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 	This is a class to implement bean utility methods
 * 
 * @author VinceYuan
 *
 */
public class BeanUtils {
	
	/*	Necessary instance variables	*/
	private static volatile Map<Class<?>, Object> instanceMap = new HashMap<>();
	
	/**
	 * 	This is a method to create a singleton instance
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static final <T> T createSingletonInstance(Class<?> clazz) {
		
		try {
			/*	Get the instance from the map	*/
			T instance = (T) instanceMap.get(clazz);
			
			/*	If the instance is null, then create an instance	*/
			if (instance == null || instance.equals(null)) {
				synchronized (BeanUtils.class) {
					if (instance == null || instance.equals(null)) {
					    instance = (T) clazz.newInstance();
						instanceMap.put(clazz, instance);
						return instance;
					}
				}
			}
			
			/*	Otherwise return the instance	*/
			return instance;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*	If there is any exception, return null	*/
		return null;
	}
	
	/**
	 * 	This is a method to create a singleton instance
	 *  -- The order of field values MUST correspond to the order of fields declared inside the bean 
	 * @param clazz
	 * @param fieldValues
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static final <T> T createSingletonInstance(Class<?> clazz, Object... fieldValues) {
		
		try {
			/*	If there is no field values, throw an exception	 */
			if (fieldValues == null || fieldValues.length == 0) {
				throw new Exception("There must be at least one field value!");
			}
			
			/*	Get the instance from the map	*/
			T instance = (T) instanceMap.get(clazz);
			
			/*	If the instance is null, then create an instance	*/
			if (instance == null || instance.equals(null)) {
				synchronized (BeanUtils.class) {
					if (instance == null || instance.equals(null)) {
						instance = (T) clazz.newInstance();
						Field[] declaredFields = clazz.getDeclaredFields();
						for (int i = 0; i < declaredFields.length; i++) {
							declaredFields[i].setAccessible(true);
							declaredFields[i].set(instance, fieldValues[i]);
						}
						instanceMap.put(clazz, instance);
						return instance;
					}
				}
			}
			
			/*	Otherwise return the instance	*/
			return instance;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*	If there is any exception, return null	*/
		return null;
	}
}