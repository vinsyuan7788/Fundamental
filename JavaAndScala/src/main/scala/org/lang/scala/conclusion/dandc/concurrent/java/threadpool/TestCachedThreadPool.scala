package org.lang.scala.conclusion.dandc.concurrent.java.threadpool

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import org.lang.scala.conclusion.dandc.common.classes.thread

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

/**
 * 	This is a stand-alone object to test cached thread pool
 *  -- Cached thread pool can create new threads as needed, but will reuse previously constructed threads when they are available
 *     -- These pools will typically improve the performance of programs that execute many short-lived asynchronous tasks
 *  -- Suitable for the situation where tasks are I/O-intensive
 * 	-- When cached thread pool executer executes threads, those threads are run concurrently
 *     -- No matter the threads are executed by "invoke*()", "submit()" or "execute()" through the thread pool executor
 *     -- "execute()": start running threads without waiting for their completion
 *     -- "invoke*()", "submit()": start running threads and wait for their completion if return results need to be processed
 *         -- Otherwise (if no need to process return results in the future) those threads will NOT be waited for
 * 
 * 	@author VinceYuan
 */
object TestCachedThreadPool {
  
  /*	Necessary instance variables	*/
  val callableCountdownCounter = new thread.callable.CountdownCounter()
  val callableCountupCounter = new thread.callable.CountupCounter()
  val runnableCountdownCounter = new thread.runnable.CountdownCounter()
  val runnableCountupCounter = new thread.runnable.CountupCounter()
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testCachedThreadPool()
  }
  
  /**
   * 	This is a method to test cached thread pool
   *  -- To check the concurrency effect clearly, can run this method for a couple of times
   */
  private def testCachedThreadPool(): Unit = {
    
    /*	Get cached thread pool	*/
    val threadPoolExecutor = Executors.newCachedThreadPool()
    
    /*	Start running threads	 */
    println("\"threadPoolExecutor.invoke*(threads)\":")
    val callableThreads = List(callableCountdownCounter, callableCountupCounter)
    val futureResults = threadPoolExecutor.invokeAll(callableThreads)
    
    /*	Wait for the completion of threads and do something after the completion of threads ACCORDING TO THE RETURN RESULTS	 */
    if (futureResults.filter { taskResult => taskResult.get == false }.size != 0) System.exit(-1)
 
    /*	Start running threads	 */
    println("\"threadPoolExecutor.submit(thread)\":")
    val futureResult1 = threadPoolExecutor.submit(callableCountdownCounter)
    val futureResult2 = threadPoolExecutor.submit(callableCountupCounter)
    
    /*	Wait for the completion of threads and do something after the completion of threads ACCORDING TO THE RETURN RESULTS	 */
    if (futureResult1.get == false || futureResult2.get == false) System.exit(-1)
    
    /*	Start running threads	 */
    println("\"threadPoolExecutor.execute(thread)\":")
    threadPoolExecutor.execute(runnableCountdownCounter)
    threadPoolExecutor.execute(runnableCountupCounter)
    
    /*
     * 	Shutdown the thread pool executor, so that it will NOT accept threads any more
     *  -- In the systems (or servers) that need to continuously process incoming requests (or tasks, threads, etc.), should never shut it down
     */
    threadPoolExecutor.shutdown()          
    /*
     * 	Execute a thread after thread pool executer shutdown will throw an exception
     */
//    try {
//      threadPoolExecutor.execute(runnableCountdownCounter)
//      threadPoolExecutor.execute(runnableCountupCounter) 
//    } catch {
//      case t: Throwable => t.printStackTrace()
//    }
    
    /*
     * 	Wait until all tasks have completed execution after a shutdown request,
     * 	or the timeout occurs, or the current thread is interrupted, whichever happens first
     */
    threadPoolExecutor.awaitTermination(24, TimeUnit.HOURS)
  }
}