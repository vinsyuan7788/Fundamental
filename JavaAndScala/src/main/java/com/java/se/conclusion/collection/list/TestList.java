package com.java.se.conclusion.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

/**
 * 	This is a class to test List
 * 	-- 5 ways of traversing a list: for loop, foreach (or enhanced for loop), iterator, list iterator, spliterator (for interview question)
 * 	-- Using generics in collection type (dynamic-array-like): List (for interview question)
 * 	-- Type parameter (<>): Short, Integer, Long, Double, Float, Character, Byte, Boolean, String, etc
 * 
 * 	ArrayList v.s. LinkedList v.s. Vector
 *  -- ArrayList: FAST for ADDing and DELETing elements, but SLOW to ACCESS a specific element
 *     -- ArrayList is essentially an array and implements RandomAccess (hence it accesses elements through random access)
 *  -- LinkedList: FAST for ACCESSing a specific element but can be SLOW to ADD to either end, and especially slow to DELETE in the middle
 *     -- LinkedList is essentially a double linked list and implements Deque and Queue (hence it accesses elements through sequential access)
 *  -- Vector: SAME as ArrayList while the performance is not as good as ArrayList
 *     -- Since Vector synchronizes all of its method, hence vector is a thread-safe and low-performance version of ArrayList
 *     -- Vector also implements RandomAccess (hence it accesses elements through random access)
 *  
 * @author VinceYuan
 *
 */
public class TestList {

	/*	Necessary instance variables	*/
	private List<String> list;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestList testList = new TestList();
		testList.testPreparation();
		testList.testList();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		
		/*	Define a list (3 kinds of definition share similar methods)	and add some elements 	*/
		list = new ArrayList<>();		
//		list = new LinkedList<>();		
//		list = new Vector<>();			
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ccc");
	}
	
	/** 
	 * 	Test List
	 */
	private void testList() {

		/*	Add some elements	*/
		list.add("AAA");
		list.add("BBB");
		list.add("CCC");
		list.addAll(list);
		
		/*	Remove some elements	*/
		String element = "CCC";
		list.remove(element);
		list.remove(list.size() - 1);
		list.removeIf(s -> s.equals(s.toLowerCase()));
		
		/*	Get or fine some elements	*/
		element = "BBB";
		System.out.println("The first element:\n" + list.get(0));
		System.out.println("The last element:\n" + list.get(list.size() - 1));
		System.out.println("If " + element + " exists:\n" + list.contains(element));
		System.out.println("The index of " + element + ":\n" + list.indexOf(element));
		System.out.println("The filtered elements:");
		for (Iterator<String> iterator = list.stream().filter(s -> s.contains("A")).iterator(); iterator.hasNext();) {
			String ele = iterator.next();
			System.out.println(ele);
		}
		
		/*	Modify some elements	*/
		element = "BBB";
		list.set(list.indexOf(element), list.get(list.indexOf(element)).concat("CCC"));
		
		/*	Output by using 3 traversing way: for loop; enhanced for loop; iterator	 */
		traverseList(list);
		
		/*	Clear the list	*/
		list.clear();
		System.out.println("If the list is empty:\n" + list.isEmpty());
	}
	
	/**
	 * 	This is a method to traverse a list using for loop, foreach (or enhanced for loop) , iterator, list iterator, spliterator respectively
	 * @param list
	 */
	private <T> void traverseList(List<T> list) {
		
		System.out.println("Use for loop to traverse a list:");
		for (int i = 0; i < list.size(); i++) {
			T element = list.get(i);
			System.out.println(element);
		}
		
		System.out.println("Use foreach to traverse a list: (similar as forall in PL/SQL)");
		for (T element : list) {
			System.out.println(element);
		}
		
		System.out.println("Use iterator to traverse a list:");
		for (Iterator<T> iterator = list.iterator(); iterator.hasNext();) {
			T element = iterator.next();
			System.out.println(element);		
		}
		
		System.out.println("Use list iterator to traverse a list:");
		for (ListIterator<T> listIterator = list.listIterator(); listIterator.hasNext();) {
			T element = listIterator.next();
			System.out.println(element);		
		}
		
		System.out.println("Use spliterator to traverse a list:");
		Spliterator<T> spliterator = list.spliterator();
		spliterator.forEachRemaining((element) -> { System.out.println(element); });
	}
}
