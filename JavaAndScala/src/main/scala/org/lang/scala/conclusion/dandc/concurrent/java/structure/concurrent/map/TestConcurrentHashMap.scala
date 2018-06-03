package org.lang.scala.conclusion.dandc.concurrent.java.structure.concurrent.map

import java.util.concurrent.Callable
import java.util.concurrent.ConcurrentHashMap

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

import org.lang.scala.conclusion.dandc.common.utils.ThreadUtils

/**
 * 	This is a stand-alone object to test ConcurrentHashMap class
 *  -- The lock of concurrent hash map is bucket-level lock
 *     -- Hence only the bucket of the map where whatever operation is performed by a thread is locked
 *     -- The rest of the map is still available for other threads
 *  -- Suitable for situation where there is high-concurrency
 *  -- Much more efficient than synchronized map
 *     -- Run "TestSynchronizedMap.scala" under current package for comparison
 * 
 * 	@author VinceYuan
 */
object TestConcurrentHashMap {
  
  /*	Necessary instance variables	*/
  private val map = new ConcurrentHashMap[String, Int]()
  private val threadPoolExecutor = ThreadUtils.newCachedThreadPool()
  private val threadNum = 10
  private val (keys, threads) = generateListForTest(threadNum)

  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testConcurrentHashMap()
  }
  
  /**
   * 	This is a method to test ConcurrentHashMap class
   */
  private def testConcurrentHashMap(): Unit = {
    
    /*	Start running threads	 */
    val futureResults = threadPoolExecutor.invokeAll(threads)
    
    /*	Wait for the completion of the threads and do something according to the return results	 */
    if (futureResults.filter { taskResult => taskResult.get == false }.size != 0) System.exit(-1)
    keys.foreach { key => println(s"${key}: ${map.get(key)}") }
    threadPoolExecutor.shutdown()
  }
  
  /**
   * 	This is a method to generate lists for test
   */
  private def generateListForTest(threadNum: Int) = {
    
    /*	Initialize some lists to contain keys, threads, start-time and end-time	 */
    var keys = List[String]()
    var threads = List[Callable[Boolean]]()
    
    /*	Add threads, start-time and end-time to the lists	 */
    for (i <- 0 until threadNum) {
      val key = "thread" + i
      map.put(key, 0)
      keys :+= key
      val thread = new Callable[Boolean]() {
        override def call(): Boolean = this.synchronized {
          try {
            val startTime = System.currentTimeMillis()
            for (j <- 0 until 10000000) map.put(keys(i), map.get(keys(i)) + 1)
            val endTime = System.currentTimeMillis()
            println(s"Time elapsed for thread ${i}: ${endTime - startTime}")
            true
          } catch {
            case t: Throwable => false 
          } 
        }
      }
      threads :+= thread
    }
    
    /*	Return the lists	*/
    (keys, threads)
  }
}