package org.lang.scala.conclusion.design.proxy.statics

import org.lang.scala.conclusion.design.proxy.target.parent.FinancialProduct
import org.lang.scala.conclusion.design.proxy.target.parent.Waiter

/**
 * 	This is a stand-alone class to implement static proxy pattern
 *  
 * 	@author VinceYuan
 */
class StaticProxy[T](

    /*	Maintain a reference for target within main constructor: IOP or AOP (Abstraction-Oriented Programming)	*/
    private val target: T

) extends Waiter 
  with FinancialProduct {
  
  /**
   * 	Override the necessary method to customize the enhancement contents
   */
  override def serve() = {
    println("Welcome!")
    target.asInstanceOf[Waiter].serve()
    println("Have a good day!\n")
  }
  override def check() = {
    target.asInstanceOf[Waiter].check()
    println("Welcome back again!\n")
  }
  override def upvalue() = {
    println("Here is a good news!")
    target.asInstanceOf[FinancialProduct].upvalue()
		println("Congratulations!\n")
  }
  override def devalue() = {
    println("Here is a bad news!")
    target.asInstanceOf[FinancialProduct].devalue()
		println("So sad...\n")
  }
}