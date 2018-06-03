package org.lang.scala.conclusion.jvm.runtime.shutdownhook

import org.lang.scala.conclusion.jvm.runtime.common.thread.CountdownCounter
import org.lang.scala.conclusion.jvm.runtime.common.thread.CountupCounter
import org.lang.scala.conclusion.jvm.runtime.common.utils.ConcurrentShutdownHookManager

/**
 * 	This is a stand-alone object to test shutdown hook with wrapper and utility classes
 *  -- The ConcurrentShutdownManager here will run the hooks concurrently regardless of the order in which the hooks are added
 *  
 * 	@author VinceYuan
 */
object TestConcurrentShutdownHook {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testConcurrentShutdownHookWithWrapperAndUtil()
  }
  
  /**
   * 	This is a method to test shutdown hook with wrapper and utility classes
   *  -- To clearly check the effect, just execute this method for a couple of times
   */
  private def testConcurrentShutdownHookWithWrapperAndUtil(): Unit = {
    ConcurrentShutdownHookManager.addShutdownHook(new CountdownCounter())
    ConcurrentShutdownHookManager.addShutdownHook(new CountupCounter())
  }
}