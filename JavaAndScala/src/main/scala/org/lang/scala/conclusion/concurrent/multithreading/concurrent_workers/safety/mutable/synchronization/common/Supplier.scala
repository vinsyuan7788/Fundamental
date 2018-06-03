package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.synchronization.common

import scala.util.Random

/**
 * 	This is a stand-alone class to serve as a producer
 * 
 * 	@author VinceYuan
 */
class Supplier(

    private val convenienceStore: ConvenienceStore

) extends Thread {
  
  /**
   * 	This is a method to specify what this thread needs to run
   */
  override def run() = {
    
    /*	Get max times to sell items	 */
    val maxTimes = Random.nextInt(5) + 1
    
    /*	Get how many items to sell items	*/
    val salesNumber = Random.nextInt(10) + 1
    
    /*	Loop to sell items to convenience store	 */
    for (i <- 1 to maxTimes) {
      sellItem(salesNumber)
    }
  }
  
  /**
   * 	This is a method that represents the behavior of a supplier (thread)
   */
  private def sellItem(number: Int) = {
    convenienceStore.purchaseItem(number)
  }
}