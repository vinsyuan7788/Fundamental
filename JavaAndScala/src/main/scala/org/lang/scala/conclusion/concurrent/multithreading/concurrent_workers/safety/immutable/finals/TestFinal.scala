package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.immutable.finals

import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.immutable.finals.common.InstanceManager
import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.immutable.finals.common.ManipulateInstance

/**
 * 	This is a stand-alone object to test "final" keyword for thread-safety
 * 	-- This is equivalent as "val" keyword in Scala
 * 
 * 	@author VinceYuan
 */
object TestFinal {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testFinal()
  }
  
  /**
   * 	This is a method to test "final" keyword
   */
  private def testFinal(): Unit = {
    
    /*	Initialization of third-party utility and threads	 */
    val instanceManager = new InstanceManager()
    val manipulateInstance1 = new ManipulateInstance(instanceManager)
    val manipulateInstance2 = new ManipulateInstance(instanceManager)
    val manipulateInstance3 = new ManipulateInstance(instanceManager)
    
    /*	Start threads	 */
    manipulateInstance1.start()
    manipulateInstance2.start()
    manipulateInstance3.start()
  }
}