package com.java.se.conclusion.oop.interfaces.common;

import com.java.se.conclusion.oop.interfaces.common.interfaces.Engineer;

/**
 * 	This is a class to be used to test interface
 *  -- This class must implements its parent interfaces
 *  -- Once a class implements an interface, it MUST override the instance methods declared in the interface
 *  
 * @author VinceYuan
 *
 */
public class JavaEngineer implements Engineer {

	@Override
	public void program() {
		System.out.println("A Java engineer is programming...");
	}
}
