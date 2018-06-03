package org.lang.scala.conclusion.dandc.concurrent.java.atomic.primitive

import java.util.concurrent.Callable
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

import org.lang.scala.conclusion.dandc.common.utils.ThreadUtils

/**
 * 	This is a stand-alone object to test atomic number
 *  -- It includes AtomicInteger, AtomicLong
 *  -- Theses classes provide a thread-safe and lock-free method to access variables
 * 
 * 	@author VinceYuan
 */
object TestAtomicNumber {

  /*	Necessary instance variables	*/
  private val threadPoolExecutor = ThreadUtils.newCachedThreadPool()
  private val initialInt = 0
  private var intCount: Int = _
  private val atomicInt = new AtomicInteger(initialInt)
  private val threadsToAccessInt = generateThreadsToAccessInt()
  private val initialLong = 0L
  private var longCount: Long = _
  private val atomicLong = new AtomicLong(initialLong)
  private val threadsToAccessLong = generateThreadsToAccessLong()
  
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
    var futureResults = threadPoolExecutor.invokeAll(threadsToAccessInt)
    
    /*	Wait for the completion of the threads and do something according to return results	 */
    if (futureResults.filter { returnResult => returnResult.get == false }.size != 0) System.exit(-1)
    println(s"After increment of ${threadsToAccessInt.size} threads, the Int-typed result is ${intCount}.\n")
    
    /*	Start running threads	 */
    futureResults = threadPoolExecutor.invokeAll(threadsToAccessLong)
    
    /*	Wait for the completion of the threads and do something according to return results	 */
    if (futureResults.filter { returnResult => returnResult.get == false }.size != 0) System.exit(-1)
    println(s"After increment of ${threadsToAccessLong.size} threads, the Long-typed result is ${longCount}.")
    threadPoolExecutor.shutdown()     
  }
  
  /**
   * 	This is a method to generate threads to access integer
   */
  private def generateThreadsToAccessInt() = {
    
    /*	Initialize a list to contain threads	 */
    var threads = List[Callable[Boolean]]()
    
    /*	Add threads into the list	 */
    for (i <- 0 until 10) {
      val thread = new Callable[Boolean]() {
        override def call(): Boolean = {
          try {
            for (i <- 0 until 10000) {
              intCount = atomicInt.addAndGet(1)  
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
   * 	This is a method to generate threads to access long
   */
  private def generateThreadsToAccessLong() = {
    
    /*	Initialize a list to contain threads	 */
    var threads = List[Callable[Boolean]]()
    
    /*	Add threads into the list	 */
    for (i <- 0 until 10) {
      val thread = new Callable[Boolean]() {
        override def call(): Boolean = {
          try {
            for (i <- 0 until 10000) {
              longCount = atomicLong.incrementAndGet() 
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