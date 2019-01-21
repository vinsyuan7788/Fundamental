package com.java.se.conclusion.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Spliterator;

/**
 * 	This is a class to test Set
 * 	-- 3 ways of traversing a set: foreach (or enhanced for loop), iterator, spliterator (for interview question)
 * 	-- Using generics in collection type (dynamic-array-like): Set (for interview question)
 * 	-- Type parameter (<>): Short, Integer, Long, Double, Float, Character, Byte, Boolean, String, etc.
 * 
 * 	HashSet v.s. TreeSet:
 * 	-- HashSet is backed up by HashMap
 *  -- TreeSet is backed up by TreeMap
 *  
 * @author VinceYuan
 *
 */
public class TestSet {

	/*	Necessary instance variables	*/
	private Set<String> set;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestSet testSet = new TestSet();
		testSet.testPreparation();
		testSet.testSet();
		testSet.testLinkedHashSet();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		
		/*	Define a set (2 kinds of definition share similar methods) and add some elements	*/
		set = new HashSet<>();
//		set = new TreeSet<>();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		set.add("ccc");
	}
	
	/**
	 * 	Test Set
	 */
	private void testSet() {
		
		/*	Add some elements	*/
		set.add("AAA");
		set.add("BBB");
		set.add("CCC");
		set.addAll(set);
		
		/*	Remove some elements	*/
		String element = "CCC";
		set.remove(element);
//		set.remove(set.size() - 1);
		set.removeIf(s -> s.equals(s.toLowerCase()));
		
		/*	Get or fine some elements	*/
		element = "BBB";
		System.out.println("The first element:\n" + set.stream().findFirst().get());
		System.out.println("If " + element + " exists:\n" + set.contains(element));
		System.out.println("The filtered elements:");
		for (Iterator<String> iterator = set.stream().filter(s -> s.contains("A")).iterator(); iterator.hasNext();) {
			String ele = iterator.next();
			System.out.println(ele);
		}
		
		/* 	Output by using 2 traversing way: enhanced for loop; iterator	*/
		traverseSet(set);
		
		/*	Clear the set	*/
		set.clear();
		System.out.println("If the set is empty:\n" + set.isEmpty());
	}
	
	/**
	 * 	This is a method to traverse a list using foreach (enhance for loop), iterator, spliterator respectively
	 * @param set
	 */
	private <T> void traverseSet(Set<T> set) {
		
		System.out.println("Use foreach to traverse a set: (similar as forall in PL/SQL)");
		for (T element : set) {
			System.out.println(element);
		}
		
		System.out.println("Use iterator to traverse a set:");
		for (Iterator<T> iterator = set.iterator(); iterator.hasNext();) {
			T element = iterator.next();
			System.out.println(element);
		}
		
		System.out.println("Use spliterator to traverse a set:");
		Spliterator<T> spliterator = set.spliterator();
		spliterator.forEachRemaining((element) -> { System.out.println(element); });
	}
	
	private void testLinkedHashSet() {
		
		Set<String> set1 = new LinkedHashSet<String>();
		Set<Integer> set2 = new LinkedHashSet<Integer>();
		
		set1.add("123456");
		set1.add("654321");
		set1.add("333333");
		set2.add(3);
		set2.add(1);
		set2.add(5);
		
		System.out.println(set1);
		System.out.println(set2);
	}
}
