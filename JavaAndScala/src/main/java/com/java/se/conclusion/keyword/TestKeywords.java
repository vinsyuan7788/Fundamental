package com.java.se.conclusion.keyword;

import com.java.se.conclusion.keyword.common.Animal;
import com.java.se.conclusion.keyword.common.Hawk;
import com.java.se.conclusion.keyword.common.Pigeon;
import com.java.se.conclusion.keyword.common.Survivor;

/**
 * 	This class is to test keywords
 * 	
 * 	Modifiers: keywords to change the meaning of definition
 * 	1. Access modifier: public, private, protected
 *     -- Change the method accessibility, visibility
 *  2. Non-access modifier: static, final, abstract, synchronized, volatile
 *     -- Achieve specific functionalities 
 */
public class TestKeywords {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestKeywords testKeywords = new TestKeywords();
		System.out.println("Here tests \"final\"");
		testKeywords.testFinal();
		System.out.println("\nHere tests \"instanceOf\"");
		testKeywords.testInstanceof();
		System.out.println("\nHere tests \"if-elseif\"");
		testKeywords.testIfElseIf();
	}
	
	/**
	 * 	Test "final"
	 */
	private void testFinal() {
		
		final int a = 2;
		System.out.println(a);
//		a = 3;					// cannot be reassigned since it is finalized
//		System.out.println(a);
	}
	
	/**
	 * 	Test "instanceof"
	 * 	-- Used to predicate if an instance belongs to a specific class or interface
	 * 	   -- Premise: the instance's class must inherit or implement or be inherited or implemented by the specific class or interface 
	 */
	private void testInstanceof() {
		
		/*	Create 2 instances	*/
		Hawk hawk = new Hawk();
		Pigeon pigeon = new Pigeon();
		
		/*	Do the predication	*/
		if (hawk instanceof Hawk) {
			System.out.println("hawk is an instance of Hawk.");
		}
		if (hawk instanceof Animal) {
			System.out.println("hawk is an instance of Animal.");
		}
		if (hawk instanceof Survivor) {
			System.out.println("hawk is an instance of Survivor.");
		}
		if (pigeon instanceof Pigeon) {
			System.out.println("pigeon is an instance of Pigeon.");
		}
//		if (pigeon instanceof Animal) {
//			System.out.println("pigeon is an instance of Animal.");
//		}
		if (pigeon instanceof Survivor) {
			System.out.println("pigeon is an instance of Survivor.");
		}
	}
	
	private void testIfElseIf() {
		
		String str = "I Love You";
		
		if (str.equals("I Love You")) {
			System.out.println(str);
		} else if (str.length() == 10) {
			System.out.println(str.length());
		}
	}
}
