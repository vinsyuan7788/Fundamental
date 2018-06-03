package com.java.se.conclusion.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.java.se.common.utils.CollectionUtils;

/**
 * 	This class is to test array
 * 	-- Array to String and to List
 * 	-- "Arrays" and "Collections" class:
 *     -- "Array" is the hardware for load-balancing
 *     -- "Collection" is an interface
 * 	-- Multiple-dimensional array
 * 
 * 	Array: the length is invariable
 * 	-- Once an array is instantiated, the length (which is in heap memory) is fixed.
 * 	-- The address of array elements in heap memory is continuous. 
 * 
 * @author VinceYuan
 *
 */
public class TestArray {

	/*	Necessary instance variables	*/
	private String[] stringArray;
	private Integer[] integerArray;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestArray testArray = new TestArray();
		testArray.testPreparation();
		System.out.println("Here tests array:");
		testArray.testArray();
		System.out.println("\nHere tests arrays:");
		testArray.testArrays();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		
		/*	Instantiate a string array and an integer array	 */
		stringArray = new String[5];
		stringArray[0] = "Movies";
		stringArray[1] = "Sports";
		stringArray[2] = "Programing";
		stringArray[3] = "Music";
		stringArray[4] = "Thinking";
		integerArray = new Integer[] { (int) (Math.random()*90+10), 
				new Random().nextInt(90)+10, 
				(int) (Math.random()*90+10), 
				new Random().nextInt(90)+10, 
				(int) (Math.random()*90+10) 
		};
	}
	
	/**
	 * 	Test array
	 */
	private void testArray () {

		/*	Output the array	*/
		System.out.println("The hobby array: " + Arrays.toString(stringArray));
		
		/*	Convert the array to list	*/
		List<String> list = Arrays.asList(stringArray);
		System.out.println("The hobby list: " + list);
		
		/*	Convert the array to string	 */
		String string = CollectionUtils.toString(Arrays.asList(stringArray));
		System.out.println("The hobby string: " + string);
		
		/*	Notice that if the data type is primitive, then CANNOT DIRECTLY output the converted list as STRING	 */
		int[] intArray = {1, 2, 3, 4, 5};
		List<int[]> intList = Arrays.asList(intArray);
		Integer[] integerArray = {1, 2, 3, 4, 5};
		List<Integer> integerList = Arrays.asList(integerArray);
		System.out.println("The integers (as primitive): " + intList.toString());
		System.out.println("The integers (as wrapper): " + integerList.toString());
	}
	
	/**
	 * 	Test Arrays class
	 * 	-- If the integer array is "int[]", then "sort(integerArray, myComparator)" is unable to use due to generic type of implemented Comparator class
	 */
	private void testArrays () {
		
		/*	Specify two elements	*/
		int element = integerArray[new Random().nextInt(integerArray.length)];
		int anotherElement = 50;
		System.out.println("The original integer array: " + Arrays.toString(integerArray));
		
		/*	Reverse the integer elements: by Collections class	*/
		List<Integer> integerList = Arrays.asList(integerArray);
		Collections.reverse(integerList);
		System.out.println("The reverse integer array: " + Arrays.toString(integerList.toArray()));
		
		/*	Sort the integer array in ascending order	*/
		Arrays.sort(integerArray);
		System.out.println("The ascending integer array: " + Arrays.toString(integerArray));
		
		/*	Binary search the integer array: array must be sorted in ASCENDING order	*/
		int indexInAscOrder = Arrays.binarySearch(integerArray, element);
		if (indexInAscOrder < 0) {
			System.out.println("The element " + element + " does not exist. If this element needs to inserted into the ascending-ordered array, then its index is: " + (-indexInAscOrder-1));
		} else {
			System.out.println("The index of the element " + element + " in ascending order after binary search: " + indexInAscOrder);
		}
		indexInAscOrder = Arrays.binarySearch(integerArray, anotherElement);
		if (indexInAscOrder < 0) {
			System.out.println("The element " + anotherElement + " does not exist. If this element needs to inserted into the ascending-ordered array, then its index is: " + (-indexInAscOrder-1));
		} else {
			System.out.println("The index of the element " + anotherElement + " in ascending order after binary search: " + indexInAscOrder);
		}
		
		/*	Sort the integer array in descending order	*/
		Arrays.sort(integerArray, (o1, o2) -> o2.compareTo(o1));
//		Arrays.sort(integerArray, new DescComparator());
		System.out.println("The descending integer array: " + Arrays.toString(integerArray));
		
		/*	Binary search the integer array: array must be sorted in DESCENDING order	*/
		int indexInDescOrder = Arrays.binarySearch(integerArray, element, (o1, o2) -> o2.compareTo(o1));
//		int indexInDescOrder = Arrays.binarySearch(integerArray, element, new DescComparator());
		if (indexInDescOrder < 0) {
			System.out.println("The element " + element + " does not exist. If this element needs to inserted into the descending-ordered array, then its index is: " + (-indexInDescOrder-1));
		} else {
			System.out.println("The index of the element " + element + " in descending order after binary search: " + indexInDescOrder);
		}
		indexInDescOrder = Arrays.binarySearch(integerArray, anotherElement, (o1, o2) -> o2.compareTo(o1));
//		indexInDescOrder = Arrays.binarySearch(integerArray, anotherElement, new DescComparator());
		if (indexInDescOrder < 0) {
			System.out.println("The element " + anotherElement + " does not exist. If this element needs to inserted into the descending-ordered array, then its index is: " + (-indexInDescOrder-1));
		} else {
			System.out.println("The index of the element " + anotherElement + " in descending order after binary search: " + indexInDescOrder);
		}
	}
	
	/**
	 * 	This is an inner class for array sorting in descending order
	 * 
	 * @author VinceYuan
	 *
	 */
//	class DescComparator implements Comparator<Integer> {
//
//		/**
//		 * 	By default: for sorting in ascending order
//		 * 	1. if o1 < o2: return -1
//		 * 	2. if o1 > o2: return 1
//		 * 	3. if o1 == o2: return 0
//		 * 	Hence for sorting in descending order, just flip over the return result
//		 */
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			
//			if (o1 < o2) { 
//				return 1;
//	        } else if(o1 > o2) {
//	        	return -1;
//	        } else {
//	        	return 0;
//			}
//		}
//	}
}
