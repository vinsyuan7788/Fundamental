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
class InstanceNumberReducer extends Runnable {
  
  /*	Instance variables that are operated within thread instance	 */
  private var number = 10
  
  /**
   * 	This is a method to specify what exactly the thread needs to run
   */
  override def run() = {
    
    /*	Get current thread	*/
    val currentThread = Thread.currentThread()
    
    /*	Loop to reduce the value of the global number	 */
    for (i <- 1 to 10) {
      number -= 1
      println(s"Thread ${currentThread.getId} number: ${number}")
    }
  }
}