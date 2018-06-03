package org.lang.scala.conclusion.dandc.concurrent.java.threadpool

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import org.lang.scala.conclusion.dandc.common.classes.thread

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

/**
 * 	This is a stand-alone object to test single thread executor
 *  -- Suitable for the situation where only one task is needed
 *     -- Equivalent to "Executors.newFixedThreadPool(1)"
 * 	-- Single thread executor can use only a single (worker) thread
 *     -- Hence all operations "invoke*(threads)", "submit(thread)" and "execute(thread)" will run threads sequentially
 *     -- "execute()": start running threads without waiting for their completion
 *     -- "invoke*()", "submit()": start running threads and wait for their completion if return results need to be processed
 *        -- Otherwise (if no need to process return results in the future) those threads will NOT be waited for
 *        
 * 	@author VinceYuan
 */
object TestSingleThreadExecutor {

  /*	Necessary instance variables	*/
  val callableCountdownCounter = new thread.callable.CountdownCounter()
  val callableCountupCounter = new thread.callable.CountupCounter()
  val runnableCountdownCounter = new thread.runnable.CountdownCounter()
  val runnableCountupCounter = new thread.runnable.CountupCounter()
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testSingleThreadExecutor()
  }
  
  /**
   * 	This is a method to test single thread executor
   *  -- To check the sequential effect clearly, can run this method for a couple of times
   */
  private def testSingleThreadExecutor(): Unit = {
    
    /*	Get single thread executor	*/
    val threadPoolExecutor = Executors.newSingleThreadExecutor()

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