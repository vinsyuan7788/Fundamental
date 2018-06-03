package com.java.se.conclusion.lambda.functionalinterface.interfaces;

/**
 * 	This is an interface to implement functional interface (FI)
 * 	-- Only have ONE method to be implemented
 *  
 * 	When implementing FI:
 *  -- If the generics is applied on the method, there will be a compilation error
 *  
 * @author VinceYuan
 *
 */
@FunctionalInterface
public interface Receptionist <T, R> {

	public R getInfo(T instance);
}
