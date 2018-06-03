package org.lang.scala.conclusion.oop

import java.util.UUID

import org.lang.scala.conclusion.oop.companion.Developer

/**
 * 	This is a stand-alone object to test companion class and companion object
 * 
 * 	@author VinceYuan
 */
object TestCompanion {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testCompanion()
  }
  
  /**
   * 	This is a method to test companion
   */
  private def testCompanion(): Unit = {
    
    /*	Instantiate 2 instances	 */
    val vince = Developer(UUID.randomUUID().toString(), "Vince", 'M', 200000)
    val violet = Developer(UUID.randomUUID().toString(), "Violet", 'F', 200000)
    
    /*	Invoke methods	*/
    val result = Developer.compareBySalary(vince, violet)
    println(result)
  }
}