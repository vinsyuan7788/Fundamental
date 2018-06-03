package org.lang.scala.conclusion.math

import scala.util.Random

/**
 * 	This is a stand-alone object to test math and Random
 * 
 * 	@author VinceYuan
 */
object TestMathAndRandom {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests Scala Math and Random:")
    testMathAndRandom()
    println("\nHere tests more Scala Math API:")
    testMathAPI()
  }
  
  /**
   * 	This is a method to test math and Random
   */
  private def testMathAndRandom(): Unit = {
    
    /*	Here picks 2 integers randomly and process them	 */
    println("Here picks 2 elements randomly and process them:")
    val array = Array(123, 567, 432, 987)
    val randElem1 = array(Random.nextInt(array.length))
    val randElem2 = array((math.random * 4).toInt)
    val maxNum = math.max(math.max(randElem1, randElem2), math.pow(2, 9)).toInt
    val minNum = math.min(math.min(randElem1, randElem2), math.pow(2, 9)).toInt
    println(array.toBuffer)
    println(randElem1)
    println(randElem2)
    println(maxNum)
    println(minNum)
    
    /*	Here randomly generates an integer in [50, 100]	 */
    println("\nHere randomly generates an integer in [50, 100]:")
    val randGenNum1 = 50 + Random.nextInt(51)
    val randGenNum2 = 50 + math.round(math.random * 50).toInt
    val randGenNum3 = 50 + math.floor(math.random * 51).toInt
    val randGenNum4 = 49 + math.ceil(math.random * 51).toInt
    println(randGenNum1)
    println(randGenNum2)
    println(randGenNum3)
    println(randGenNum4)
  }
  
  /**
   * 	This is a method to test Scala Math API
   */
  private def testMathAPI(): Unit = {
    
    /*	Here defines some numbers	 */
    val num1 = 3.2
    val num2 = 3.5
    val num3 = 3.8
    
    /*	Here rounds the number	*/
    println(s"${num1} --- (round) ---> ${math.round(num1)}")    // 3
    println(s"${num2} --- (round) ---> ${math.round(num2)}")    // 4
    println(s"${num3} --- (round) ---> ${math.round(num3)}")    // 4
    
    /*	Here floors the number	*/
    println(s"${num1} --- (floor) ---> ${math.floor(num1)}")
    println(s"${num2} --- (floor) ---> ${math.floor(num2)}")
    println(s"${num3} --- (floor) ---> ${math.floor(num3)}")
    
    /*	Here ceils the number	 */
    println(s"${num1} --- (ceil) ---> ${math.ceil(num1)}")
    println(s"${num2} --- (ceil) ---> ${math.ceil(num2)}")
    println(s"${num3} --- (ceil) ---> ${math.ceil(num3)}")
  }
}