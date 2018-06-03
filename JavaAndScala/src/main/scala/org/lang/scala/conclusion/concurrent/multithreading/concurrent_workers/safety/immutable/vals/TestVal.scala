package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.immutable.vals

import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.immutable.vals.common.InstanceManager
import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.immutable.vals.common.ManipulateInstance

/**
 * 	This is a stand-alone object to test "val" keyword for thread-safety
 * 	-- This is equivalent to "final" keyword in Java
 * 
 * 	@author VinceYuan
 */
object TestVal {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testVal()
  }
  
  /**
   * 	This is a method to test "val" keyword
   */
  private def testVal(): Unit = {
    
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