package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.threadlocal

import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.threadlocal.common.AccessDatabase

/**
 * 	This is a method to test ThreadLocal class
 * 
 * 	ThreadLocal facilitates the management of a thread's variable in third-party utility
 * 	-- In thread-sharing class, can declare a ThreadLocal instance to manage the variables corresponding to each thread
 * 
 * 	@author VinceYuan
 */
object TestThreadLocal {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testThreadLocal()
  }
  
  /**
   * 	This is a method to test ThreadLocal class
   */
  private def testThreadLocal(): Unit = {
    
    /*	Initialization of threads	 */
    val accessDatabase1 = new AccessDatabase()
    val accessDatabase2 = new AccessDatabase()
    val accessDatabase3 = new AccessDatabase()
    
    /*	Start threads	 */
    accessDatabase1.start()
    accessDatabase2.start()
    accessDatabase3.start()
  }
}