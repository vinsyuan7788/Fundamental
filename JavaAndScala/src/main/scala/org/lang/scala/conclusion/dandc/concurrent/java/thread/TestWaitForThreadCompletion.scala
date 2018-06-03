package org.lang.scala.conclusion.dandc.concurrent.java.thread

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

import org.lang.scala.conclusion.dandc.common.classes.thread
import org.lang.scala.conclusion.dandc.common.utils.ThreadUtils

/**
 * 	This is a stand-alone object to test wait for the completion of a thread
 * 	-- There are several ways to wait for the completion of a thread
 *     -- If thread is started by "thread.start()":
 *        -- Then directly invoke "thread.join()" to wait for its completion, and perform some operation afterwards
 *        -- In this case the threads need to implement Runnable interface (i.e., runnable threads)
 *     -- If using a thread pool, e.g., cached thread pool, then need to start threads by "threadPoolExecutor.invoke*(threads)" or "threadPoolExecutor.submit(thread)":
 *        -- Then use the Future type return value of those method to wait for their completion, and furthermore perform some operation afterwards ACCORDING TO THE RETURN VALUE
 *        -- In this case the threads need to implement Call-able interface (i.e., call-able threads)
 *        -- More example refers to "threadpool" package
 *  -- If starting threads in one way and trying to wait for their completion in another way, it will NOT work
 *     -- Since the mechanism of managing and operating threads behind these two ways are completely different
 * 
 * 	@author VinceYuan
 */
object TestWaitForThreadCompletion {

  /*	Necessary instance variables	*/
  val callableCountdownCounter = new thread.callable.CountdownCounter()
  val callableCountupCounter = new thread.callable.CountupCounter()
  val runnableCountdownCounter = new thread.runnable.CountdownCounter()
  val runnableCountupCounter = new thread.runnable.CountupCounter()

  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests waiting for the comletion of a thread direclty:")
    testWaitForThreadCompletionDirectly()
    println("\nHere tests waiting for the completion of a thread through thread pool:")
    testWaitForThreadCompletionThroughThreadPool()
  }
  
  /**
   * 	This is a method to wait for completion of a thread directly
   */
  private def testWaitForThreadCompletionDirectly(): Unit = {
    
    /*	Start running threads	 */
    runnableCountdownCounter.start()
    runnableCountupCounter.start()
    
    /*	Wait for the completion of threads	*/
    runnableCountdownCounter.join()
    runnableCountupCounter.join()
  }
  
  /**
   * 	This is a method to wait for completion of a thread through thread pool
   *  -- More example refers to "threadpool" package
   */
  private def testWaitForThreadCompletionThroughThreadPool(): Unit = {
    
    /*	Get thread pool	 */
    val threadPoolExecutor = ThreadUtils.newCachedThreadPool()
    
    /*	Start running threads	 */
    println("Through \"threadPoolExecutor.invoke*(threads)\":")
    val callableThreads = List(callableCountdownCounter, callableCountupCounter)
    val futureResults = threadPoolExecutor.invokeAll(callableThreads)
    
    /*	Wait for the completion of threads and do something after the completion of threads ACCORDING TO THE RETURN RESULTS	 */
    if (futureResults.filter { taskResult => taskResult.get == false }.size != 0) System.exit(-1)
    
    /*	Start running threads	 */
    println("Through \"threadPoolExecutor.submit(thread)\":")
    val futureResult1 = threadPoolExecutor.submit(callableCountdownCounter)
    val futureResult2 = threadPoolExecutor.submit(callableCountupCounter)
    threadPoolExecutor.shutdown()
    
    /*	Do not wait for the completion of threads since "future.get" is not invoked	 */
    // ...
  }
}