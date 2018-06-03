package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.atomic

import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.atomic.common.ConvenienceStore
import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.atomic.common.Customer
import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.atomic.common.Supplier

/**
 * 	This is a stand-alone object to test atomics
 *  -- One of most important features for atomics is CAS (Compare And Set/Swap)
 *     -- This feature ensures the mechanism of lock-free concurrency for thread-safety
 * 	-- Naturally atomics cannot only guarantee the computation of atomic resources is correct
 *     -- Atomics do not guarantee the sequences cooperated with other methods
 *        -- E.g., use "println" to print the computed result
 *     -- To ensure the sequences, can use synchronization 
 * 
 * 	There are 2 types of atomics:
 *  -- Atomic primitive: AtomicInteger, AtomicLong, AtomicBoolean
 *  -- Atomic reference: AtomicReference
 * 
 * 	@author VinceYuan
 */
object TestAtomic {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testAtomicInteger1()
//    testAtomicInteger2()
  }
  
  /**
   * 	This is a method to test atomic integer
   * 	-- The results are correct, but not sequential
   */
  private def testAtomicInteger1(): Unit = {
    
    /*	Initialization of shared resources and threads	*/
    val convenienceStore = new ConvenienceStore()
    val customer1 = new Customer(convenienceStore)
    val customer2 = new Customer(convenienceStore)
    val customer3 = new Customer(convenienceStore)
    
    /*	Start threads	 */
    customer1.start()
    customer2.start()
    customer3.start()
  }
  
  /**
   * 	This is a method to test atomic integer
   * 	-- The results are correct, but not sequential
   */
  private def testAtomicInteger2(): Unit = {
    
    /*	Initialization of shared resources and threads	*/
    val convenienceStore = new ConvenienceStore()
    val supplier1 = new Supplier(convenienceStore)
    val supplier2 = new Supplier(convenienceStore)
    val supplier3 = new Supplier(convenienceStore)
      
    /*	Start threads	 */
    supplier1.start()
    supplier2.start()
    supplier3.start()
  }
}