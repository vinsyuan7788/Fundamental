package com.java.se.conclusion.collection.nested;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.java.se.conclusion.collection.nested.common.PhoneNumber;
import com.java.se.conclusion.reflection.common.util.ReflectionUtils;

/**
 * 	This is a class to test if the map key is a map
 * 
 * @author VinceYuan
 *
 */
public class TestMapKey {

	/*	Necessary instance variables	*/
	private Map<String, Class<?>[]> methodNameAndParameterTypeMap;
	private Map<Map<String, Class<?>[]>, Object[]> methodArgumentMap = new HashMap<>();
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestMapKey testMapKey = new TestMapKey();
		testMapKey.testPreparation();
		testMapKey.testMap();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		
		/*	Initialize some data	*/
		methodNameAndParameterTypeMap = new HashMap<>();
		methodNameAndParameterTypeMap.put("setId", new Class[] { String.class });
		methodArgumentMap.put(methodNameAndParameterTypeMap, new Object[] { "123456789" });
		methodNameAndParameterTypeMap = new HashMap<>();
		methodNameAndParameterTypeMap.put("setUsername", new Class[] { String.class });
		methodArgumentMap.put(methodNameAndParameterTypeMap, new Object[] { "Vince" });
		methodNameAndParameterTypeMap = new HashMap<>();
		methodNameAndParameterTypeMap.put("setPhoneNumber", new Class[] { Integer.class });
		methodArgumentMap.put(methodNameAndParameterTypeMap, new Object[] { 27 });
		methodNameAndParameterTypeMap = new HashMap<>();
		methodNameAndParameterTypeMap.put("setLastLocation", new Class[] { String.class });
		methodArgumentMap.put(methodNameAndParameterTypeMap, new Object[] { "PA" });
	}
	
	/**
	 * 	Test Map
	 */
	private void testMap() {
				
		try {
			/*	Traverse the map	*/
			System.out.println("Entry number: " + methodArgumentMap.size());
			System.out.println("Each entry information:");
			Set<Entry<Map<String, Class<?>[]>, Object[]>> methodArgumentSet = methodArgumentMap.entrySet();
			for (Entry<Map<String, Class<?>[]>, Object[]> methodArguments : methodArgumentSet) {
				Set<Entry<String, Class<?>[]>> methodNameAndParameterTypeSet = methodArguments.getKey().entrySet();
				for (Entry<String, Class<?>[]> methodNameAndParameterTypes : methodNameAndParameterTypeSet) {
					System.out.println("{ " + methodNameAndParameterTypes.getKey() + " " + methodNameAndParameterTypes.getValue() + " } " + methodArguments.getValue());
				}
			}
			
			/*	Invoke the methods using reflection	 */
			PhoneNumber phoneNumber = PhoneNumber.class.newInstance();
			ReflectionUtils.invokeMethods(phoneNumber.getClass(), phoneNumber, methodArgumentMap);
			System.out.println("\nThe phone number: " + phoneNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
