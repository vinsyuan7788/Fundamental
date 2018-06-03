package com.java.se.conclusion.reflection.common.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

/**
 * 	This is a class to implement reflection utility methods
 * 
 * @author VinceYuan
 *
 */
public class ReflectionUtils {
	
	/*	Necessary instance variables	*/
	private static StringBuffer stringBuffer;

	/**
	 * 	This is a method to get the information of a class or an interface
	 * @param clazz
	 * @return
	 */
	public static String getClassOrInterfaceInfo(Class<?> clazz) {
		
		/*	Initialize a string buffer	*/
		stringBuffer = new StringBuffer();
		
		/*	Get the modifier information: which includes "interface"	 */
		stringBuffer.append(Modifier.toString(clazz.getModifiers()));
		
		/*	If it is interface, then skip a whitespace, otherwise append a "class"	*/
		if (clazz.isInterface()) {
			stringBuffer.append(" ");
		} else {
			stringBuffer.append(" class ");
		}
		
		/*	Append the name of the class or interface	*/
		stringBuffer.append(clazz.getSimpleName());
		
		/*	Return the information as a string	*/
		return processReturnString(stringBuffer);
	}
	
	/**
	 * 	This is a method to get the information of all type parameters of a class or an interface
	 * @param clazz
	 * @return
	 */
	public static String getTypeParameterInfo(Class<?> clazz) {
		
		/*	Initialize a string buffer	*/
		stringBuffer = new StringBuffer();
		
		/*	Get the information of all type parameters of the class or interface	*/
		TypeVariable<?>[] typeParameters = clazz.getTypeParameters();
		getTypeParameterInfoUtil(stringBuffer, typeParameters);
		
		/*	Return the information as a string	*/
		return processReturnString(stringBuffer);
	}
	
	/**
	 * 	This is a method to get the information of the parent class of a class
	 * @param clazz
	 * @return
	 */
	public static String getSuperClassInfo(Class<?> clazz) {
		
		/*	If it is an interface, then return an empty string	*/
		if (clazz.isInterface()) return "";
		
		/*	If it is a class, then initialize a string buffer	*/
		stringBuffer = new StringBuffer();
		
		/*	Get the name and all type parameters of the parent class	*/
		Class<?> superClass = clazz.getSuperclass();
		stringBuffer.append(superClass.getSimpleName());
		TypeVariable<?>[] typeParameters = superClass.getTypeParameters();
		getTypeParameterInfoUtil(stringBuffer, typeParameters);
		
		/*	Return the information as a string	*/
		return processReturnString(stringBuffer);
	}
	
	/**
	 * 	This is a method to get the information of the implemented interfaces by a class or an interface
	 * @param clazz
	 * @return
	 */
	public static String getImplementedInterfaceInfo(Class<?> clazz) {
		
		/*	Initialize a string buffer	*/
		stringBuffer = new StringBuffer();
		
		/*	Get the names and all type parameters of all implemented interfaces	 */
		Class<?>[] interfaces = clazz.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			if (i > 0) stringBuffer.append(", ");
			stringBuffer.append(interfaces[i].getSimpleName());
			TypeVariable<?>[] typeParameters = interfaces[i].getTypeParameters();
			getTypeParameterInfoUtil(stringBuffer, typeParameters);
		}
		
