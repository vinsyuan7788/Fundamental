package org.lang.scala.conclusion.dandc.common.utils

/**
 * 	This is a stand-alone object to process shutdown hooks CONCURRENTLY
 * 
 * 	@author VinceYuan
 */
object ConcurrentShutdownHookManager {
  
  /*	Instance variables	*/
  private lazy val runtime = Runtime.getRuntime
  
  /**
   * 	This is a method to add shutdown hook into this shutdown hook manager
   */
  def addShutdownHook(hook: Runnable) = {
    runtime.addShutdownHook(hook.asInstanceOf[Thread])
  }
}