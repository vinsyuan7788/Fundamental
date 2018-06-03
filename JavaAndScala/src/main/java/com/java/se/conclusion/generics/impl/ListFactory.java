package com.java.se.conclusion.generics.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 	This is a class to implement generics
 * 
 * 	There are 2 ways of generics implementation:
 *  -- Using placeholder: <T>, <T, D>, <AB, CD, EFG>, etc.
 *  -- Using wildcard: <?>, <? extends ...>, <? super ...>
 *     -- <? extends ...>: upper-bound wildcard
 *     -- <? super ...>: lower-bound wildcard
 *  
 *  For placeholder:
 *  -- Can be used on a class, then it works on all instance members of the class
 *     -- E.g., instance variables, instance methods, constructors
 *  -- Can be used on a method, then it works only on that method
 *     -- E.g., static methods, instance methods, constructors
 *  -- Compiler will know on COMPILE-TIME what a concrete type (that replaces the placeholder) is when we use whatever implemented with generics
 *     -- Hence compiler can infer the generics
 *  -- Compiler will infer on COMPILE-TIME the generics when we use whatever implemented with generics
 *     -- Hence when using placeholder on generics implementation, should save unnecessary placeholder 
 *
 * 	For wildcard:
 *  -- Can be used on data type, then it will specify the conditions that must be satisfied when a concrete type is specified
 *     -- <? extends T> or upper-bound: only the concrete type that inherits class T can be specified
 *     -- <? super T> or lower-bound: only the concrete type that is the parent of class T can be specified
 *  -- Compiler will only predicate on COMPILE-TIME if a concrete type satisfies the condition (if the condition is assumed necessary by compiler)
 *     -- Compiler does not care what exactly this type (that will replace the wildcard) is 
 *  -- Only JVM will know on RUNTIME what exactly this type is and do the corresponding processing using reflection
 *     -- Hence when using wildcard on generics implementation, always need to use reflection as well (to create instance, inject value, get information, etc.)
 *    
 *  Generics implementation conclusion: should consider what members (or methods or data type) generics should work on 
 *  -- For instance members: can use placeholder on a class or method
 *  -- For static methods: can use placeholder on the method
 *  -- For data type: can use wildcard on the data type
 *      
 * @author VinceYuan
 *
 */
public class ListFactory<T> {
	
	/*------------------------	Use Placeholder on Instance Members	------------------------------*/
	/*	Placeholder on instance variables	*/
	private T t;	
	
	/*	Placeholder on constructors	*/
	public ListFactory(T t) {
		this.t = t;
	}

	/*	Placeholder on instance methods	*/
	public T getInstance() {
		return t;
	}
	public <D> void getInstanceInfo(D d) {
		System.out.println("This is the class name of the instance: " + d.getClass().getSimpleName());
	}
	
	/*------------------------	Use Placeholder on Static Methods	------------------------------*/
	/*	Placeholder on static methods	*/
	public static <D extends Number> ArrayList<D> createArrayList() {
		return new ArrayList<D>();
	}
	public static <D extends Number> LinkedList<D> createLinkedList() {
		return new LinkedList<D>();
	}
	public static <D, T> void compareTypes(D d, T t) {
		
		/*	If 2 types have the same type name, then they are the same	*/
		if ((d.getClass().getTypeName() == t.getClass().getTypeName()) && (d.getClass().getTypeName().equals(t.getClass().getTypeName()))) {
			System.out.println("These 2 instances have the same data type.");
		
		/*	Otherwise they are different	*/
		} else {
			System.out.println("These 2 instances have different data types.");
		}
	}
	
	/*-----------------------------	 Use Wildcard on Data Type	---------------------------------*/
	/*	
	 * 	Wildcard on data type
	 * 	-- Here <D> can be <D extends List> or <D extends List<?>>, but it will not be checked by compiler when we specify a concrete type to replace it
	 *     -- Because it is not necessary since <? extends List> specifies the upper-bound and its instance must be able to be cast to D-typed
	 *        -- Hence compiler assumes <D extends List> or <D extends List<?>> is naturally satisfied  
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <D> D createList(Class<? extends List> clazz) {
		
		/*	Return an instance using reflection	 */
		try {
			return (D) clazz.getConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*	If there is any exception, return null	*/
		return null;
	}
}
