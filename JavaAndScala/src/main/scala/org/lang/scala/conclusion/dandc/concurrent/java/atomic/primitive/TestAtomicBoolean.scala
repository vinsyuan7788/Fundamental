package org.lang.scala.conclusion.dandc.concurrent.java.atomic.primitive

import java.util.concurrent.Callable
import java.util.concurrent.atomic.AtomicBoolean

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

import org.lang.scala.conclusion.dandc.common.utils.ThreadUtils

/**
 * 	This is a stand-alone object to test atomic boolean
 *  -- It includes AtomicBoolean
 *  -- Theses classes provide a thread-safe and lock-free method to access variables
 * 
 * 	@author VinceYuan
 */
object TestAtomicBoolean {
  
  /*	Necessary instance variables	*/
  private val threadPoolExecutor = ThreadUtils.newCachedThreadPool()
  private val initialBoolean = true
  private val newBoolean = false
  private val atomicInt = new AtomicBoolean(initialBoolean)
  private val threadsToAccessBoolean = generateThreadsToAccessBoolean()
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testAtomicNumber()
  }
  
  /**
   * 	This is a method to test atomic number
   */
  private def testAtomicNumber(): Unit = {

    /*	Start running threads	 */
    var futureResults = threadPoolExecutor.invokeAll(threadsToAccessBoolean)
    
    /*	Wait for the completion of the threads and do something according to return results	 */
    if (futureResults.filter { returnResult => returnResult.get == false }.size != 0) System.exit(-1)
    println(s"Only 1 thread can access the boolean atomically since only the first one accessing initialBoolean can update to newBoolean.")
    threadPoolExecutor.shutdown()     
  }
  
  /**
   * 	This is a method to generate threads to access Boolean
   */
  private def generateThreadsToAccessBoolean() = {
    
    /*	Initialize a list to contain threads	 */
    var threads = List[Callable[Boolean]]()
    
    /*	Add threads into the list	 */
    for (i <- 0 until 10) {
      val thread = new Callable[Boolean]() {
        override def call(): Boolean = {
          try {
            if (atomicInt.compareAndSet(initialBoolean, newBoolean)) {
              println(s"Thread ${i} updates the value of boolean successfully!")
            } else {
              println(s"Thread ${i} cnanot update the value of boolean!")
            }
            true
          } catch {
            case t: Throwable => false
          }
        }
      }
      threads :+= thread
    }
    
    /*	Return the list	 */
    threads
  }
}