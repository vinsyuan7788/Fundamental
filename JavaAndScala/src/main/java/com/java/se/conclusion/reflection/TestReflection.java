package com.java.se.conclusion.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.java.se.conclusion.reflection.common.advice.AfterAdvice;
import com.java.se.conclusion.reflection.common.advice.BeforeAdvice;
import com.java.se.conclusion.reflection.common.bean.BigDataEngineer;
import com.java.se.conclusion.reflection.common.bean.parent.Programmer;
import com.java.se.conclusion.reflection.common.util.ClassAnnotationParser;
import com.java.se.conclusion.reflection.common.util.DynamicProxy;
import com.java.se.conclusion.reflection.common.util.MethodAnnotationParser;
import com.java.se.conclusion.reflection.common.util.ReflectionUtils;

/**
 * 	This is a class to test reflection
 * 
 *  Reflection mechanism: (*****)
 *  -- Document --- (save) ---> .java --- (compile) ---> .class --- (JVM) ---> stored in the method area --- (use reflection to get object of 
 *     Class, Constructor, Field, Method, TypeParameter, Annotation, etc.) ---> create instances, inject values, invoke methods, parse annotations, etc.
 *  
 *  Reflection is widely applied on:
 *  -- Development of server: Tomcat, JBoss, etc.
 *  -- Development of frameworks: Spring, etc.
 *  -- Any scenario that requires custom and flexible programming, etc.
 *  
 * @author VinceYuan
 *
 */
public class TestReflection {
	
