package com.java.se.conclusion.design.proxy.statics;

import com.java.se.conclusion.design.proxy.target.parent.FinancialProduct;
import com.java.se.conclusion.design.proxy.target.parent.Waiter;

/**
 * 	This is a class to implement static proxy pattern
 * 	-- Implements the parent interfaces of all targets
 *  -- Maintain a target reference: IOP or AOP (Abstraction-Oriented Programming)
 *  -- Declare a constructor that can assign target to the maintained reference
 *     -- Hence once initiating the static proxy, an object must be assigned to maintained reference
 *     -- Declare a setter instead to assign object to the maintained references is also feasible
 *        -- Only need to ensure the target methods are not invoked after static proxy instantiation and before the setter invocation, which is not as convenient as using constructors
 * 	-- Override the necessary methods to customize the enhancement contents
 * 
 * @author VinceYuan
 *
 */
public class StaticProxy implements Waiter, FinancialProduct {

	/**
	 * 	Maintain a target reference: IOP or AOP (Abstraction-Oriented Programming)
	 */
	private Object target;
	
	/**
	 * 	Declare a constructor that can assign target to the maintained reference
	 * @param target
	 */
	public <T> StaticProxy (T target) {
		this.target = target;
	}
	
	/**
	 * 	Override the necessary method to customize the enhancement contents
	 */
	@Override
	public void serve() {
		System.out.println("Welcome!");
		((Waiter) target).serve();
		System.out.println("Have a good day!\n");
	}
	@Override
	public void checkOut() {
		((Waiter) target).checkOut();
		System.out.println("Welcome your coming again!\n");
	}
	@Override
	public void goUp() {
		System.out.println("Here is a good news!");
		((FinancialProduct) target).goUp();
		System.out.println("Congratulations!\n");
	}
	@Override
	public void goDown() {
		System.out.println("Here is a bad news!");
		((FinancialProduct) target).goDown();
		System.out.println("So sad...\n");
	}
}
