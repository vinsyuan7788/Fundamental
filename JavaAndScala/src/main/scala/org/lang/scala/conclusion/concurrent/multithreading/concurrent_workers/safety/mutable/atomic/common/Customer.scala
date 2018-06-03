package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.atomic.common

import scala.util.Random

/**
 * 	This is a stand-alone class to serve as a consumer
 * 
 * 	@author VinceYuan
 */
class Customer(
    
    private val convenienceStore: ConvenienceStore
    
) extends Thread { 
  
  /**
   * 	This is a method to specify what exactly this thread to run
   */
  override def run() = {
    
    /*	Get how many items to purchase	*/
    val purchaseNumber = Random.nextInt(10) + 1
    
    /*	Purchase items from convenience store	 */
    purchaseItem(purchaseNumber)
  }
  
  /**
   * 	This is a method that represents the behaviors of a customer (thread)
   */
  private def purchaseItem(number: Int) = {
    convenienceStore.sellItem(number)
  }
}