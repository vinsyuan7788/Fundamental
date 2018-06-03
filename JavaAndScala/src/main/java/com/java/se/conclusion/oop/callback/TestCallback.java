package com.java.se.conclusion.oop.callback;

import java.util.HashMap;
import java.util.Map;

import com.java.se.conclusion.oop.callback.common.CallbackImpl;
import com.java.se.conclusion.oop.callback.common.CallbackTest;

/**
 * 	This is a class to test callback
 * 
 * 	In java, there is no explicit concept regarding callback since:
 *  -- Callback allows to pass in a function as parameter, and this function can have different (predefined) implementation 
 *     according to satisfy different requirement (or solve different problems), which is actually method polhymorphism and
 *     is part of polymorphism in Java. Since JavaScript does not have polymorphism (since JavaScript is weak-typed language),
 *     callback is raised up. Hence this is a "trade-off" between polymorphism and callback between Java and JavaScript
 *     -- Java --- (strong-typed) ---> polymorphism (for method)
 *     -- JavaScript --- (weak-typed) ---> callback (for method) 
 *  -- The equivalent implementation of callback is function interface or delegate or method polymorphism (or overriding)
 *  -- This implementation is (or can be) widely-applied on:
 *     -- Observer pattern, etc.
 * 
 * @author VinceYuan
 *
 */
public class TestCallback {

	/*	Necessary Instance variables	*/
	private Map<String, String> map;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestCallback testCallback = new TestCallback();
		testCallback.testPreparation();
		testCallback.testCallback();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		
		map = new HashMap<>();
		map.put("Vince", "Male");
		map.put("Violet", "Female");
	}
	
	/**
	 * 	Test callback
	 */
	private void testCallback() {
		
		/*	Here is regular callback	*/
		System.out.println("The map information:");
		CallbackTest.getMapInfo(map, new CallbackImpl());
		
		/*	Here is callback with lambda expression	 */
		System.out.println("\nThe map information:");
		CallbackTest.getMapInfo(map, (map) -> { System.out.println("There is no map information..."); });
	}
}