		/*	Return the information as a string	*/
		return processReturnString(stringBuffer);
	}
	
	/**
	 * 	This is a method to get the information of constructors
	 * @param constructors
	 * @return
	 */
	public static String getConstructorInfo(Constructor<?>[] constructors) {
		
		/*	Initialize a string buffer	*/
		stringBuffer = new StringBuffer();
		
		/*	Get the information of constructors	 */
		for (int i = 0; i < constructors.length; i++) {
			if (i > 0) stringBuffer.append("\n");
			stringBuffer.append(Modifier.toString(constructors[i].getModifiers()) + " " + constructors[i].getName().split("\\.")[constructors[i].getName().split("\\.").length - 1]);
			Parameter[] parameters = constructors[i].getParameters();
			getParameterInfoUtil(stringBuffer, parameters);
			stringBuffer.append(" { // This is a " + constructors[i].getParameterCount() + "-parameter constructor... }");
		}
		
		/*	Return the information as a string	*/
		return processReturnString(stringBuffer);
	}
	
	/**
	 * 	This is a method to get the information of fields
	 * @param fields
	 * @return
	 */
	public static String getFieldInfo(Field[] fields) {
		
		/*	Initialize a string buffer	*/
		stringBuffer = new StringBuffer();
		
		/*	Get the information of fields	*/
		for (int i = 0; i < fields.length; i++) {
			if (i > 0) stringBuffer.append("\n");
			stringBuffer.append(Modifier.toString(fields[i].getModifiers()) + " " + fields[i].getType().getSimpleName() + " " + fields[i].getName());
		}
		
		/*	Return the information as a string	*/
		return processReturnString(stringBuffer);
	}
	
	/**
	 * 	This is a method to get the information of methods
	 * @param methods
	 * @return
	 */
	public static String getMethodInfo(Method[] methods) {
		
		/*	Initialize a string buffer	*/
		stringBuffer = new StringBuffer();
		
		/*	Get the information of methods	 */
		for (int i = 0; i < methods.length; i++) {
			if (i > 0) stringBuffer.append("\n");
			stringBuffer.append(Modifier.toString(methods[i].getModifiers()) + " " + methods[i].getReturnType().getSimpleName() + " " + methods[i].getName());
			Parameter[] parameters = methods[i].getParameters();
			getParameterInfoUtil(stringBuffer, parameters);
			stringBuffer.append(" { // This is a " + methods[i].getParameterCount() + "-parameter method... }");
		}
		
		/*	Return the information as a string	*/
		return processReturnString(stringBuffer);
	}
	
	/**
	 * 	This is a method to get the information of annotation of a class or an instance
	 * @param clazz
	 * @return
	 */
	public static String getAnnotationInfo(Class<?> clazz) {
		
		/*	Initialize a string buffer	*/
		stringBuffer = new StringBuffer();
		
		/*	Initialize 2 maps to count the annotations and declared annotations respectively	*/
		Map<String, String> annotationCount = new HashMap<String, String>();
		Map<String, String> declaredAnnotationCount = new HashMap<String, String>();
		countAnnotation(annotationCount, declaredAnnotationCount, clazz.getAnnotations(), clazz.getDeclaredAnnotations());
		for (Constructor<?> constructor : clazz.getConstructors()) {
			countAnnotation(annotationCount, declaredAnnotationCount, constructor.getAnnotations(), constructor.getDeclaredAnnotations());
		}
		for (Field field : clazz.getDeclaredFields()) {
			countAnnotation(annotationCount, declaredAnnotationCount, field.getAnnotations(), field.getDeclaredAnnotations());
		}
		for (Method method : clazz.getDeclaredMethods()) {
			countAnnotation(annotationCount, declaredAnnotationCount, method.getAnnotations(), method.getDeclaredAnnotations());
		}
		
		/*	Get the information of count result	 */
		int index = 0;
		stringBuffer.append("The annotaions present on any element of this class:\n");
		for (Iterator<Entry<String, String>> iterator = annotationCount.entrySet().iterator(); iterator.hasNext();) {
			if (index > 0) stringBuffer.append("\n");
			Entry<String, String> entry = iterator.next();
			stringBuffer.append(entry.getValue() + " " + entry.getKey() + " { ... }");
			index++;
		}
		index = 0;
		stringBuffer.append("\nThe annotaions DIRECTLY present on any element of this class:\n");
		for (Iterator<Entry<String, String>> iterator = declaredAnnotationCount.entrySet().iterator(); iterator.hasNext();) {
			if (index > 0) stringBuffer.append("\n");
			Entry<String, String> entry = iterator.next();
			stringBuffer.append(entry.getValue() + " " + entry.getKey() + " { ... }");
			index++;
		}
		
		/*	Return the information as a string	*/
		return processReturnString(stringBuffer);
	}
	
	/**
	 * 	This is a method to set values to fields of the class
	 * @param clazz
	 * @param instance
	 * @param fieldValues
	 */
	public static <T> void setValuesToFields(Class<?> clazz, T instance, Map<String, Object> fieldValueMap) {
		
		try {
			/*	Set values to fields of the class	*/
			Set<Entry<String, Object>> fieldNameAndValueSet = fieldValueMap.entrySet();
			for (Entry<String, Object> fieldNameAndValue : fieldNameAndValueSet) {
				Field declaredField = clazz.getDeclaredField(fieldNameAndValue.getKey());
				declaredField.setAccessible(true);
				declaredField.set(instance, fieldNameAndValue.getValue());
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a method to invoke methods of the class
	 * @param clazz
	 * @param instance
	 * @param methodArgumentMap
	 */
	public static <T> void invokeMethods(Class<?> clazz, T instance, Map<Map<String, Class<?>[]>, Object[]> methodArgumentMap) {
		
		try {
			/*	Invoke methods of the class	 */
			Set<Entry<Map<String, Class<?>[]>, Object[]>> metdhoArgumentSet = methodArgumentMap.entrySet();
			for (Entry<Map<String, Class<?>[]>, Object[]> methodArguments : metdhoArgumentSet) {
				Set<Entry<String, Class<?>[]>> metehodNameAndParameterTypeSet = methodArguments.getKey().entrySet();
				for (Entry<String, Class<?>[]> methodNameAndParameterTypes : metehodNameAndParameterTypeSet) {
					Method declaredMethod = clazz.getDeclaredMethod(methodNameAndParameterTypes.getKey(), methodNameAndParameterTypes.getValue());
					declaredMethod.setAccessible(true);
					declaredMethod.invoke(instance, methodArguments.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a method that extracts the logic that gets the information of all type parameters
	 * @param stringBuffer
	 * @param typeParameters
	 */
	private static void getTypeParameterInfoUtil(StringBuffer stringBuffer, TypeVariable<?>[] typeParameters) {
		
		/*	Get the information of all type parameters	 */
		for (int i = 0; i < typeParameters.length; i++) {
			if (i > 0) stringBuffer.append(", ");
			if (i == 0) stringBuffer.append("<");
			stringBuffer.append(typeParameters[i].getName());
			if (i == typeParameters.length - 1) stringBuffer.append(">");
		}
	}
	
	/**
	 * 	This is a method that extracts the logic that gets the information of all parameters
	 * @param stringBuffer
	 * @param parameters
	 */
	private static void getParameterInfoUtil(StringBuffer stringBuffer, Parameter[] parameters) {
		
		/*	Get the information of all parameters	*/
		stringBuffer.append("(");
		for (int i = 0; i < parameters.length; i++) {
			if (i > 0) stringBuffer.append(", ");
			stringBuffer.append(parameters[i].getType().getSimpleName() + " " + parameters[i].getName());
		}
		stringBuffer.append(")");
	}
	
	/**
	 * 	This is a method that extracts the logic that counts the annotations and declared annotations
	 * @param annotationCount
	 * @param declaredAnnotationCount
	 * @param annotations
	 * @param declaredAnnotations
	 */
	private static void countAnnotation(Map<String, String> annotationCount, Map<String, String> declaredAnnotationCount, Annotation[] annotations, Annotation[] declaredAnnotations) {
		
		/*	For loop to count the annotations	*/
		for (Annotation annotation : annotations) {
			if (!annotationCount.containsKey(annotation.annotationType().getSimpleName())) {
				annotationCount.put(annotation.annotationType().getSimpleName(), Modifier.toString(annotation.annotationType().getModifiers()));
			} 
		}
		
		/*	For loop to count the declared annotations	*/
		for (Annotation annotation : declaredAnnotations) {
			if (!declaredAnnotationCount.containsKey(annotation.annotationType().getSimpleName())) {
				declaredAnnotationCount.put(annotation.annotationType().getSimpleName(), Modifier.toString(annotation.annotationType().getModifiers()));
			}
		}
	}
	
	/**
	 * 	This is a method to process the return string
	 * @param stringBuffer
	 * @return
	 */
	private static String processReturnString(StringBuffer stringBuffer) {
		
		/*	If the return string is null string, then return a message	*/
		if (stringBuffer.toString().trim() == "" || stringBuffer.toString().trim().equals("")) {
			return "";
			
		/*	Else return the string	*/
		} else {
			return stringBuffer.toString().trim();
		}
	}
}
