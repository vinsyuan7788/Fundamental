package com.java.se.conclusion.design.proxy;

import com.java.se.conclusion.design.proxy.dynamic.DynamicProxy;
import com.java.se.conclusion.design.proxy.dynamic.advice.AfterAdvice;
import com.java.se.conclusion.design.proxy.dynamic.advice.BeforeAdvice;
import com.java.se.conclusion.design.proxy.statics.StaticProxy;
import com.java.se.conclusion.design.proxy.target.FemaleWaiter;
import com.java.se.conclusion.design.proxy.target.HedgeFund;
import com.java.se.conclusion.design.proxy.target.MaleWaiter;
import com.java.se.conclusion.design.proxy.target.Stock;
import com.java.se.conclusion.design.proxy.target.parent.FinancialProduct;
import com.java.se.conclusion.design.proxy.target.parent.Waiter;

/**
 * 	This is a class to test proxy pattern
 * 
 * 	There are 2 types of proxy pattern, including:
 * 	-- Static proxy: get the proxy object during compile-time (e.g., use "new" to get the object)
 *     -- Without using "InvocationHandler" and "Proxy.newProxyInstance()"
 *     -- The enhanced class is variable or changeable: can be any class that implements a specific interface
 *        -- Since only the enhanced methods from ONE interface can be invoked in each static proxy instance even a target may implement multiple interfaces
 *        -- Hence not friendly for the interface scalability of targets
 *     -- The enhancement content is still hard-coded
 *  -- Dynamic proxy (*****): get the proxy object during runtime, namely the running of the program (e.g., use "Proxy.newProxyInstance()" to get the object)
 *     -- Using "InvocationHandler" and "Proxy.newProxyInstance()"
 *     -- The enhanced class is variable or changeable: can be any class that implements any interface
 *     -- The enhancement content is soft-coded
 *  
 *  Application Scenario:
 *  -- Implementation of AOP mechanism in Spring framework
 *  -- Widely applied in the design of other Java frameworks (e.g., MyBatis, Hibernate, etc.)
 *  
 * @author VinceYuan
 *
 */
public class TestProxy {
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestProxy testProxy = new TestProxy();
		System.out.println("Here tests static proxy:");
		testProxy.testStaticProxy();
		System.out.println("\nHere tests dynamic proxy:");
		testProxy.testDynamicProxy();
	}
	
	/**
	 * 	Test static proxy
	 */
	private void testStaticProxy() {
		
		/*	Get the enhanced instances of target class from the static proxy and invoke enhanced methods	*/
		FemaleWaiter target1 = new FemaleWaiter();
		Waiter waiter = new StaticProxy(target1);
		waiter.serve();
		waiter.checkOut();
		MaleWaiter target2 = new MaleWaiter();
		waiter = new StaticProxy(target2);
		waiter.serve();
		waiter.checkOut();
		
		/*	Get other enhanced instances of target class from the static proxy and invoke enhanced methods	 */
		HedgeFund target3 = new HedgeFund();
		FinancialProduct financialProduct = new StaticProxy(target3);
		financialProduct.goUp();
		financialProduct.goDown();
		Stock target4 = new Stock();
		financialProduct = new StaticProxy(target4);
		financialProduct.goUp();
		financialProduct.goDown();
	}
	
	/**
	 * 	Test dynamic proxy
	 */
	private void testDynamicProxy() {
		
		/*	Get a dynamic proxy instance and set necessary advice	*/
		MaleWaiter target1 = new MaleWaiter();
		BeforeAdvice beforeAdvice = new BeforeAdvice() {
			
			@Override
			public void secondBeforeAdvice() {
				System.out.println("Follow me please!");
			}
			
			@Override
			public void firstBeforeAdvice() {
				System.out.println("Welcome!");
			}
		};
		AfterAdvice afterAdvice = new AfterAdvice() {
			
			@Override
			public void secondAfterAdvice() {
				System.out.println("Hope to see you again!\n");
			}
			
			@Override
			public void firstAfterAdvice() {
				System.out.println("Have a good day!");
			}
		};
		
		/*	Get the enhanced instances of target class from the dynamic proxy and invoke enhanced methods	*/
		Waiter waiter = new DynamicProxy(target1, beforeAdvice, afterAdvice).createProxy();
		waiter.serve();
		
		/*	Get another dynamic proxy instance and set necessary advice	 */
		FemaleWaiter target2 = new FemaleWaiter();
		afterAdvice = new AfterAdvice() {
			
			@Override
			public void secondAfterAdvice() {}
			
			@Override
			public void firstAfterAdvice() {
				System.out.println("Thank you! Have a safe drive!");
			}
		};
		
		/*	Get the enhanced instances of target class from the dynamic proxy and invoke enhanced methods	*/
		waiter = new DynamicProxy(target2, null, afterAdvice).createProxy();
		waiter.checkOut();
	}
}
