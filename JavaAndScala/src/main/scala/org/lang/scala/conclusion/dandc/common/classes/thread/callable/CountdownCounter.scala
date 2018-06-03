package org.lang.scala.conclusion.dandc.common.classes.thread.callable

import java.util.concurrent.Callable

/**
 * 	This is a stand-alone class to act as a call-able (task) to count down
 * 
 * 	@author VinceYuan
 */
class CountdownCounter extends Callable[Boolean] {

  override def call(): Boolean = {
    
    val currentThread = Thread.currentThread()
    currentThread.setName("Countdown")
    
    try {
      for (count <- 10 to 1 by -1) {
        println(s"${currentThread.getName}: ${count}")
      }
      true
    } catch {
      case t: Throwable => false
    }
  }
}