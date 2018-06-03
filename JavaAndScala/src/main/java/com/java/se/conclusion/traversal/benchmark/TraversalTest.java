package com.java.se.conclusion.traversal.benchmark;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.Vector;

/**
 * 	This is a class to be used to test traversal performance
 * 
 * @author VinceYuan
 *
 */
public class TraversalTest {

	/**
	 * 	This is a method to test the speed performance of different traversals on a list
	 *  -- Namely test DIFFERENT traversals on ONE list
	 * @param listType
	 * @param testSize
	 */
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public static void speedPerformanceOnList(Integer testSize, Class<? extends List> listType) {
		
		try {
			/*	Initialize a list with some elements	*/
			List<Integer> list = listType.newInstance();
			for (int i = 0; i < testSize; i++) {
				list.add(i);
			}
			
			/*	Do the test	 */
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < list.size(); i++) {
				Integer integer = list.get(i);
				// Do something...
			}
			long forloopTime = System.currentTimeMillis() - startTime;
			
			startTime = System.currentTimeMillis();
			for (Integer integer : list) {
				// Do something...
			}
			long foreachTime = System.currentTimeMillis() - startTime;
			
			startTime = System.currentTimeMillis();
			for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
				Integer integer = iterator.next();
				// Do something...
			}
			long iteratorTime = System.currentTimeMillis() - startTime;
			
			startTime = System.currentTimeMillis();
			for (ListIterator<Integer> listIterator = list.listIterator(); listIterator.hasNext();) {
				Integer integer = listIterator.next();
				// Do something...
			}
			long listIteratorTime = System.currentTimeMillis() - startTime;
			
			startTime = System.currentTimeMillis();
			Spliterator<Integer> spliterator = list.spliterator();
			spliterator.forEachRemaining((integer) -> { /* Do something... */ });
			long spliteratorTime = System.currentTimeMillis() - startTime;
			
			/*	Output the result	*/
			System.out.println("For loop: " + forloopTime + " ms");
			System.out.println("Foreach: " + foreachTime + " ms");
			System.out.println("Iterator: " + iteratorTime + " ms");
			System.out.println("List iterator: " + listIteratorTime + " ms");
			System.out.println("Spliterator: " + spliteratorTime + " ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a method to compare the fastest traversal of different lists with the same test size
	 *  -- Namely ONE fastest traversal on DIFFERENT lists
	 * @param testSize
	 * @param listTypes
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void speedPerformanceOnLists(Integer testSize, Class<? extends List>... listTypes) {
		
		try {
			/*	Initialize a null reference for list	*/
			List<Integer> list;

			/*	Do the test	 */
			long startTime = 0, arrayListTime = 0, linkedListTime = 0, vectorTime = 0;
			for (Class<? extends List> listType : listTypes) {
				
				/*	Use for loop for ArrayList	*/
				if (listType == ArrayList.class) {
					list = listType.newInstance();
					for (int i = 0; i < testSize; i++) {
						list.add(i);
					}
					startTime = System.currentTimeMillis();
					for (int i = 0; i < list.size(); i++) {
						Integer integer = list.get(i);
						// Do something...
					}
					arrayListTime = System.currentTimeMillis() - startTime;
				}
				
				/*	Use iterator for LinkedList	 */
				if (listType == LinkedList.class) {
					list = listType.newInstance();
					for (int i = 0; i < testSize; i++) {
						list.add(i);
					}
					startTime = System.currentTimeMillis();
					for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
						Integer integer = iterator.next();
						// Do something...
					}
					linkedListTime = System.currentTimeMillis() - startTime;
				}
				
				/*	Use spliterator for Vector	*/
				if (listType == Vector.class) {
					list = listType.newInstance();
					for (int i = 0; i < testSize; i++) {
						list.add(i);
					}
					startTime = System.currentTimeMillis();
					Spliterator<Integer> spliterator = list.spliterator();
					spliterator.forEachRemaining((integer) -> { /* Do something... */ });
					vectorTime = System.currentTimeMillis() - startTime;
				}
			}
			
			/*	Output the result	*/
			System.out.println("ArrayList: " + arrayListTime);
			System.out.println("LinkedList: " + linkedListTime);
			System.out.println("Vector: " + vectorTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a method to test the speed performance of traversal on a set
	 * @param setType
	 * @param testSize
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void speedPerformanceOnSet(Integer testSize, Class<? extends Set> setType) {
		
		try {
			/*	Initialize a set with some elements	 */
			Set<Integer> set = setType.newInstance();
			for (int i = 0; i < testSize; i++) {
				set.add(i);
			}
			
			/*	Do the test	 */
			long startTime = System.currentTimeMillis();
			for (Integer integer : set) {
				// Do something...
			}
			long foreachTime = System.currentTimeMillis() - startTime;
			
			startTime = System.currentTimeMillis();
			for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) {
				Integer integer = iterator.next();
				// Do something...
			}
			long iteratorTime = System.currentTimeMillis() - startTime;
			
			startTime = System.currentTimeMillis();
			Spliterator<Integer> spliterator = set.spliterator();
			spliterator.forEachRemaining((integer) -> { /* Do something... */ });
			long spliteratorTime = System.currentTimeMillis() - startTime;
			
			/*	Output the result	*/
			System.out.println("Foreach: " + foreachTime + " ms");
			System.out.println("Iterator: " + iteratorTime + " ms");
			System.out.println("Spliterator: " + spliteratorTime + " ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a method to compare the fastest traversal of different sets with the same test size
	 *  -- Namely ONE fastest traversal on DIFFERENT sets
	 * @param testSize
	 * @param setTypes
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void speedPerformanceOnSets(Integer testSize, Class<? extends Set>... setTypes) {
		
		try {
			/*	Initialize a null reference for set  */
			Set<Integer> set;
			
			/*	Do the test	 */
			long startTime = 0, hashSetTime = 0, treeSetTime = 0;
			for (Class<? extends Set> setType : setTypes) {
				
				/*	Use foreach for HashSet	 */
				if (setType == HashSet.class) {
					set = setType.newInstance();
					for (int i = 0; i < testSize; i++) {
						set.add(i);
					}
					startTime = System.currentTimeMillis();
					for (Integer integer : set) {
						// Do something...
					}
					hashSetTime = System.currentTimeMillis() - startTime;
				}
				
				/*	Use foreach for TreeSet	 */
				if (setType == TreeSet.class) {
					set = setType.newInstance();
					for (int i = 0; i < testSize; i++) {
						set.add(i);
					}
					startTime = System.currentTimeMillis();
					for (Integer integer : set) {
						// Do something...
					}
					treeSetTime = System.currentTimeMillis() - startTime;
				}
			}
			
			/*	Output the result	*/
			System.out.println("HashSet: " + hashSetTime);
			System.out.println("TreeSet: " + treeSetTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
