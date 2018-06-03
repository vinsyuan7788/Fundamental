package org.lang.scala.conclusion.jvm.runtime.shutdownhook

import org.lang.scala.conclusion.jvm.runtime.common.thread.CountdownCounter
import org.lang.scala.conclusion.jvm.runtime.common.thread.CountupCounter
import org.lang.scala.conclusion.jvm.runtime.common.utils.SequentialShutdownHookManager

/**
 * 	This is a stand-alone object to test shutdown hook with wrapper and utility classes
 *  -- The SequentialShutdownManager here will run the hooks according to the order in which the hooks are added
 *     -- E.g., here adds CountdownCounter then CountupCounter, hence run CountdownCounter first then CountupCounter when the JVM is shutting down
 * 
 * 	@author VinceYuan
 */
object TestSequentialShutdownHook {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testSequentialShutdownHookWithWrapperAndUtil()
  }
  
  /**
   * 	This is a method to test shutdown hook with wrapper and utility classes
   *  -- To clearly check the effect, just execute this method for a couple of times
   */
  private def testSequentialShutdownHookWithWrapperAndUtil(): Unit = {
    SequentialShutdownHookManager.addShutdownHook(new CountdownCounter())
    SequentialShutdownHookManager.addShutdownHook(new CountupCounter())
  }
}