package org.lang.scala.conclusion.design

/**
 * 	This is a stand-alone object to test design pattern
 * 
 * 	For some scenario, Scala cannot perform exactly the same operation as Java:
 *  -- Cannot use "Class.forName" exactly the same as in Java for configuration factory patter
 *     -- Since the class name in Scala will be changed after JVM compilation
 *     -- Need to find a way for class-name-based reflection
 *  -- Cannot use "Proxy.newProxyInstance" exactly the same as in Java for dynamic proxy pattern
 *     -- Since it will throw an exception that says "wrong number of arguments"
 *     -- Can use CGLib for Scala's dynamic proxy
 * 
 * 	@author VinceYuan
 */
object TestDesignPattern {
  
}