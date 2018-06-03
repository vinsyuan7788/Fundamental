package org.lang.scala.common.utils

/**
 *	This is a stand-alone object to provide utility methods for thread
 * 
 * 	@author VinceYuan
 */
object ThreadUtils {
  
  /**
   * 	This is a method to get thread information
   */
  def getThreadInfo(thread: Thread) = {
    
    /*	Here are the thread information to get	*/
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