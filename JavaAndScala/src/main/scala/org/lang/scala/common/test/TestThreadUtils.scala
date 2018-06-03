package org.lang.scala.common.test

import org.lang.scala.common.utils.ThreadUtils

/**
 * 	This is a stand-alone object to test ThreadUtils
 * 
 * 	@author VinceYuan
 */
object TestThreadUtils {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testThreadUtils()
  }
  
  /**
   * 	This is a method to test ThreadUtils
   */
  private def testThreadUtils(): Unit = {
    
    val threadInfo = ThreadUtils.getThreadInfo(Thread.currentThread())
    println(threadInfo.mkString("\n"))
  }
}