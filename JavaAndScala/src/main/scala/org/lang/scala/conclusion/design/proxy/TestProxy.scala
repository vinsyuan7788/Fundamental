package org.lang.scala.conclusion.design.proxy

import org.lang.scala.conclusion.design.proxy.dynamic.DynamicProxy
import org.lang.scala.conclusion.design.proxy.dynamic.advice.AfterAdvice
import org.lang.scala.conclusion.design.proxy.dynamic.advice.BeforeAdvice
import org.lang.scala.conclusion.design.proxy.statics.StaticProxy
import org.lang.scala.conclusion.design.proxy.target.FemaleWaiter
import org.lang.scala.conclusion.design.proxy.target.HedgeFund
import org.lang.scala.conclusion.design.proxy.target.MaleWaiter
import org.lang.scala.conclusion.design.proxy.target.Stock
import org.lang.scala.conclusion.design.proxy.target.parent.FinancialProduct
import org.lang.scala.conclusion.design.proxy.target.parent.Waiter

/**
 * 	This is a class to test proxy pattern
 * 
 * 	There are 2 types of proxy pattern, including:
 * 	-- Static proxy: get the proxy object during compile-time (e.g., use "new" to get the object)
 *     -- Without using "InvocationHandler" and "Proxy.newProxyInstance()"
 *     -- The enhanced class is variable or changeable: can be any class that implements a specific interface
 *        -- Since only the enhanced methods from ONE interface can be invoked in each static proxy instance even a target may implement multiple interfaces
 *        -- Hence not friendly for the interface scalability of targets
 *     -- The enhancement content is still hard-coded, which is suitable for internal use within a team
 *        -- E.g., for the convenience and facility of development of other team-mates
 *  -- Dynamic proxy (*****): get the proxy object during runtime, namely the running of the program (e.g., use "Proxy.newProxyInstance()" to get the object)
 *     -- Using "InvocationHandler" and "Proxy.newProxyInstance()"
 *     -- The enhanced class is variable or changeable: can be any class that implements any interface
 *     -- The enhancement content is soft-coded, which is for the use of user
 *        -- E.g., Spring framework, etc.
 *  
 *  Application Scenario:
 *  -- Implementation of AOP mechanism in Spring framework
 *  -- Widely applied in the design of other Java frameworks (e.g., MyBatis, Hibernate, etc.)
 *  
 * 	@author VinceYuan
 */
object TestProxy {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests static proxy:")
    testStaticProxy()
    println("\nHere tests dynamic proxy:")
//    testDynamicProxy()        // Cannot use "Proxy.newProxyInstance" directly the same as in Java
  }
  
  /**
   * 	This is a method to test static proxy
   */
  private def testStaticProxy(): Unit = {
    
		/*	Get the enhanced instances of target class from the static proxy and invoke enhanced methods	 */
    val target1 = new FemaleWaiter()
    var waiter: Waiter = new StaticProxy(target1)
    waiter.serve()
    waiter.check()
    val target2 = new MaleWaiter()
    waiter = new StaticProxy(target2)
    waiter.serve()
    waiter.check()
		
		/*	Get other enhanced instances of target class from the static proxy and invoke enhanced methods	 */
    val target3 = new HedgeFund()
    var financialProduct: FinancialProduct = new StaticProxy(target3)
    financialProduct.upvalue()
    financialProduct.devalue()
    val target4 = new Stock()
    financialProduct = new StaticProxy(target4)
    financialProduct.upvalue()
    financialProduct.devalue()
  }
  
  /**
   * 	This is a method to test dynamic proxy
   */
  private def testDynamicProxy(): Unit = {
    
		/*	Get a dynamic proxy instance and set necessary advice	*/
    val target1 = new MaleWaiter()
    var beforeAdvice = new BeforeAdvice() {
			
			override def firstBeforeAdvice() = {
			  println("Welcome")
			}
			override def secondBeforeAdvice() = {
			  println("Follow me please!")
			}
		}
		var afterAdvice = new AfterAdvice() {
			
			override def firstAfterAdvice() = {
			  println("Have a good day!")
			}
			override def secondAfterAdvice() = {
			  println("Hope to see you again!\n")
			}
		}
		
		/*	Get the enhanced instances of target class from the dynamic proxy and invoke enhanced methods	*/
		var waiter: Waiter = new DynamicProxy(target1, beforeAdvice, afterAdvice).createProxy()
		waiter.serve();

		/*	Get another dynamic proxy instance and set necessary advice	 */
		val target2 = new FemaleWaiter()
		afterAdvice = new AfterAdvice() {
		  
			override def firstAfterAdvice() = {
			  println("Thank you! Have a safe drive!")
			}
			override def secondAfterAdvice() = {}
		}
		
		/*	Get the enhanced instances of target class from the dynamic proxy and invoke enhanced methods	*/
		waiter = new DynamicProxy(target2, null, afterAdvice).createProxy();
		waiter.check();
  }
}