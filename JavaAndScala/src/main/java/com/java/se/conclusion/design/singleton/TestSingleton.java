package com.java.se.conclusion.design.singleton;

import com.java.se.conclusion.design.singleton.eager.Student;
import com.java.se.conclusion.design.singleton.lazy.Employee;

/**
 * 	This is a class to test singleton pattern
 * 	
 * 	There are 2 types of singleton:
 *  -- Eager singleton: create an unique instance in advanced and return this instance if anyone needs an instance
 *  -- Lazy singleton: Do not create an unique instance until anyone needs an instance, and return this instance if needed afterwards
 *     -- Usually used with double-checked locking pattern
 *     -- Potentially save more memory, hence usually used in application development
 * 
 * 	In singleton, thread-sharable instance (non-static) variables in classes will raise thread-safety problem
 *  -- To resolve this: 
 *     -- Avoid using thread-sharable instance (non-static) variables
 *     -- Using ThreadLocal<> class
 *     -- Using multiton for necessary classes: NOT recommended
 *     
 * 	Singleton pattern is typically applied in the design of Java frameworks (e.g., Spring, etc.)
 * 
 * @author VinceYuan
 *
 */
public class TestSingleton {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestSingleton testSingleton = new TestSingleton();
		System.out.println("Here tests eager singleton:");
		testSingleton.testEagerSingleton();
		System.out.println("\nHere tests lazy singleton:");
		testSingleton.testLazySingelton();
	}
	
	/**
	 * 	Test eager singleton pattern
	 */
	private void testEagerSingleton() {
		
		/*	Get 2 instances  */
		Student vince = Student.getStudent();
		Student violet = Student.getStudent();
		
		/*	Invoke the instance method	 */
		vince.work();
		violet.work();
		
		/*	See if these 2 instances are the same	 */
		System.out.println("If vince and violet reference the same instance? " + ((vince == violet) && (vince.equals(violet))));
	}
	
	/**
	 * 	Test lazy singleton pattern
	 */
	private void testLazySingelton() {
		
		/*	Get 2 instances	 */
		Employee vince = Employee.getEmployee();
		Employee violet = Employee.getEmployee();
		
		/*	Invoke the instance methods	 */
		vince.work();
		violet.work();
		
		/*	See if these 2 instances are the same	*/
		System.out.println("If vince and violet reference the same instance? " + ((vince == violet) && (vince.equals(violet))));
	}
}
