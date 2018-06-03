package com.java.se.conclusion.annotation;

import com.java.se.conclusion.annotation.bean.Person;
import com.java.se.conclusion.annotation.utils.ClassAnnotationParser;
import com.java.se.conclusion.annotation.utils.FieldAnnotationParser;
import com.java.se.conclusion.annotation.utils.MethodAnnotationParser;

/**
 * 	This is a class to test annotation
 * 
 * @author VinceYuan
 *
 */
public class TestAnnotation {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestAnnotation testAnnotation = new TestAnnotation();
		System.out.println("Here tests annotations:");
		testAnnotation.testAnnotation();
		System.out.println("\nHere tests exception processing:");
		testAnnotation.testExceptionProcessing();
	}
	
	/**
	 * 	This is the method to test annotation
	 */
	private void testAnnotation() {
		
		/*	Get 2 instances from the class annotation parser	*/
		Person vince = (Person) ClassAnnotationParser.getInstance(Person.class);
		Person violet = (Person) ClassAnnotationParser.getInstance(Person.class);
		
		/*	Inject values to annotated fields in person1 instance through field annotation parser	 */
		FieldAnnotationParser.injectValuesToFields(vince);
		
		/*	Get the names of annotated methods through method annotation parser	 */
		String annotatedMethodNames = MethodAnnotationParser.getMethodName(Person.class);
		
		/*	Print out the result	*/
		System.out.println("If Person instance is singleton? " + (vince == violet));
		System.out.println("The Person instance: " + vince);
		System.out.println("The names of annotated method: " + annotatedMethodNames);
	}
	
	/**
	 * 	This is the method to test the exception process in class annotation parser
	 */
	private void testExceptionProcessing() {
		
		/*	If an exception is thrown out, then exception processing works correctly	*/ 
		ClassAnnotationParser.getInstance(Math.class);
	}
}
