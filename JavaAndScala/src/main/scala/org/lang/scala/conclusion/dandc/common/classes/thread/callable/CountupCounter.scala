package org.lang.scala.conclusion.dandc.common.classes.thread.callable

import java.util.concurrent.Callable

/**
 * 	This is a stand-alone class to act as a call-able (task) to count up
 * 
 * 	@author VinceYuan
 */
class CountupCounter extends Callable[Boolean] {
  
  override def call(): Boolean = {
    
    val currentThread = Thread.currentThread()
    currentThread.setName("Countup")
    
    try {
      for (count <- 1 to 10) {
        println(s"${currentThread.getName}: ${count}")
      }      
      true
    } catch {
      case t: Throwable => false
    }
  }
}