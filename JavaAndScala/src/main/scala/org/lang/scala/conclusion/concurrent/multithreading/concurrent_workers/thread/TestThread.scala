package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.thread

import java.util.concurrent.Executors

import scala.collection.JavaConverters.seqAsJavaListConverter

/**
 * 	This is a stand-alone object to test thread
 * 
 * 	There are 2 types of threads: runnable thread and call-able thread
 *  -- One thread can be both runnable and call-able
 *  
 *  There are several states for a thread
 *  -- start: when a thread is started by "thread.start"
 *  -- runnable: after being started by "thread.start" and before being executed by "thread.run"
 *  -- run: when being executed by "thread.run"
 *  -- blocked: wait for the resource or lock release from other threads
 *  -- terminated: a thread is stopped
 *  
 *  To control the sequence during the execution of threads
 *  -- Mostly by "thread.start" and "thread.join"
 *     -- Other control methods are deprecated basically
 * 
 * 	@author VinceYuan
 */
object TestThread {
  
  /*	Necessary instance variables	*/
  private val runnableThread1 = new runnable.LocalNumberAccumulator()
  private val runnableThread2 = new runnable.LocalNumberAccumulator()
  private val runnableThread3 = new runnable.LocalNumberAccumulator()
  private val runnableThread4 = new Thread(new runnable.InstanceNumberReducer())
  private val runnableThread5 = new Thread(new runnable.InstanceNumberReducer())
  private val runnableThread6 = new Thread(new runnable.InstanceNumberReducer())
  private val callableThread1 = new callable.LocalNumberAccumulator()
  private val callableThread2 = new callable.LocalNumberAccumulator()
  private val callableThread3 = new callable.LocalNumberAccumulator()
  private val callableThread4 = new callable.InstanceNumberReducer()
  private val callableThread5 = new callable.InstanceNumberReducer()
  private val callableThread6 = new callable.InstanceNumberReducer()
  
  /**
   * 	This is a main method for execution
   * 	-- To see the test result correctly, make sure there is only 1 method to execute
   */
  def main(args: Array[String]): Unit = {
//    testRunnableThread1()
//    testRunnableThread2()
//    testCallableThread1()
    testCallableThread2()
//    testThreadControl()
  }
  
  /**
   * 	This is a method to test runnable thread
   */
  private def testRunnableThread1(): Unit = {
    
    runnableThread1.start()
    runnableThread2.start()
    runnableThread3.start()
  }
  
  /**
   * 	This is a method to test runnable thread
   */
  private def testRunnableThread2(): Unit = {
    
    runnableThread4.start()
    runnableThread5.start()
    runnableThread6.start()
  }
  
  /**
   * 	This is a method to test call-able thread
   */
  private def testCallableThread1(): Unit = {
    
    val callableThreads = List(callableThread1, callableThread2, callableThread3).asJava
    val threadPool = Executors.newCachedThreadPool()
    threadPool.invokeAll(callableThreads)
    threadPool.shutdown()
  }
  
  /**
   * 	This is a method to test call-able thread
   */
  private def testCallableThread2(): Unit = {
    
    val callableThreads = List(callableThread4, callableThread5, callableThread6).asJava
    val threadPool = Executors.newCachedThreadPool()
    threadPool.invokeAll(callableThreads)
    threadPool.shutdown()
  }
  
  /**
   * 	This is a method to test thread control
   */
  private def testThreadControl(): Unit = {
    
    /*	Start thread 1 and wait for its completion	*/
    runnableThread1.start()
    runnableThread1.join()
    
    /*	Start thread 2 and wait for its completion	*/
    runnableThread2.start()
    runnableThread2.join()
    
    /*	Start thread 3	*/
    runnableThread3.start()
  }
}