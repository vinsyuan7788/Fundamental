package org.lang.scala.conclusion.dandc.concurrent.java.threadpool

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import org.lang.scala.conclusion.dandc.common.classes.thread

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

/**
 * 	This is a stand-alone object to test scheduled thread pool
 *  -- Scheduled thread pool can schedule threads to run after a given delay, or to execute periodically
 *  -- Suitable for the situation where tasks need to be scheduled once or periodically
 *  -- If threads are scheduled to execute at the same time, they will be run concurrently
 *     -- No matter which "schedule*()" method is used to schedule threads
 *     -- "scheduleAtFixedRate()" and "scheduleWithFixedDelay()": schedule threads without waiting for their completion
 *     -- "schedule()": schedule threads and wait for their completion if return results need to be processed
 *        -- Otherwise (if no need to process return results in the future) those threads will NOT be waited for
 *        
 *  @author VinceYuan
 */
object TestScheduledThreadPool {
  
  /*	Necessary instance variables	*/
  val callableCountdownCounter = new thread.callable.CountdownCounter()
  val callableCountupCounter = new thread.callable.CountupCounter()
  val runnableCountdownCounter = new thread.runnable.CountdownCounter()
  val runnableCountupCounter = new thread.runnable.CountupCounter()
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testScheduledThreadPool()
  }
  
  /**
   * 	This is a method to test scheduled thread pool
   * 	-- To check the concurrency effect clearly, can run this method for a couple of times
   */
  private def testScheduledThreadPool(): Unit = {
    
    /*	Get scheduled thread pool	 */
    val threadPoolExecutor = Executors.newScheduledThreadPool(10)

    /*	Schedule threads with a specified delay	and wait for completion of the threads	*/
    println("\"threadPoolExecutor.schedule(thread, delay, timeUnit)\":")
    val futureResult1 = threadPoolExecutor.schedule(callableCountdownCounter, 3, TimeUnit.SECONDS)
    val futureResult2 = threadPoolExecutor.schedule(callableCountupCounter, 3, TimeUnit.SECONDS)
    
    /*	Wait for the completion of threads and do something after the completion of threads ACCORDING TO THE RETURN RESULTS	 */
    if (futureResult1.get == false || futureResult2.get == false) System.exit(-1)
    
    /*	Schedule threads with a specified delay and period	*/
    println("\"threadPoolExecutor.schedule(thread, delay, period, timeUnit)\":")
    threadPoolExecutor.scheduleAtFixedRate(runnableCountdownCounter, 6, 5, TimeUnit.SECONDS)
    threadPoolExecutor.scheduleAtFixedRate(runnableCountupCounter, 6, 5, TimeUnit.SECONDS)
    
    /*
     * 	Shutdown the thread pool executor, so that it will NOT schedule threads any more
     *  -- In the systems (or servers) that need to continuously schedule tasks (or threads, etc.), should never shut it down
     */
//    threadPoolExecutor.shutdown()
  }
}