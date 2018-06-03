package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.atomic.common

import java.util.concurrent.atomic.AtomicInteger

/**
 * 	This is a stand-alone class to serve as a shared resource
 * 	-- The synchronized block here is just to ensure "println" can print the results subsequently right after they are computed by atomics 
 * 
 * 	@author VinceYuan
 */
class ConvenienceStore {
  
  /*	Instance variables that serve as global resources that will be shared and operated by multiple threads	*/
  private val itemStock = new AtomicInteger(100)
  
  /*	Print initial information of the convenience store	*/
  println(s"The item-stock is ${itemStock.get} in the store initially.")
  
  /**
   * 	This is a method to be invoked by customer (threads) to buy items
   */
  def sellItem(number: Int) = {
//    getClass.synchronized {
      println(s"Customer ${Thread.currentThread().getId()} purchased ${number} items. Now ${itemStock.addAndGet(-number)} left in the store.")  
//    }
  }
  
  /**
   * 	This is a method to be invoked by supplier (threads) to sell items
   */
  def purchaseItem(number: Int) = {
//    getClass.synchronized {
      println(s"Supplier ${Thread.currentThread().getId()} sold ${number} items. Now ${itemStock.addAndGet(number)} left in the store.")  
//    }
  }
}