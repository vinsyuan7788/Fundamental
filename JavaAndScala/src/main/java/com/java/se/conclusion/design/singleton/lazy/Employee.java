package com.java.se.conclusion.design.singleton.lazy;

import com.java.se.conclusion.design.singleton.lazy.common.HumanBehaviors;
import com.java.se.conclusion.design.singleton.lazy.common.HumanBeing;

/**
 * 	This is a class to implement lazy singleton pattern
 * 	-- Declare a private and static reference inside current class in case to reference the instance of current class if necessary
 *     -- Make sure there is only one object in the memory if the object is created
 * 	-- Privatize the constructor
 *     -- Make sure whatever outside current class cannot new an object of current class
 *  -- Declare a public and static getter to create or get this unique object
 *     -- Double-checked locking pattern is used in this getter
 *        
 * @author VinceYuan
 *
 */
public class Employee extends HumanBeing implements HumanBehaviors {

	/**
	 * 	Declare a private and static reference inside current class
	 */
	private static volatile Employee EMPLOYEE;
	
	/**
	 * 	Privatize the constructor
	 */
	private Employee() {}
	
	/**
	 * 	Declare a public and static getter: this should be compiled on or after JavaSE 5.0
	 *	-- If the object is not instantiated, then create an instance
	 *	-- If the object has been instantiated, then directly return the instance
	 * @return
	 */
	public static Employee getEmployee() {
		
		/*	If the object is not instantiated, then create an instance	 */
		if (EMPLOYEE == null || EMPLOYEE.equals(null)) {
			/**
			 * 	Here is double-checked locking pattern
			 *  -- Make sure there is always only one thread accessing the resource in this synchronized block
			 *  -- Once the instance is created, this synchronized block will never be accessed
			 */
			synchronized(Employee.class){
				if (EMPLOYEE == null || EMPLOYEE.equals(null)) {
					EMPLOYEE = new Employee();
				}
			}
		}
		
		/*	Else return the instance directly	*/
		return EMPLOYEE;
	}
	
	/*	Other methods to be implemented	 */
	@Override
	public void talk() {
		System.out.println("An employee is talking...");
	}

	@Override
	public void work() {
		System.out.println("An employee is working...");
	}

	@Override
	public void run() throws Exception {
		System.out.println("An employee is running...");
	}
}
