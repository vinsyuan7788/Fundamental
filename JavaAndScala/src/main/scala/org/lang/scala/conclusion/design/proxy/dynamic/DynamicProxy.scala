package org.lang.scala.conclusion.design.proxy.dynamic

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

import org.lang.scala.conclusion.design.proxy.dynamic.advice.AfterAdvice
import org.lang.scala.conclusion.design.proxy.dynamic.advice.BeforeAdvice

/**
 * 	This is a class to implement dynamic proxy pattern
 *  
 * 	@author VinceYuan
 */
class DynamicProxy[T](

    /*	Maintain references for target and advice within main constructor	 */
    private val target: T,
    private val beforeAdvice: BeforeAdvice,
    private val afterAdvice: AfterAdvice

) {
  
  /**
   * 	This is a method to create a proxy instance through proxy or Java reflection
   */
  def createProxy(): T = {
    
    /*	Get a class loader	*/
    val classLoader = getClass.getClassLoader
    
    /*	Get the interfaces of target class	*/
    val interfaces = target.getClass().getInterfaces
    
    /*	Get a invocation handler	*/
    val invocationHandler = new InvocationHandler() {
      
      override def invoke(proxy: Any, method: Method, args: Array[Object]) = {
        
        if (beforeAdvice != null) {
          beforeAdvice.firstBeforeAdvice()
          beforeAdvice.secondBeforeAdvice()
        }
        
        val returnResult = method.invoke(target, args)
        
        if (afterAdvice != null) {
          afterAdvice.firstAfterAdvice()
          afterAdvice.secondAfterAdvice()
        }
        
        returnResult
      }
    }
    
    /*	Create a proxy instance and return	*/
    Proxy.newProxyInstance(classLoader, interfaces, invocationHandler).asInstanceOf[T]
  }
}