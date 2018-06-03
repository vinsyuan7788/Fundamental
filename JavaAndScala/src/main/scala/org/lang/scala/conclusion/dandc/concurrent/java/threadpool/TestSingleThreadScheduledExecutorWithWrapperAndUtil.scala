package org.lang.scala.conclusion.dandc.concurrent.java.threadpool

import java.util.concurrent.TimeUnit
import org.lang.scala.conclusion.dandc.common.classes.thread
import org.lang.scala.conclusion.dandc.common.utils.ThreadUtils

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

/**
 * 	This is a stand-alone object to test single thread scheduled executor with wrapper and utility classes
 *  -- This kind of design that wraps bottom-level classes (to scale or provide more functionality, etc.) is widely adopted in practical development
 *     -- E.g., Spark, etc. 
 *  
 *  @author VinceYuan
 */
object TestSingleThreadScheduledExecutorWithWrapperAndUtil {
  
  /*	Necessary instance variables	*/
  val callableCountdownCounter = new thread.callable.CountdownCounter()
  val callableCountupCounter = new thread.callable.CountupCounter()
  val runnableCountdownCounter = new thread.runnable.CountdownCounter()
  val runnableCountupCounter = new thread.runnable.CountupCounter()
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testSingleThreadScheduledExecutor()
  }
  
  /**
   * 	This is a method to test single thread scheduled executor
   * 	-- To check the sequential effect clearly, can run this method for a couple of times
   */
  private def testSingleThreadScheduledExecutor(): Unit = {
    
    /*	Get single thread scheduled executor	*/
    val threadPoolExecutor = ThreadUtils.newSingleThreadScheduledExecutor()

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