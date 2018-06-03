package com.java.se.conclusion.traversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

import com.java.se.conclusion.traversal.benchmark.TraversalTest;

/**
 * 	This is a class to test traversal performance
 * 
 * 	The traverse performance is up to the data structure that needs to be traversed
 * 	-- For List: 5 ways of traversal: for loop, foreach, iterator, list iterator, spliterator
 *     -- ArrayList: for loop = foreach = iterator >= list iterator > spliterator
 *        -- Since array list traverses elements using random access
 *     -- LinkedList: iterator = list iterator >= foreach > spliterator >>>> for loop
 *        -- Since linked list traverses elements using sequential access
 *     -- Vector: spliterator >> foreach = iterator >= list iterator >> for loop
 *  -- For Set: 3 ways of traversal: foreach, iterator, spliterator
 *     -- HashSet: foreach = iterator > (or >>>>) spliterator
 *     -- TreeSet: foreach = iterator > spliterator
 *  
 *  Compare the speed performance of the fastest traversal way of each data structure:
 *  -- For List: ArrayList > LinkedList > Vector
 *  -- For Set: HashSet ≈ TreeSet
 *     
 * @author VinceYuan
 *
 */
public class TestTraversalPerformance {
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestTraversalPerformance testTraversalPerformance = new TestTraversalPerformance();
		testTraversalPerformance.testTraversalOnArrayList();
		testTraversalPerformance.testTraversalOnLinkedList();
		testTraversalPerformance.testTraversalOnVector();
		testTraversalPerformance.testTraversalOnHashSet();
		testTraversalPerformance.testTraversalOnTreeSet();
		testTraversalPerformance.testCompareListTraversal();
		testTraversalPerformance.testCompareSetTraversal();
	}
	
	/*------------- 1st phrase: test which traversal way is the fastest for each list or set ---------------*/
	/**
	 * 	Test traversal on ArrayList
	 */
	private void testTraversalOnArrayList() {	
		
		System.out.println("Test result for array list:");
		TraversalTest.speedPerformanceOnList((int)3e7, ArrayList.class);
	}
	
	/**
	 * 	Test traversal on LinkedList
	 */
	private void testTraversalOnLinkedList() {
		
		System.out.println("Test result for linked list:");
		TraversalTest.speedPerformanceOnList((int)1e5, LinkedList.class);
		
	}
	
	/**
	 * 	Test traversal on Vector
	 */
	private void testTraversalOnVector() {
		
		System.out.println("Test result for vector:");
		TraversalTest.speedPerformanceOnList((int)3e7, Vector.class);
	}
	
	/**
	 * 	Test traversal on HashSet
	 */
	private void testTraversalOnHashSet() {
		
		System.out.println("Test result for hash set:");
		TraversalTest.speedPerformanceOnSet((int)1e7, HashSet.class);
	}
	
	/**
	 * 	Test traversal on TreeSet
	 */
	private void testTraversalOnTreeSet() {
		
		System.out.println("Test result for tree set:");
		TraversalTest.speedPerformanceOnSet((int)1e7, TreeSet.class);
	}
	
	/*--------------- 2nd phrase: compare the fastest traversal way among each list or set -----------------*/
	/**
	 * 	Test comparison of fastest traversal of different lists
	 */
	@SuppressWarnings("unchecked")
	private void testCompareListTraversal() {
		
		System.out.println("Comparison result for different lists:");
		TraversalTest.speedPerformanceOnLists((int)1e7, ArrayList.class, LinkedList.class, Vector.class);
	}
	
	/**
	 * 	Test comparison of fastest traversal of different sets
	 */
	@SuppressWarnings("unchecked")
	private void testCompareSetTraversal() {
		
		System.out.println("Comparison result for different sets:");
		TraversalTest.speedPerformanceOnSets((int)1e7, HashSet.class, TreeSet.class);
	}
}
