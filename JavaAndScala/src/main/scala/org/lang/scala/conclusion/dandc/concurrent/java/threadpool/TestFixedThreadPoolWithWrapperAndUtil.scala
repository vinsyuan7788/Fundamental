package org.lang.scala.conclusion.dandc.concurrent.java.threadpool

import java.util.concurrent.TimeUnit
import org.lang.scala.conclusion.dandc.common.classes.thread
import org.lang.scala.conclusion.dandc.common.utils.ThreadUtils

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

/**
 * 	This is a stand-alone object to test fixed thread pool with wrapper and utility classes
 *  -- This kind of design that wraps bottom-level classes (to scale or provide more functionality, etc.) is widely adopted in practical development
 *     -- E.g., Spark, etc. 
 *  
 *  @author VinceYuan
 */
object TestFixedThreadPoolWithWrapperAndUtil {
  
  /*	Necessary instance variables	*/
  val callableCountdownCounter = new thread.callable.CountdownCounter()
  val callableCountupCounter = new thread.callable.CountupCounter()
  val runnableCountdownCounter = new thread.runnable.CountdownCounter()
  val runnableCountupCounter = new thread.runnable.CountupCounter()
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testFixedThreadPoolWithWrapperAndUtil()
  }
  
  /**
   * 	This is a method to test fixed thread pool with wrapper and utility classes
   *  -- To check the concurrency effect clearly, can run this method for a couple of times
   */
  private def testFixedThreadPoolWithWrapperAndUtil(): Unit = {

    /*	Get fixed thread pool	 */
    val availableProcessors = Runtime.getRuntime.availableProcessors()
    val threadPoolExecutor = ThreadUtils.newFixedThreadPool(availableProcessors)
    println(s"There are ${availableProcessors} threads for this fixed thread pool.")
    
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
     * 	Wait until all tasks have completed execution after a shutdown request,
     * 	or the timeout occurs, or the current thread is interrupted, whichever happens first
     */
    threadPoolExecutor.awaitTermination(24, TimeUnit.HOURS)
  }
}