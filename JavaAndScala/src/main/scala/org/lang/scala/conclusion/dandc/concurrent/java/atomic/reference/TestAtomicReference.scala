package org.lang.scala.conclusion.dandc.concurrent.java.atomic.reference

import java.util.concurrent.Callable
import java.util.concurrent.atomic.AtomicReference

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

import org.lang.scala.conclusion.dandc.common.classes.spark.context.SparkContext
import org.lang.scala.conclusion.dandc.common.utils.ThreadUtils

/**
 * 	This is a stand-alone object to test AtomicReference class
 * 
 * 	@author VinceYuan
 */
object TestAtomicReference {
  
  /*	Necessary instance variables	*/
  private val threadPoolExecutor = ThreadUtils.newCachedThreadPool()
  private val initialString = "Hello Scala"
  private val newString = "Hello Spark"
  private val atomicString = new AtomicReference[String](initialString)
  private val threadsToAccessString = generateThreadsToAccessString()
  private val initialContext = SparkContext.getOrCreate()
  private val newContext = SparkContext.getOrCreate()
  private val atomicReference = new AtomicReference[SparkContext](initialContext)
  private val threadsToAccessObject = generateThreadsToAccessObject()
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testAtomicReference()
  }
  
  /**
   * 	This is a method to test AtomicReference class
   */
  private def testAtomicReference(): Unit = {

    /*	Start running threads	 */
    var futureResults = threadPoolExecutor.invokeAll(threadsToAccessString)
    
    /*	Wait for the completion of the threads and do something according to return results	 */
    if (futureResults.filter { returnResult => returnResult.get == false }.size != 0) System.exit(-1)
    println("Only 1 thread can access the string atomically since only the first one accessing initialString can update to newString.\n")
    
    /*	Start running threads	 */
    futureResults = threadPoolExecutor.invokeAll(threadsToAccessObject)
    
    /*	Wait for the completion of the threads and do something according to return results	 */
    if (futureResults.filter { returnResult => returnResult.get == false }.size != 0) System.exit(-1)
    println(s"All threads can access SparkContext instance since initialContext equals newSContext for all threads.")
    threadPoolExecutor.shutdown()
  }
  
  /**
   * 	This is a method to generate threads to access string atomically
   */
  private def generateThreadsToAccessString() = {
    
    /*	Initialize a list to contain threads	 */
    var threads = List[Callable[Boolean]]()
    
    /*	Add threads into the list	 */
    for (i <- 0 until 10) {
      val thread = new Callable[Boolean]() {
        override def call(): Boolean = {
          try {
            if (atomicString.compareAndSet(initialString, newString)) {
              println(s"Thread ${i} updates the value of string successfully!")
            } else {
              println(s"Thread ${i} cnanot update the value of string!")
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
  
  /**
   * 	This is a method to generate threads to access object atomically
   */
  private def generateThreadsToAccessObject() = {
  
    /*	Initialize a list to contain threads	 */
    var threads = List[Callable[Boolean]]()
    
    /*	Add threads into the list	 */
    for (i <- 0 until 10) {
      val thread = new Callable[Boolean]() {
        override def call(): Boolean = {
          try {
            if (atomicReference.compareAndSet(initialContext, newContext)) {
              println(s"Thread ${i} updates the value of object successfully!")
            } else {
              println(s"Thread ${i} cnanot update the value of object!")
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