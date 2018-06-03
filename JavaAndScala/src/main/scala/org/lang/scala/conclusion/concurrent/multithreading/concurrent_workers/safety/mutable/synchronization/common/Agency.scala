package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.synchronization.common

/**
 * 	This is a stand-alone class to serve as a producer
 * 
 * 	@author VinceYuan
 */
class Agency (

    private val university: University

) extends Thread {
  
  /**
   * 	This is a method to specify what this thread needs to run
   */
  override def run() = {
    
    /*	Loop to introduce students	*/
    for (i <- 0 until 20) {
      introduceStudent(5)
    }
  }
  
  /**
   * 	This is a method to introduce students to the university
   */
  private def introduceStudent(number: Int) = {
    university.enrollStudent(number)
  }
}