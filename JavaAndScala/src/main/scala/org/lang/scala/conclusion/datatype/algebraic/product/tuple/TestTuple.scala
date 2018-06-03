package org.lang.scala.conclusion.datatype.algebraic.product.tuple

import scala.reflect.runtime.universe

import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test tuple
 *  -- Tuple cannot be traversed
 *  
 *  @author VinceYuan
 */
object TestTuple {
  
  /*	Necessary instance variables	*/
  val tupleFunc1 = (x: Int, y: Int) => (y, x, x + y)
  val tupleFunc2 = (x: Int, y: Int) => ((x, y), (x + y, x * y))
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testTuple()
  }
  
  /**
   * 	This is a method to test Tuple
   */
  def testTuple(): Unit = {
    
    /*	This is a list to store tuples	*/
    var tupleList: List[Any] = List()
    
    /*	Initialize two ranges	 */
    val tuple1 = (1, 2, "Hello Scala")
    tupleList = tupleList :+ tuple1
    val tuple2 = tupleFunc1(10, 20)
    tupleList = tupleList :+ tuple2
    val tuple3 = tupleFunc2(10, 20)
    tupleList = tupleList :+ tuple3

    /*	Output information	*/
    println("If " + tupleList(0) + " and " + tupleList(1) + " are the same: " + tupleList(0).equals(tupleList(1)))
    println("If " + tupleList(1) + " and " + tupleList(2) + " are the same: " + tupleList(1).equals(tupleList(2)))
    println("If " + tupleList(0) + " and " + tupleList(2) + " are the same: " + tupleList(0).equals(tupleList(2)))
    println("tupleList(0) data type is: " + ReflectionUtils.getRuntimeType(tupleList(0)))
    println("tuple1 data type is: " + ReflectionUtils.getRuntimeType(tuple1))
    println("tupleList(1) data type is: " + ReflectionUtils.getRuntimeType(tupleList(1)))
    println("tuple2 data type is: " + ReflectionUtils.getRuntimeType(tuple2))
    println("tupleList(2) data type is: " + ReflectionUtils.getRuntimeType(tupleList(2)))
    println("tuple3 data type is: " + ReflectionUtils.getRuntimeType(tuple3))
    println("If tuple1 is 3-element tuple: " + tuple1.isInstanceOf[Tuple3[Int, Int, String]])
    println("If tuple2 is 3-element tuple: " + tuple2.isInstanceOf[Tuple3[Int, Int, Int]])
    println("If tuple3 is 2-element tuple: " + tuple3.isInstanceOf[Tuple2[Tuple2[Int, Int], Tuple2[Int, Int]]])
    
    /*	Traverse a tuple using functional operation	 */
    println("\nNow traverse a tuple using functional operation:")
    tuple1.productIterator.foreach { x => println(x) }
  }
}