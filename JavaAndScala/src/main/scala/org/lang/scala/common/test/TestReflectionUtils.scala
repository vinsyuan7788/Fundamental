package org.lang.scala.common.test

import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test ReflectionUtils
 * 
 * 	@author VinceYuan
 */
object TestReflectionUtils {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testReflectionUtils()
  }
  
  /**
   * 	THis is a method to test ReflecitonUtils
   */
  private def testReflectionUtils(): Unit = {
    
    /*	Here tests Scala reflection with primitive types	*/
    var scalaType = ReflectionUtils.getScalaType[Int]
    var javaClass = ReflectionUtils.getJavaClassFromScalaType[Int]
    println(s"Scala ${scalaType} ---> Java ${javaClass}")
    scalaType = ReflectionUtils.getScalaType[Short]
    javaClass = ReflectionUtils.getJavaClassFromScalaType[Short]
    println(s"Scala ${scalaType} ---> Java ${javaClass}")
    scalaType = ReflectionUtils.getScalaType[Long]
    javaClass = ReflectionUtils.getJavaClassFromScalaType[Long]
    println(s"Scala ${scalaType} ---> Java ${javaClass}")
    scalaType = ReflectionUtils.getScalaType[Float]
    javaClass = ReflectionUtils.getJavaClassFromScalaType[Float]
    println(s"Scala ${scalaType} ---> Java ${javaClass}")
    scalaType = ReflectionUtils.getScalaType[Double]
    javaClass = ReflectionUtils.getJavaClassFromScalaType[Double]
    println(s"Scala ${scalaType} ---> Java ${javaClass}")
    scalaType = ReflectionUtils.getScalaType[Byte]
    javaClass = ReflectionUtils.getJavaClassFromScalaType[Byte]
    println(s"Scala ${scalaType} ---> Java ${javaClass}")
    scalaType = ReflectionUtils.getScalaType[Char]
    javaClass = ReflectionUtils.getJavaClassFromScalaType[Char]
    println(s"Scala ${scalaType} ---> Java ${javaClass}")
    scalaType = ReflectionUtils.getScalaType[Boolean]
    javaClass = ReflectionUtils.getJavaClassFromScalaType[Boolean]
    println(s"Scala ${scalaType} ---> Java ${javaClass}\n")
    
    /*	Here tests Scala reflection with complex type	 */
    scalaType = ReflectionUtils.getScalaType[Array[Int]]
    javaClass = ReflectionUtils.getJavaClassFromScalaType[Array[Int]]
    println(s"Scala ${scalaType} ---> Java ${javaClass}")
    scalaType = ReflectionUtils.getScalaType[List[Int]]
    javaClass = ReflectionUtils.getJavaClassFromScalaType[List[Int]]
    println(s"Scala ${scalaType} ---> Java ${javaClass}")
    scalaType = ReflectionUtils.getScalaType[Set[Int]]
    javaClass = ReflectionUtils.getJavaClassFromScalaType[Set[Int]]
    println(s"Scala ${scalaType} ---> Java ${javaClass}")
    scalaType = ReflectionUtils.getScalaType[Map[Int, String]]
    javaClass = ReflectionUtils.getJavaClassFromScalaType[Map[Int, String]]
    println(s"Scala ${scalaType} ---> Java ${javaClass}")
  }
}