package com.java.se.conclusion.lambda.stream;

import java.util.Arrays;
import java.util.List;

import com.java.se.conclusion.lambda.stream.bean.Professor;

/**
 * 	This is a class to test Stream
 * 
 * 	Stream: a stream represents a sequence of objects from a source
 *  -- Source can be collections, arrays, IO streams, etc.
 *  
 * 	Stream features:
 *  -- Cannot store elements: only open it when need to process data on demand
 *  -- Can be pipelined or chained: the operations of stream return the stream itself
 *  
 * @author VinceYuan
 *
 */
public class TestStream {

	/*	Instance variables	*/
	private List<Professor> list;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestStream testStream = new TestStream();
		testStream.testPreparation();
		System.out.println("Here tests Stream:");
		testStream.testStream();
		testStream.testSequentialStreamAndParallelStream();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		
		/*	Initialized a list and a set with some elements	  */
		list = Arrays.asList(new Professor[] { new Professor("AA082", "Vince", 200000d, true), new Professor("AA082", "Vince", 200000d, true),
				new Professor("AA083", "Violet", 180000d, true), new Professor("B9U87", "Kelly", 160000d, true),
				new Professor("UOP98", "Mandy", 150000d, false), new Professor("HJ876", "Johnny", 150000d, true), 
				new Professor("MN278", "David", 140000d, false), new Professor("R8A2D", "Oliven", 140000d, false) }
		);
	}
	
	/**
	 * 	Test Stream
	 */
	private void testStream() {
		
		/*	Count the number of elements in the stream	*/
		System.out.println("The number of elements: " + list.stream().count());
		System.out.println("The number of distinct elements: " + list.stream().distinct().count());
		
		/*	Filter, map and output each element	 */
		System.out.println("\nThe elements whose name contains \"V\" or \"v\": ");
		list.stream().filter(instance -> instance.getName().toLowerCase().contains("v")).forEach(instance -> { System.out.println(instance); });
		System.out.println("The name of the elements that are tenure are concatenated: ");
		list.stream().filter(instance -> instance.getIsTenure() == true).map(instance -> instance.getName().concat(" Tenure")).forEach(instance -> { System.out.println(instance); });
		
		/*	Sort and output each element  */
		System.out.println("\nThe sorted elements in ascending order: ");
		list.stream().sorted((o1, o2) -> o1.getId().compareTo(o2.getId())).forEach(instance -> { System.out.println(instance); });
		System.out.println("The sorted elements in descending order: ");
		list.stream().sorted((o1, o2) -> o2.getId().compareTo(o1.getId())).forEach(instance -> { System.out.println(instance); });
		
		/*	Map and reduce each element	*/
		Double salary = list.stream().mapToDouble(o -> o.getSalary()).sum();
		System.out.println("\nThe total salary of all professors: " + salary);
		salary = list.stream().mapToDouble(o -> o.getSalary()).map(o -> o + 20000).sum();
		System.out.println("The total raised salary of all professors " + salary);
	    salary = list.stream().map(o -> o.getSalary() + 20000).reduce((o1, o2) -> o1 + o2).get();
		System.out.println("The reduced raised salary of all professors: " + salary);
		
		/*	Find maximum and minimum element	*/
		list.stream().max((o1, o2) -> o1.getId().compareTo(o2.getId())).ifPresent(instance -> { System.out.println("\nThe maximum element: " + instance); } );
		list.stream().min((o1, o2) -> o1.getId().compareTo(o2.getId())).ifPresent(instance -> { System.out.println("The minimum element: " + instance); } );
		
		/*	Find the first element	*/
		list.stream().findFirst().ifPresent(instance -> { System.out.println("\nThe first element: " + instance); });
	}
	
	/**
	 * 	Test sequential stream and parallel stream
	 */
	private void testSequentialStreamAndParallelStream() {
		// Not yet tested...
	}
}
