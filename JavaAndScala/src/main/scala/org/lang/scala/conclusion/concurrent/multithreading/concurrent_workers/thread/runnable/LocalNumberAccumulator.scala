package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.thread.runnable

/**
 * 	This is a stand-alone class to implement a call-able thread
 * 
 * 	There is 1 way for call-able thread implementation
 * 	-- Extend (or Implement) "java.util.concurrent.Callable" interface
 *  
 *  The execution of a call-able thread is performed through thread pool
 *  
 *  Notice that particularly a thread can be both runnable and call-able
 *  -- E.g., if want to get information of a call-able thread
 *     -- But normally can use "Thread.currentThread" to get current thread and further related information
 *  
 *  Here the resources that a thread instance operate is within the thread instance
 *  -- The resources can be either global or local within the thread instance
 *  -- The resources only reside in the working memory of current thread instance, which does not interact with JVM main memory
 *     -- Hence these resources do not need to consider thread-safety problem
 * 
 * 	@author VinceYuan
 */
class LocalNumberAccumulator extends Thread {
  
  /**
   * 	This is a method to specify what this thread to run
   */
  override def run() = {
    
    /*	Initialize a sum	*/
    var sum = 0
    
    /*	Add the sum from 1 to 10 and print the result	 */
    for (i <- 1 to 10) {
      sum += i
      println(s"Thread ${getId} sum: ${sum}")
    }
  }
}