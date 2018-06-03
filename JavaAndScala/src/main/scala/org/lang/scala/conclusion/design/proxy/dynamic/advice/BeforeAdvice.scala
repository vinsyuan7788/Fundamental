package org.lang.scala.conclusion.design.proxy.dynamic.advice

/**
 * 	This is a trait to implement dynamic proxy pattern
 *  -- This trait serves as advice
 *  -- This trait is no need to be implemented
 *  -- This trait will be directly instantiated when it is needed
 *  
 * 	@author VinceYuan
 */
trait BeforeAdvice {
  
  def firstBeforeAdvice(): Unit
  def secondBeforeAdvice(): Unit
}