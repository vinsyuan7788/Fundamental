package org.lang.scala.conclusion.dandc.concurrent.java.threadpool.threadfactory

import java.util.concurrent.Executors

/**
 * 	This is a stand-alone object to test DefaultThreadFactory class
 *  -- This class can be used to create a thread
 *  -- This class is actually designed to provide utility for Executor class specifically
 *     -- Hence it is defined within Executor class and cannot be explicitly constructed through its constructor (since the constructor is private)
 * 
 * 	@author VinceYuan
 */
object TestDefaultThreadFactory {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testDefaultThreadFactory()
  }
  
  /**
   * 	This is a method to test default thread factory
   */
  private def testDefaultThreadFactory(): Unit = {
    
    val threadFactory = Executors.defaultThreadFactory()
    val countdownCounter = threadFactory.newThread(new Runnable() {
      override def run(): Unit = {
        for (count <- 5 to 1 by -1) println(s"Countdown: ${count}")
      }
    })
    val countupCounter = threadFactory.newThread(new Runnable() {
      override def run(): Unit = {
         for (count <- 1 to 5) println(s"Countup: ${count}")
      }      
    })
    
    val threadPoolExecutor = Executors.newCachedThreadPool(threadFactory)
    threadPoolExecutor.execute(countdownCounter)
    threadPoolExecutor.execute(countupCounter)
    threadPoolExecutor.shutdown()
  }
}