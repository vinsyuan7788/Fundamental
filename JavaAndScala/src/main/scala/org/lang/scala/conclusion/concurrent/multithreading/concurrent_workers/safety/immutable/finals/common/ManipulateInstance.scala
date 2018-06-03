package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.immutable.finals.common

/**
 * 	This is a stand-alone class to simulate a thread manipulating final instances
 * 
 * 	@author VinceYuan
 */
class ManipulateInstance(
    
    private val instanceManager: InstanceManager

) extends Thread {
  
  /**
   * 	This is a method to specify what exactly this thread to run
   */
  override def run() = {
    
    /*	Get final instances and print	 */
    val username = getInstance()
    println(s"Thread ${getId} username: ${username}")
  }
  
  /**
   * 	This is a method to get instance
   */
  private def getInstance() = {
    instanceManager.getUSERNAME()
  }
}