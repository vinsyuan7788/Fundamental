package com.java.se.conclusion.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.java.se.conclusion.generics.impl.ListFactory;

/**
 * 	This is a class to test generics and type erasure
 * 	-- Generics: allows to delay the specification of the data type until it is actually needed
 *     -- Generics serves as type parameter: a parameter for types (not for regular instances)
 *  -- Type erasure: during the compile-time the parameterized type (or type argument) is removed and only the raw type is kept
 *  
 *  Generic use conclusion: same way as using data types
 *  -- Specify a concrete type or corresponding instance to replace generics (or type parameter)
 *     -- For the concrete type that replaces placeholder: compiler will know what type it is and do the generics inference
 *     -- For the concrete type that replaces wildcard: compile will only predicate if it satisfies the condition (if the condition is assumed necessary by compiler): upper-bound or lower-bound
 *
 * @author VinceYuan
 *
 */
public class TestGenericsAndTypeErasure {
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestGenericsAndTypeErasure testGenericsAndTypeErasure = new TestGenericsAndTypeErasure();
		System.out.println("Here tests generics:");
		testGenericsAndTypeErasure.testGenerics();
		System.out.println("\nHere tests type erasure:");
		testGenericsAndTypeErasure.testTypeErasure();
	}
	
	/**
	 * 	Test (or use) generics
	 */
	private void testGenerics() {
		
		/*	Test placeholder with instance members	 */
		System.out.println("Test placeholder with instance members:");
		ListFactory<Vector<Object>> vectorFactory = new ListFactory<>(new Vector<Object>());
		Vector<Object> vector = vectorFactory.getInstance();
		vectorFactory.getInstanceInfo(vector);
		ListFactory<LinkedList<Object>> linkedListFactory = new ListFactory<>(new LinkedList<Object>());
		LinkedList<Object> linkedList = linkedListFactory.getInstance();
		linkedListFactory.getInstanceInfo(linkedList);
		
		/*	Test placeholder with static methods	*/
		System.out.println("\nTest placeholder with static methods:");
		ArrayList<Integer> arrayList = ListFactory.createArrayList();
		ListFactory.compareTypes(linkedList, arrayList);
		ListFactory.compareTypes(vector, vector);
		
		/*	Test wildcard with static methods	*/
		System.out.println("\nTest wildcard with static methods:");
		ArrayList<Object> list = ListFactory.createList(ArrayList.class);
		ListFactory.compareTypes(list, arrayList);
	}
	
	/**
	 * 	Test type erasure
	 */
	private void testTypeErasure() {
		
		/*	Get 2 lists	*/
		List<Integer> li = new ArrayList<>();
		List<Float> lf = new ArrayList<>();
		
		/*	Return true: means the parameterized type (or type argument: Integer or Float) of List (or raw type) is erased	 */
		if (li.getClass() == lf.getClass()) { 
			System.out.println("The class of li: " + li.getClass());
			System.out.println("The class of lf: " + lf.getClass());
		    System.out.println("2 classes are equal? " + true);
		}
	}
}
