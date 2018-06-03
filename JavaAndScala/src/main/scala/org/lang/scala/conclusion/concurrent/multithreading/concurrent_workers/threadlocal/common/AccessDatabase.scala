package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.threadlocal.common

/**
 * 	This is a stand-alone class to simulate a thread accessing a database
 * 
 * 	@author VinceYuan
 */
class AccessDatabase extends Thread {
  
  /**
   * 	This is a method to specify what exactly this thread needs to run
   */
  override def run() = {
    
    /*	Get the connection corresponding to current thread	*/
    val connection = ConnectionManager.getConnection(getId)
    
    /*	Print the connection	*/
    println(s"Thread ${getId} connection: ${connection}")
    
    /*	Do the necessary steps to access a database	 */
    // ...
  }
}