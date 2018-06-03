package org.lang.scala.conclusion.dandc.concurrent.java.threadpool

import java.util.concurrent.Executors
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.TimeUnit

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

import org.lang.scala.conclusion.dandc.common.classes.forkjointask
import org.lang.scala.conclusion.dandc.common.classes.thread

/**
 * 	This is a stand-alone object to test work stealing pool
 *  -- Work thread pool can using all available processors as its target parallelism level
 *     -- In work stealing algorithm, when a processor runs out of work (e.g., computation task, thread, etc.), it looks at the queues of other processors and "steals" their work
 *     -- The queue maintained by a process is usually a dequeue (or deque, double-end queue) so the work inside the queue can be accessed by its own process from one end and "stolen" from the other end to avoid work-taking conflicts
 *        -- However this way may still cause work competition (e.g., only 1 work in the dequeue) and resource consumption (e.g., fork too many processors with dequeues)
 *  -- Suitable for the situation where tasks need to be divided into smaller sub-tasks or executed recursively
 * 	-- When work stealing pool executer executes threads, those threads are run concurrently
 *     -- No matter the threads are executed by "invoke*()", "submit()" or "execute()" through the thread pool executor
 *     -- "execute()": start running threads without waiting for their completion
 *     -- "invoke*()", "submit()": start running threads and wait for their completion if return results need to be processed
 *        -- Otherwise (if no need to process return results in the future) those threads will NOT be waited for
 *        
 * 	@author VinceYuan
 */
object TestWorkStealingPool {
  
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
    val threadPoolExecutor = Executors.newWorkStealingPool()
    
    /*	Start running recursive action	*/
    println("\"threadPoolExecutor.submit(recursiveAction)\"")
    println(s"Original Array:\n${arr1.mkString(", ")}")
    var futureResult = threadPoolExecutor.asInstanceOf[ForkJoinPool].submit(recursiveQuickSortAction)
    
    /*	Wait for the completion of threads and do something after the completion of threads ACCORDING TO THE RETURN RESULTS	 */
    futureResult.get
    println(s"Quick-sorted array:\n${arr1.mkString(", ")}")
    
    /*	Start running recursive action	*/
    println(s"Original Array:\n${arr2.mkString(", ")}")
    futureResult = threadPoolExecutor.asInstanceOf[ForkJoinPool].submit(recursiveHeapSortAction)
    
    /*	Wait for the completion of threads and do something after the completion of threads ACCORDING TO THE RETURN RESULTS	 */
    futureResult.get
    println(s"Heap-sorted array:\n${arr2.mkString(", ")}")
    
    /*	Start running recursive tasks	 */
    println("\"threadPoolExecutor.submit(recursiveTask)\"")
    println(s"Original Array:\n${arr3.mkString(", ")}")
    var futureArray = threadPoolExecutor.asInstanceOf[ForkJoinPool].submit(recursiveQuickSortTask)
    
    /*	Wait for the completion of threads and do something after the completion of threads ACCORDING TO THE RETURN RESULTS	 */
    var sortedArr = futureArray.get
    println(s"Quick-sorted array:\n${sortedArr.mkString(", ")}")
    
    /*	Start running recursive tasks	 */
    println(s"Original Array:\n${arr4.mkString(", ")}")
    futureArray = threadPoolExecutor.asInstanceOf[ForkJoinPool].submit(recursiveMergeSortTask)
    
    /*	Wait for the completion of threads and do something after the completion of threads ACCORDING TO THE RETURN RESULTS	 */
    sortedArr = futureArray.get
    println(s"Merge-sorted array:\n${sortedArr.mkString(", ")}")
    
    /*	Start running threads	 */
    println("\"threadPoolExecutor.invoke*(threads)\":")
    val callableThreads = List(callableCountdownCounter, callableCountupCounter)
    val futureResults = threadPoolExecutor.invokeAll(callableThreads)
    
    /*	Wait for the completion of threads and do something after the completion of threads ACCORDING TO THE RETURN RESULTS		*/
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