package org.lang.scala.conclusion.jvm.runtime.common.utils

import scala.collection.mutable.ListBuffer

/**
 * 	This is a stand-alone object to process shutdown hooks SEQUENTIALLY
 * 
 * 	@author VinceYuan
 */
object SequentialShutdownHookManager {
  
  /*	Instance variables	*/
  private val hooks = ListBuffer[Runnable]()
  
  /**
   * 	This is a method to add shutdown hook into this shutdown hook manager
   */
  def addShutdownHook(hook: Runnable) = {
    hooks += hook
  }
  
  /**
   * 	Get the runtime of current JVM and add a shutdown hook
   *  -- This shutdown hook will run other shutdown hooks that are added into the "hooks" list (sequentially)
   */
  Runtime.getRuntime.addShutdownHook(new Thread() {
    override def run(): Unit = {
      hooks.foreach { hook => hook.run() }
    }
  })
}