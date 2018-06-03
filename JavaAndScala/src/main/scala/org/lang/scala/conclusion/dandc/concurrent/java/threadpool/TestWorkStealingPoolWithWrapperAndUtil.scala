package org.lang.scala.conclusion.dandc.concurrent.java.threadpool

import java.util.concurrent.TimeUnit

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

import org.lang.scala.conclusion.dandc.common.classes.forkjointask
import org.lang.scala.conclusion.dandc.common.classes.thread
import org.lang.scala.conclusion.dandc.common.utils.ThreadUtils

/**
 * 	This is a stand-alone object to test work stealing pool with wrapper and utility classes
 *  -- This kind of design that wraps bottom-level classes (to scale or provide more functionality, etc.) is widely adopted in practical development
 *     -- E.g., Spark, etc. 
 *  
 *  @author VinceYuan
 */
object TestWorkStealingPoolWithWrapperAndUtil {
  
  /*	Necessary instance variables	*/
  val arr1 = Array(1, 5, 3, 6, 2, 4, 0, 9, 7, 8)
  val arr2 = arr1.clone()
  val arr3 = arr1.clone()
  val arr4 = arr1.clone()
  val recursiveQuickSortAction = new forkjointask.recursiveaction.QuickSort(arr1)
  val recursiveHeapSortAction = new forkjointask.recursiveaction.HeapSort(arr2)
  val recursiveQuickSortTask = new forkjointask.recursivetask.QuickSort(arr3)
  val recursiveMergeSortTask = new forkjointask.recursivetask.MergeSort(arr4)
  val callableCountdownCounter = new thread.callable.CountdownCounter()
  val callableCountupCounter = new thread.callable.CountupCounter()
  val runnableCountdownCounter = new thread.runnable.CountdownCounter()
  val runnableCountupCounter = new thread.runnable.CountupCounter()
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testWorkStealingPool()
  }
  
  /**
   * 	This is a method to test work stealing pool
   *  -- To check the concurrency effect clearly, can run this method for a couple of times
   */
  private def testWorkStealingPool(): Unit = {
    
    /*	Get work stealing pool	*/
    val threadPoolExecutor = ThreadUtils.newWorkStealingPool()
    
    /*	Start running recursive action	*/
    println("\"threadPoolExecutor.submit(recursiveAction)\"")
    println(s"Original Array:\n${arr1.mkString(", ")}")
    var futureResult = threadPoolExecutor.submit(recursiveQuickSortAction)
    
    /*	Wait for the completion of threads and do something after the completion of threads ACCORDING TO THE RETURN RESULTS	 */
    futureResult.get
    println(s"Quick-sorted array:\n${arr1.mkString(", ")}")
    
    /*	Start running recursive action	*/
    println(s"Original Array:\n${arr2.mkString(", ")}")
    futureResult = threadPoolExecutor.submit(recursiveHeapSortAction)
    
    /*	Wait for the completion of threads and do something after the completion of threads ACCORDING TO THE RETURN RESULTS	 */
    futureResult.get
    println(s"Heap-sorted array:\n${arr2.mkString(", ")}")
    
    /*	Start running recursive tasks	 */
    println("\"threadPoolExecutor.submit(recursiveTask)\"")
    println(s"Original Array:\n${arr3.mkString(", ")}")
    var futureArray = threadPoolExecutor.submit(recursiveQuickSortTask)
    
    /*	Wait for the completion of threads and do something after the completion of threads ACCORDING TO THE RETURN RESULTS	 */
    var sortedArr = futureArray.get
    println(s"Quick-sorted array:\n${sortedArr.mkString(", ")}")
    
    /*	Start running recursive tasks	 */
    println(s"Original Array:\n${arr4.mkString(", ")}")
    futureArray = threadPoolExecutor.submit(recursiveMergeSortTask)
    
    /*	Wait for the completion of threads and do something after the completion of threads ACCORDING TO THE RETURN RESULTS	 */
    sortedArr = futureArray.get
    println(s"Merge-sorted array:\n${sortedArr.mkString(", ")}")
    
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