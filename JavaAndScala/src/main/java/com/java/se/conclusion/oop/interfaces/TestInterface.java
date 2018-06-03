package com.java.se.conclusion.oop.interfaces;

import com.java.se.conclusion.oop.interfaces.common.HadoopEngineer;
import com.java.se.conclusion.oop.interfaces.common.JavaEngineer;
import com.java.se.conclusion.oop.interfaces.common.interfaces.Engineer;

/**
 * 	This is a class to test interface
 *  
 *  Interface inheritance:
 *  -- Interface does NOT allow variable declaration in the interface. 
 *     -- Once an instance or static variable is declared, it will become static and final automatically
 *  -- Static methods CANNOT be inherited from interfaces
 *  
 *  Default method: a method that has been implemented ONLY by interfaces
 *  -- Can be directly used by child classes or interfaces
 *  -- It brings much convenience from the implementation perspective while "violates" the original design thoughts of interfaces
 *  -- It resembles "virtual" keyword in C#, while "virtual" can be used in interfaces, abstract classes and regular classes)
 *  
 * @author VinceYuan
 *
 */
public class TestInterface {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestInterface testInterface = new TestInterface();
		System.out.println("Here tests inheritance with interfaces:");
		testInterface.testInheritance();
		System.out.println("\nHere tests inheritance with interfaces:");
		testInterface.testPolymorphism();
	}
	
	/**
	 * 	Test interface inheritance
	 */
	private void testInheritance() {
		
		/*	Initialize an instance	*/
		JavaEngineer javaEngineer = new JavaEngineer();
		
		/*	Test inheritance of instance variables	*/
		System.out.println("Programming language: " + JavaEngineer.language);
		
		/*	Test inheritance of static variables	*/
		System.out.println("Annual salary: " + JavaEngineer.salary);
		
		/*	Test inheritance of default methods	 */		
		javaEngineer.prepare();
		
		/*	Test inheritance of instance methods	*/
		javaEngineer.program();
		
		/*	Test inheritance of static methods	*/
//		JavaEngineer.getInfo();			// There will be a compilation error
		Engineer.getInfo();
	}
	
	/**
	 * 	Test interface polymorphism
	 */
	private void testPolymorphism() {
		
		/*	Multiple instances return to its parent type	*/
		Engineer engineer = new JavaEngineer();
		engineer.program();
		engineer = new HadoopEngineer();
		engineer.program();
	}
}
