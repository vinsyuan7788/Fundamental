package org.lang.scala.common.test

import org.lang.scala.common.utils.OrdinalUtils

/**
 * 	This is a stand-alone object to test OrdianlUtils
 * 
 * 	@author VinceYuan
 */
object TestOrdinalUtils {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testOrdinalUtils()
  }
  
  /**
   * 	This is a method to test OrdinalUtils
   */
  private def testOrdinalUtils(): Unit = {

    val num1 = 1
    val num2 = 11
    val num3 = 21
    
    println(s"${num1} ---> ${OrdinalUtils.toOrdinal(num1)}")
    println(s"${num2} ---> ${OrdinalUtils.toOrdinal(num2)}")
    println(s"${num3} ---> ${OrdinalUtils.toOrdinal(num3)}")
  }
}