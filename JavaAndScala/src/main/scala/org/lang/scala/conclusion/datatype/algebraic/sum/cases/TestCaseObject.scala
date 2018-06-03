package org.lang.scala.conclusion.datatype.algebraic.sum.cases

import scala.reflect.runtime.universe
import scala.util.Random

import org.lang.scala.common.utils.ReflectionUtils
import org.lang.scala.conclusion.datatype.algebraic.sum.cases.objects.Green
import org.lang.scala.conclusion.datatype.algebraic.sum.cases.objects.Red
import org.lang.scala.conclusion.datatype.algebraic.sum.cases.objects.Yellow
import org.lang.scala.conclusion.datatype.algebraic.sum.cases.objects.parent.TrafficLight

/**
 * 	This is a stand-alone object to test sum type implemented by case object
 * 
 * 	@author VinceYuan
 */
object TestCaseObject {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testCaseObject()
  }
  
  /**
   * 	This is a method to test sum type implemented by case object
   */
  def testCaseObject(): Unit = {
    
    val red: TrafficLight = Red
    val yellow: TrafficLight = Yellow
    val green: TrafficLight = Green
    val arr = Array(red, yellow, green)
    val trafficLight = arr(Random.nextInt(arr.length))
    println(trafficLight)
    println(ReflectionUtils.getRuntimeType(trafficLight))
    trafficLight match {
      case Red => println("Stop!")
      case Yellow => println("Hurry up!")
      case Green => println("Run!")
    }
  }
}