package org.lang.scala.conclusion.dandc.concurrent.java.runtime.shutdownhook

import org.lang.scala.conclusion.dandc.common.classes.thread.runnable.CountdownCounter
import org.lang.scala.conclusion.dandc.common.classes.thread.runnable.CountupCounter

/**
 * 	This is a stand-alone object to test shutdown hook
 *  -- All the threads that are added into shutdown hook will be run CONCURRENTLY (regardless of the order in which these threads (or hooks) are added) when the JVM is shutting down
 *  -- To understand it metaphorically, a hook can hook multiple wires at its end. These added threads are those wires
 * 	-- During concurrent or distributed development, Runtime.getRuntime is usually not exposed directly to outside, hence need to wrapper it up using a class
 *     -- Application example: Spark, Hadoop, etc.
 *     -- Can refer to other scala files under current packages for better understanding
 * 
 * 	@author VinceYuan
 */
object TestShutdownHook {
  
  /*	Necessary instance variables	*/
  final val runtime = Runtime.getRuntime
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testShutdownHook()
  }
  
  /**
   * 	This is a method to test shutdown hooks
   *  -- To clearly check the effect, just execute this method for a couple of times
   */
  private def testShutdownHook(): Unit = {  
    runtime.addShutdownHook(new CountdownCounter())
    runtime.addShutdownHook(new CountupCounter())
  }
}