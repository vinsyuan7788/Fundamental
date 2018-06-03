package org.lang.scala.conclusion.dandc.concurrent.java.thread

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

import org.lang.scala.conclusion.dandc.common.classes.thread
import org.lang.scala.conclusion.dandc.common.utils.ThreadUtils

/**
 * 	This is a stand-alone object to test starting running a thread
 * 	-- There are several ways to start running a thread
 *     -- Directly invoke "thread.start()"
 *        -- This way is NOT recommended due to its resource-consuming, low responding-speed and poor manage-ability
 *        -- A recommended way is using a thread pool (unless there is only 1 thread needed for sure)
 *     -- Using a thread pool to execute a thread. E.g, using cached thread pool:
 *        -- "threadPoolExecutor.execute(thread)": do not wait the completion of threads
 *        -- "threadPoolExecutor.invoke*(threads)": wait the completion of threads
 *        -- "threadPoolExecutor.submit(thread)": wait the completion of threads
 *        -- More example refers to "threadpool" package
 *  -- No matter in what way starting running threads, these threads are run concurrently
 * 
 * 	@author VinceYuan
 */
object TestStartRunningThread {
  
  /*	Necessary instance variables	 */
  val callableCountdownCounter = new thread.callable.CountdownCounter()
  val callableCountupCounter = new thread.callable.CountupCounter()
  val runnableCountdownCounter = new thread.runnable.CountdownCounter()
  val runnableCountupCounter = new thread.runnable.CountupCounter()
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests start running a thread directly:")
    testStartRunningThreadDirectly()
    println("\nHere tests starting running a thread through thread pool:")
    testStartRunningThreadThroughThreadPool()
  }
  
  /**
   * 	This is a method to test starting running a thread
   */
  private def testStartRunningThreadDirectly(): Unit = {  

    /*	Start running threads	 */
    runnableCountdownCounter.start()
    runnableCountupCounter.start()
    
    /*	Wait for the completion of threads	*/
    runnableCountdownCounter.join()
    runnableCountupCounter.join()
  }
  
  /**
   * 	This is a method to test starting running a thread through thread pool
   *  -- More examples refer to "threadpool" package
   */
  private def testStartRunningThreadThroughThreadPool(): Unit = {
    
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
    
    /*	Wait for the completion of threads and do something after the completion of threads ACCORDING TO THE RETURN RESULTS	 */
    if (futureResult1.get == false || futureResult2.get == false) System.exit(-1)
    
    /*	Start running threads	 */
    println("Through \"threadPoolExecutor.execute(thread)\":")
    threadPoolExecutor.execute(runnableCountdownCounter)
    threadPoolExecutor.execute(runnableCountupCounter)
    threadPoolExecutor.shutdown()
  }
}