package org.lang.scala.conclusion.dandc.common.classes.thread.runnable

/**
 * 	This is a stand-alone class to act as a thread to count up
 * 
 * 	Daemon thread: 
 * 	-- A thread that does not prevent the JVM from exiting when the program finishes but the thread is still running
 *     -- E.g., GC (garbage collection)
 * 
 * 	@author VinceYuan
 */
class CountupCounter extends Thread {
  
  setDaemon(true)
  
  override def run(): Unit = {
    
    val currentThread = Thread.currentThread()
    currentThread.setName("Countup")
    
    for (count <- 1 to 10) {
      println(s"${currentThread.getName}: ${count}")
    }
  }
}