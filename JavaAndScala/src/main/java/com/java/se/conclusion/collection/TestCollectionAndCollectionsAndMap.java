package com.java.se.conclusion.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 	This is a class to test collection, collections and map
 *  -- "Collection" is an interface
 *  -- "Collections" is an utility class
 *     -- "Collections.synchronizedList(Collection<T> collection)": to return a thread-safe collection
 * 
 * 	Collection (List & Set): length-variable array
 * 	-- The collection length (which is in heap memory) is variable even it is instantiated
 * 
 * 	Comparison between Collection and Map:
 *  --List:
 *    -- Element is duplicable & ordered
 *    -- ArrayList, LinkedList, Vector
 *  --Set:
 *    -- Element is unique & unordered
 *    -- HashSet, TreeSet
 *  --Map:
 *    -- Element is key-value pair
 *    -- HashMap, LinkedHashMap, TreeMap
 *  
 *  Conclusion with data structure:
 *  -- ArrayXXX: ArrayList
 *     -- Sorted & ordered
 *  -- LinkedXXX: LinkedList, LinkedHashMap
 *     -- Ordered but unsorted
 *  -- TreeXXX: TreeSet, TreeMap
 *     -- Sorted but unordered  
 *  -- HashXXX: HashSet, HashMap, Hashtable
 *     -- Unsorted & unordered
 *  
 * @author VinceYuan
 *
 */
public class TestCollectionAndCollectionsAndMap {
	
	/*	Necessary instance variables	*/
	private List<Integer> integerList;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestCollectionAndCollectionsAndMap testCollectionAndCollectionsAndMap = new TestCollectionAndCollectionsAndMap();
		testCollectionAndCollectionsAndMap.testPreparation();
		testCollectionAndCollectionsAndMap.testCollections();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		
		/*	Instantiate an integer list: each element is between 10 and 99	*/
		integerList = new ArrayList<>();
		integerList.add((int) (Math.random()*90+10));
		integerList.add(new Random().nextInt(90)+10);
		integerList.add((int) (Math.random()*90+10));
		integerList.add(new Random().nextInt(90)+10);
		integerList.add((int) (Math.random()*90+10));
	}
	
	/**
	 * 	Test Collections class
	 */
	private void testCollections() {
		
		/*	Specify two elements	*/
		int element = integerList.get(new Random().nextInt(integerList.size()));
		int anotherElement = 50;
		System.out.println("The original integer list: " + integerList.toString());
		
		/*	Reverse the integer elements: by Collections class	*/
		Collections.reverse(integerList);
		System.out.println("The reverse integer array: " + integerList.toString());
		
		/*	Sort the integer array in ascending order	*/
		Collections.sort(integerList);
		System.out.println("The ascending integer array: " + integerList.toString());
		
		/*	Binary search the integer list: list must be sorted in ASCENDING order	*/
		int indexInAscOrder = Collections.binarySearch(integerList, element);
		if (indexInAscOrder < 0) {
			System.out.println("The element " + element + " does not exist. If this element needs to inserted into the ascending-ordered array, then its index is: " + (-indexInAscOrder-1));
		} else {
			System.out.println("The index of the " + element + " in ascending order after binary search: " + indexInAscOrder);
		}
		indexInAscOrder = Collections.binarySearch(integerList, anotherElement);
		if (indexInAscOrder < 0) {
			System.out.println("The element " + anotherElement + " does not exist. If this element needs to inserted into the ascending-ordered array, then its index is: " + (-indexInAscOrder-1));
		} else {
			System.out.println("The index of the " + anotherElement + " in ascending order after binary search: " + indexInAscOrder);
		}
		
		/*	Sort the integer array in descending order	*/
		Collections.sort(integerList, (o1, o2) -> o2.compareTo(o1));
//		Collections.sort(integerList, new DescComparator());
		System.out.println("The descending integer array: " +integerList.toString());

		/*	Binary search the integer array: array must be sorted in DESCENDING order	*/
		int indexInDescOrder = Collections.binarySearch(integerList, element, (o1, o2) -> o2.compareTo(o1));
//		int indexInDescOrder = Collections.binarySearch(integerList, element, new DescComparator());
		if (indexInDescOrder < 0) {
			System.out.println("The element " + element + " does not exist. If this element needs to inserted into descending-ordered the array, then its index is: " + (-indexInDescOrder-1));
		} else {
			System.out.println("The index of the " + element + " in descending order after binary search: " + indexInDescOrder);
		}
		indexInDescOrder = Collections.binarySearch(integerList, anotherElement, (o1, o2) -> o2.compareTo(o1));
//		indexInDescOrder = Collections.binarySearch(integerList, anotherElement, new DescComparator());
		if (indexInDescOrder < 0) {
			System.out.println("The element " + anotherElement + " does not exist. If this element needs to inserted into the descending-ordered array, then its index is: " + (-indexInDescOrder-1));
		} else {
			System.out.println("The index of the " + anotherElement + " in descending order after binary search: " + indexInDescOrder);
		}
	}
	
	/**
	 * 	This is an inner class for array sorting in descending order
	 * 
	 * @author VinceYuan
	 *
	 */
//	private class DescComparator implements Comparator<Integer> {
//
//		/**
//		 * 	By default: for sorting in ascending order
//		 * 	1. if o1 < o2: return -1
//		 * 	2. if o1 > o2: return 1
//		 * 	3. if o1 == o2: return 0
//		 *  or 
//		 *  "return o1.compareTo(o2)"
//		 *  
//		 * 	Hence for sorting in descending order, just flip over the return result, namely
//		 *  1. if o1 < o2: return 1
//		 * 	2. if o1 > o2: return -1
//		 * 	3. if o1 == o2: return 0
//		 *  or 
//		 *  "return o2.compareTo(o1)"
//		 */
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			return o2.compareTo(o1);
//		}
//	}
}
