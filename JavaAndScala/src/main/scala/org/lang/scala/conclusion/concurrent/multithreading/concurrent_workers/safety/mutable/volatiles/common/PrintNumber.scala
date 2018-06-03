package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.volatiles.common

/**
 * 	This is a stand-alone class to test "volatile" keyword
 * 
 * 	@author VinceYuan
 */
class PrintNumber(

    private val numberManager: NumberManager

) extends Thread {
  
  /**
   * 	This is a method to specify what this thread needs to run
   */
  override def run() = {
    Thread.sleep(10)
    printNumber()
  }
  
  /**
   * 	This is a method to print the numbers
   */
  private def printNumber() = {
    numberManager.print()
  }
}