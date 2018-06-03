package org.lang.scala.conclusion.dandc.common.utils

/**
 * 	This is a stand-alone object to process shutdown hooks SEQUENTIALLY
 * 
 * 	@author VinceYuan
 */
object SequentialShutdownHookManager {
  
  /*	Instance variables	*/
  private var hooks = List[Runnable]()
  
  /**
   * 	This is a method to add shutdown hook into this shutdown hook manager
   */
  def addShutdownHook(hook: Runnable) = {
    hooks = hooks :+ hook
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