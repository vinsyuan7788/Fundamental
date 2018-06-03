package com.java.se.conclusion.design.singleton.eager;

import com.java.se.conclusion.design.singleton.eager.common.Learner;
import com.java.se.conclusion.design.singleton.eager.common.LearnerBehaviors;

/**
 * 	This is a class to implement eager singleton pattern
 * 	-- Create a private, static and final instance of current class inside current class:
 *     -- Make sure there is only one object in the memory
 * 	-- Privatize the constructor:
 *     -- Make sure whatever outside current class cannot new an object of current class
 *  -- Declare a public and static getter to get this unique object
 *  
 * @author VinceYuan
 *
 */
public class Student extends Learner implements LearnerBehaviors {

	/**
	 * 	Create a private, static and final instance of current class inside current class
	 */
	private static final Student STUDENT = new Student();
	
	/**
	 * 	Privatize the constructor
	 */
	private Student() {}
	
	/**
	 * 	Declare a public and static getter
	 * @return
	 */
	public static Student getStudent() {
		return STUDENT;
	}

	/*	Other methods to be implemented		*/
	@Override
	public void talk() {
		System.out.println("A student is talking...");
	}

	@Override
	public void work() {
		System.out.println("A student is working...");
	}

	@Override
	public void run() throws Exception {
		System.out.println("A student is running...");
	};
}
