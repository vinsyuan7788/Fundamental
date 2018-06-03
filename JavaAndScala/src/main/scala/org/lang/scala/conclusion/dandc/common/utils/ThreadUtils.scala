package org.lang.scala.conclusion.dandc.common.utils

import java.util.concurrent.Executors
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.ThreadPoolExecutor

/**
 * 	This is a stand-alone object that contains Thread utility methods
 * 
 * 	@author VinceYuan
 */
object ThreadUtils {
  
  /**
   * 	This is a method to new (or create) a cached thread pool
   */
  def newCachedThreadPool() = {
    Executors.newCachedThreadPool().asInstanceOf[ThreadPoolExecutor]
  }
  
  /**
   * 	This is a method to new (or create) a fixed thread pool
   */
  def newFixedThreadPool(numOfThreads: Int) = {
    Executors.newFixedThreadPool(numOfThreads).asInstanceOf[ThreadPoolExecutor]
  }
  
  /**
   * 	This is a method to new (or create) a scheduled thread pool
   */
  def newScheduledThreadPool(numOfThreads: Int) = {
    Executors.newScheduledThreadPool(numOfThreads).asInstanceOf[ScheduledThreadPoolExecutor]
  }
  
  /**
   * 	This is a method to new (or create) a single thread executor
   */
  def newSingleThreadExecutor() = {
    Executors.newSingleThreadExecutor()
  }

  /**
   * 	This is a method to new (or create) a single thread scheduled executor
   */
  def newSingleThreadScheduledExecutor() = {
    Executors.newSingleThreadScheduledExecutor()
  }
  
  /**
   * 	This is a method to new (or create) a work stealing pool
   */
  def newWorkStealingPool() = {
    Executors.newWorkStealingPool().asInstanceOf[ForkJoinPool]
  }
  
  /**
   * 	This is a method to start running a thread
   */
  def start(thread: Thread) = thread.start()
  
  /**
   * 	This is a method to get all information regarding a specific thread and put them into a Map for return
   */
  def getThreadInfo(thread: Thread) = {
    
    var threadInfo = Map[String, Any]()
    threadInfo += ("Thread ID" -> thread.getId)
    threadInfo += ("Thread Name" -> thread.getName)
    threadInfo += ("Thread State" -> thread.getState)
    threadInfo += ("Thread Priority" -> thread.getPriority)
    threadInfo += ("Thread Group" -> thread.getThreadGroup.getName)
    threadInfo += ("If Thread Is Alive" -> thread.isAlive())
    threadInfo += ("If Thread Is Daemon" -> thread.isDaemon())
    threadInfo += ("If Thread Is Interrupted" -> thread.isInterrupted())
    threadInfo
  }
}