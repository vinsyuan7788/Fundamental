package com.java.se.conclusion.lambda.functionalutility.util;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 	This is a class to implement utility methods using functional interface provided by Java utility <br/>
 *  -- Predicate<T>: a lambda expression to specify a condition to be evaluated by the instance <br/>
 *  -- Consumer<T>: a lambda expression to specify an action to be performed by the instance <br/>
 *  -- Supplier<T>: a lambda expression or method reference to specify a job that will return a result to be executed <br/>&nbsp;&nbsp;&nbsp;
 *     -- To use parameterless constructor method: Supplier<ClassName> supplier = [ClassName]::new; supplier.get(); <br/>&nbsp;&nbsp;&nbsp;
 *     -- To use parameter constructor method: Supplier<ClassName> supplier = () -> new [ClassName](...); supplier.get(); <br/>
 *  -- Function<T, R>: a lambda expression or method reference to specify a ONE-parameter method that will return a result to be executed <br/>&nbsp;&nbsp;&nbsp;
 *     -- This method includes constructor method: Function<InputType, ClassName> function = [ClassName]::new; function.apply(inputArgument); <br/>&nbsp;&nbsp;&nbsp;
 *     -- This FI behaves like function currying while not completely implementing all the functionality of function currying <br/>&nbsp;&nbsp;&nbsp;
 *     -- It must be a method reference due to the Function<T, R> signature <br/>
 *  
 * @author VinceYuan
 *
 */
public class FunctionalUtilityUtils {

	/**
	 * 	This is a method to evaluate a predicate (or condition) on an instance
	 * @param instance
	 * @param condition
	 * @return
	 */
	public static <T> T evaluateCondition(T instance, Predicate<T> condition) {
		
		/*	If the instance satisfies the condition, return null	*/
		if (!condition.test(instance)) return null;
		
		/*	Else return the instance  */
		return instance;
    }
	
	/**
	 * 	This is a method to perform an operation on a mutable instance
	 * @param mutableInstance
	 * @param operation
	 */
	public static <T> void performAction(T mutableInstance, Consumer<T> action) {
		
		/*	Perform the operation on the instance	*/
		action.accept(mutableInstance);
	}
	
	/**
	 * 	This is a method to execute a job and return a result <br/>
	 *  -- The method CAN be constructor method
	 * @param supplier
	 * @return
	 */
	public static <T> T executeJobAndReturn(Supplier<T> job) {
		return job.get();
	}
	
	/**
	 * 	This is a method to execute a one-parameter method and return a result <br/>
	 *  -- The method CAN be constructor method
	 * @param function
	 * @param t
	 * @return
	 */
	public static <T, R> R invokeOneParameterMethodAndReturn(Function<T, R> parameterMethod, T inputInstance)  {
		
		/*	Execute the function with one input and return a result	 */
		return parameterMethod.apply(inputInstance);
	}

}