	/*	Necessary instance variables	*/
	private Class<?> clazz;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestReflection testReflection = new TestReflection();
		testReflection.testPreparation();
		System.out.println("Here tests creating instances through reflection:");
		testReflection.testCreateInstances();
		System.out.println("\nHere tests getting constructors through reflection:");
		testReflection.testGetConstructors();
		System.out.println("\nHere tests getting fields through reflection:");
		testReflection.testGetFields();
		System.out.println("\nHere tests getting methods through reflection:");
		testReflection.testGetMethods();
		System.out.println("\nHere tests getting annotations through reflection:");
		testReflection.testGetAnnotation();
		System.out.println("\nHere tests dynamic proxy through reflection:");
		testReflection.testDynamicProxy();
	}
	
	/**
	 * 	This is a method for test preparation
	 *  -- Get the Class instance using reflection
	 *  -- Get the information of the Class instance (or the class)
	 */
	private void testPreparation() {
		
		try {
			/*	There are 3 ways to get the Class instance	*/
			clazz = Class.forName("com.java.se.conclusion.reflection.common.bean.BigDataEngineer");
			clazz = BigDataEngineer.class;
			clazz = new BigDataEngineer().getClass();
			
			/*	Get the information of the Class instance (or the class)	*/
			String classInfo = ReflectionUtils.getClassOrInterfaceInfo(clazz);
			String typeParameterInfo = ReflectionUtils.getTypeParameterInfo(clazz);
			String superClassInfo = ReflectionUtils.getSuperClassInfo(clazz);
			String interfaceInfo = ReflectionUtils.getImplementedInterfaceInfo(clazz);
			StringBuffer stringBuffer = new StringBuffer(classInfo + typeParameterInfo + " extends " + superClassInfo + 
					" implements " + interfaceInfo + " { ... }\n");
			System.out.println("The information of the class is shown below:\n" + stringBuffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	Test to create instance
	 *  -- Create instances from the Class instance 
	 */
	private void testCreateInstances() {
		
		try {
			/*	
			 * 	Create instances from the Class instance
			 *  -- "class.newInstance()" invokes the parameterless constructor by default
			 */
			BigDataEngineer vince = (BigDataEngineer) clazz.newInstance();
			BigDataEngineer violet = (BigDataEngineer) clazz.newInstance();
			
			/*	Set the field values and output instance information	*/
			vince.setId("550E8400-E29B-11D4-A716-446655440000");
			vince.setName("Vince");
			vince.setAge(27);
			vince.setSalary(200000.00);
			violet.setId("550E8400-E29B-11D4-A716-446655440000");
			violet.setName("Violet");
			violet.setAge(25);
			violet.setSalary(200000.00);
			System.out.println("Instances created through class:");
			System.out.println("The big data engineer: " + vince);
			System.out.println("The big data engineer: " + violet);
			System.out.println("If vince and violet reference the same instance? " + ((vince == violet) && (vince.equals(violet))));
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * 	Test to get constructors from Class instance
	 *  -- Get the information of constructors
	 *  -- Create instances from constructors
	 */
	private void testGetConstructors() {
		
		try {
			/*	
			 * 	Get the information of constructors
			 * 	-- Usually use "clazz.getConstructors()" since if a constructor is not public, it is not wished to be used and no need to get it
			 *     -- "clazz.getConstructors()" does not include parent constructors
			 */
			Constructor<?>[] constructors = clazz.getConstructors();
			String constructorInfo = ReflectionUtils.getConstructorInfo(constructors);
			System.out.println("The information of public constructors of the class is shown below:\n" + constructorInfo);
			Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
			constructorInfo = ReflectionUtils.getConstructorInfo(declaredConstructors);
			System.out.println("\nThe information of declared constructors of the class is shown below:\n" + constructorInfo);
			System.out.println("\nIf \"getConstructors()\" and \"getDeclaredConstructors()\" return the same number of constructors? " + (declaredConstructors.length == constructors.length));
			
			/*	Create instances from specific constructors of the class	*/
			BigDataEngineer vince = (BigDataEngineer) clazz.getConstructor(String.class, String.class, Integer.class, Double.class)
					.newInstance("550E8400-E29B-11D4-A716-446655440000", "Vince", 27, 200000.00);
			BigDataEngineer violet = (BigDataEngineer) clazz.getConstructor(String.class, String.class)
					.newInstance("550E8400-E29B-11D4-A716-446655440000", "Violet");
			System.out.println("\nInstances created through constructors:");
			System.out.println("The big data engineer: " + vince);
			System.out.println("The big data engineer: " + violet);
			System.out.println("If vince and violet reference the same instance? " + ((vince == violet) && (vince.equals(violet))));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	Test to get fields from the Class instance
	 *  -- Get the information of fields
	 *  -- Inject values to fields
	 */
	private void testGetFields() {
		
		try {
			/*
			 * 	Get the information of fields
			 *  -- Usually use "clazz.getDeclaredFields()" since the fields that needs to manipulated maybe private, default or protected due to encapsulation (one of OOP features)
			 *     -- "clazz.getDeclaredFields()" does not include the fields declared by its parent class
			 */
			Field[] fields = clazz.getFields();
			String fieldInfo = ReflectionUtils.getFieldInfo(fields);
			System.out.println("The information of public fields of the class is listed below:\n" + fieldInfo);
			Field[] declaredFields = clazz.getDeclaredFields();
			fieldInfo = ReflectionUtils.getFieldInfo(declaredFields);
			System.out.println("\nThe information of declared fields of the class is listed below:\n" + fieldInfo);
			System.out.println("\nIf \"getFields()\" and \"getDeclaredFields()\" return the same number of fields? " + (declaredFields.length == fields.length));
			
			/*	Inject values to fields of the class	*/
			BigDataEngineer vince = (BigDataEngineer) clazz.newInstance();
			Map<String, Object> fieldValueMap = new HashMap<>();
			fieldValueMap.put("id", "550E8400-E29B-11D4-A716-446655440000");
			fieldValueMap.put("name", "Vince");
			fieldValueMap.put("age", 27);
			fieldValueMap.put("salary", 200000.0);
			ReflectionUtils.setValuesToFields(clazz, vince, fieldValueMap);
			System.out.println("\nThe instance created with injecting values:");
			System.out.println("The big data engineer: " + vince);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	Test to get methods from the Class instance
	 *  -- Get the information of methods
	 *  -- Invoke methods
	 */
	private void testGetMethods() {
	
		try {
			/*
			 * 	Get the information of methods
			 *  -- Usually use "clazz.getDeclaredMethods()" since the methods that needs to manipulated maybe private, default or protected due to encapsulation (one of OOP features)
			 *     -- "clazz.getDeclaredMethods()" does not include the methods declared by its parent class
			 */
			Method[] methods = clazz.getMethods();
			String methodInfo = ReflectionUtils.getMethodInfo(methods);
			System.out.println("The information of public methods is listed below:\n" + methodInfo);
			Method[] declaredMethods = clazz.getDeclaredMethods();
			methodInfo = ReflectionUtils.getMethodInfo(declaredMethods);
			System.out.println("\nThe information of declared methods is listed below:\n" + methodInfo);
			System.out.println("\nIf \"getMethods()\" and \"getDeclaredMethods()\" return the same number of methods? " + (declaredMethods.length == methods.length));
			
			/*	Invoke methods of the class	 */
			BigDataEngineer vince = (BigDataEngineer) clazz.newInstance();
			Map<Map<String, Class<?>[]>, Object[]> methodArgumentMap = new HashMap<>();
			Map<String, Class<?>[]> methodNameAndParameterTypeMap = new HashMap<>();
			methodNameAndParameterTypeMap.put("setId", new Class[] { String.class });
			methodArgumentMap.put(methodNameAndParameterTypeMap, new Object[] { "550E8400-E29B-11D4-A716-446655440000" });
			methodNameAndParameterTypeMap = new HashMap<>();
			methodNameAndParameterTypeMap.put("setName", new Class[] { String.class });
			methodArgumentMap.put(methodNameAndParameterTypeMap, new Object[] { "Vince" });
			methodNameAndParameterTypeMap = new HashMap<>();
			methodNameAndParameterTypeMap.put("setAge", new Class[] { Integer.class });
			methodArgumentMap.put(methodNameAndParameterTypeMap, new Object[] { 27 });
			methodNameAndParameterTypeMap = new HashMap<>();
			methodNameAndParameterTypeMap.put("setSalary", new Class[] { Double.class });
			methodArgumentMap.put(methodNameAndParameterTypeMap, new Object[] { 200000.0 });
			ReflectionUtils.invokeMethods(clazz, vince, methodArgumentMap);
			System.out.println("\nThe instance created with invoking methods:");
			System.out.println("The big data engineer: " + vince);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	Test to get annotations from the class instance
	 *  -- Get the information of annotations
	 *  -- Parse annotations
	 */
	private void testGetAnnotation() {
		
		/*	Get the information of annotations  */
		String annotationInfo = ReflectionUtils.getAnnotationInfo(clazz);
		System.out.println("The information of annotations is listed below:\n" + annotationInfo);
		
		/*	Parse annotations	*/
		BigDataEngineer vince = (BigDataEngineer) ClassAnnotationParser.getInstance(clazz);
		BigDataEngineer violet = (BigDataEngineer) ClassAnnotationParser.getInstance(clazz);
		String annotatedMethodNames = MethodAnnotationParser.getMethodName(clazz);
		System.out.println("\nIf BigDataEngineer instance is singleton? " + (vince == violet));
		System.out.println("The names of annotated method: " + annotatedMethodNames);
	}
	
	/**
	 * 	Test to get an instance from dynamic proxy
	 */
	private void testDynamicProxy() {
		
		/*	Create a dynamic proxy instance	 */
		DynamicProxy dynamicProxy = new DynamicProxy(new BigDataEngineer("550E8400-E29B-11D4-A716-446655440000", "Vince", 27, 200000.0));
		dynamicProxy.setBeforeAdvice(new BeforeAdvice() {
			
			@Override
			public void secondBeforeAdvice() {
				System.out.println("It is about getting an instance from dynamic proxy.");
			}
			
			@Override
			public void firstBeforeAdvice() {
				System.out.println("This is a reflection test.");
			}
		});
		dynamicProxy.setAfterAdvice(new AfterAdvice() {
			
			@Override
			public void secondAfterAdvice() {
				System.out.println("This test is successful!");
			}
			
			@Override
			public void firstAfterAdvice() {
				System.out.println("Now you see!");
			}
		});
		
		/*	Get the target instance from dynamic proxy	*/
		Programmer bigDataEngineer = dynamicProxy.createProxy();
		bigDataEngineer.exercise();
	}
}
