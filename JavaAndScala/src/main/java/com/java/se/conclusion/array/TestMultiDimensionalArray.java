package com.java.se.conclusion.array;

/**
 * 	This is a class to test multi-dimensional array
 * 
 * @author VinceYuan
 *
 */
public class TestMultiDimensionalArray {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestMultiDimensionalArray testMultiDimensionalArray = new TestMultiDimensionalArray();
		testMultiDimensionalArray.testMultiDimensionalArray();
	}
	
	/**
	 * 	This is a method to test multi-dimensional array
	 */
	private void testMultiDimensionalArray() {
		
		String[] arr1 = new String[]{ "A", "B", "C", "D" };
		Object[] arr2 = new Object[]{ "1", "2", "3", "4", "5", 6, "STRING" };
		Object[][] objArr = new Object[][]{ arr1, arr2 };
	
		for (int i = 0; i < objArr.length; i++) {
			System.out.println("This is array " + i + ": ");
			for (int j = 0; j < objArr[i].length; j++) {
				System.out.println(objArr[i][j]);
			}
		}
	}	
}
