package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.synchronization

import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.synchronization.common.Agency
import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.synchronization.common.ConvenienceStore
import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.synchronization.common.ConvenienceStoreJava
import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.synchronization.common.Customer
import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.synchronization.common.Supplier
import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.synchronization.common.University

/**
 * 	This is a stand-alone object to test synchronization
 * 
 * 	There are 2 ways of synchronization
 *  -- Synchronized block (in Scala and Java)
 *  -- Synchronized method (in Java only)
 *  
 *  Resources within synchronized block or method will be considered "atomic" in some way
 *  -- Namely they cannot be accessed by other threads if there is one thread accessing the resources
 *  -- However this is not original atomic, original atomic refers to "atomic" package
 * 
 * 	@author VinceYuan
 */
object TestSynchronization {
   
  /**
   * 	This is a main method for execution
   * 	-- To see the test result correctly, make sure each time there is only 1 method to execute
   */
  def main(args: Array[String]): Unit = {
//    testSynchronizedBlock()
//    testSynchronizedMethod()
    testWithoutSynchronization()
  }
  
  /**
   * 	This is a method to test synchronized block
   */
  private def testSynchronizedBlock(): Unit = {
    
    /*	Initialization of shared resources and threads	*/
    val convenienceStore = new ConvenienceStoreJava().asInstanceOf[ConvenienceStore]
    val customer1 = new Customer(convenienceStore)
    val customer2 = new Customer(convenienceStore)
    val customer3 = new Customer(convenienceStore)
    
    /*	Start threads	 */
    customer1.start()
    customer2.start()
    customer3.start()
  }
  
  /**
   * 	This is a method to test synchronized method
   */
  private def testSynchronizedMethod(): Unit = {
    
    /*	Initialization of shared resources and threads	*/
    val convenienceStore = new ConvenienceStoreJava().asInstanceOf[ConvenienceStore]
    val supplier1 = new Supplier(convenienceStore)
    val supplier2 = new Supplier(convenienceStore)
    val supplier3 = new Supplier(convenienceStore)
      
    /*	Start threads	 */
    supplier1.start()
    supplier2.start()
    supplier3.start()
  }
  
  /**
   * 	This is a method to test resource operations without synchronization
   *  -- Normally will see the incorrect results, since synchronization is used in this case
   *     -- The correct result is 10300 in this case
   */
  private def testWithoutSynchronization(): Unit = {
    
    /*	Initialization of shared resources and threads	*/
    val university = new University()
    val agency1 = new Agency(university)
    val agency2 = new Agency(university)
    val agency3 = new Agency(university)
    
    /*	Start threads	 */
    agency1.start()
    agency2.start()
    agency3.start()
    
    /*	Wait for the completion of threads	*/
    agency1.join()
    agency2.join()
    agency3.join()
    
    /*	Print the final result to confirm if it is correct	*/
    val finalResult = university.studentNumber
    println(s"The final result is ${finalResult}.\nIf the final result is correct? ${finalResult.equals(10300)}")
  }
}