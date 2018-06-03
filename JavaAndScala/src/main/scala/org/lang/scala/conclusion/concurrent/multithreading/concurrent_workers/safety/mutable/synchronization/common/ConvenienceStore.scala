package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.synchronization.common

/**
 * 	This is a stand-alone class to serve as a shared resource
 * 
 * 	@author VinceYuan
 */
abstract class ConvenienceStore {
  
  /*	Instance variables that serve as global resources that will be shared and operated by multiple threads	*/
  var itemStock = 100
  
  /*	Instance variable that serves as a lock for synchronization	 */
  private val lock = new Object()
  
  /*	Print initial information of the convenience store	*/
  println(s"The item-stock is ${itemStock} in the store initially.")
  
  /**
   * 	This is a method to be invoked by customer (threads) to buy items
   */
  final def sellItem(number: Int) = {
    lock.synchronized {
      itemStock -= number
      println(s"Customer ${Thread.currentThread().getId()} purchased ${number} items. Now ${itemStock} left in the store.") 
    }
  }
  
  /**
   * 	This is a method to be invoked by supplier (threads) to sell items
   */
  def purchaseItem(number: Int): Unit
}