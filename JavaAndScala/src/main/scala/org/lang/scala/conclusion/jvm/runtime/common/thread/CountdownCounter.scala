package org.lang.scala.conclusion.jvm.runtime.common.thread

/**
 * 	This is a stand-alone class to act as a thread to count down
 * 	
 * 	Daemon thread: 
 * 	-- A thread that does not prevent the JVM from exiting when the program finishes but the thread is still running
 *     -- E.g., GC (garbage collection)
 * 
 * 	@author VinceYuan
 */
class CountdownCounter extends Thread {

  setDaemon(true)
  
  override def run(): Unit = {
    
    val currentThread = Thread.currentThread()
    currentThread.setName("Countdown")
    
    for (count <- 10 to 1 by -1) {
      println(s"${currentThread.getName}: ${count}")
    }
  }
}