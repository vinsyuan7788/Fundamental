package com.java.se.conclusion.design.factory.abstracts.common;

/**
 * 	This is an abstract class to be used to test the implementation of abstract factory pattern
 *  -- This class must inherit a parent abstract class
 *  
 * @author VinceYuan
 *
 */
public class MacBorder extends Border {

	@Override
	public void scroll() {
		System.out.println("A MAC Border is being scrolled...");
	}
}
