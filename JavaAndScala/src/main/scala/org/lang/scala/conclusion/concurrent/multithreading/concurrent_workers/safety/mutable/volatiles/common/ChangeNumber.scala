package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.volatiles.common

/**
 * 	This is a stand-alone class to test "volatile" keyword
 * 
 * 	@author VinceYuan
 */
class ChangeNumber(

    private val numberManager: NumberManager

) extends Thread {
  
  /**
   * 	This is a method to specify what this thread needs to run
   */
  override def run() = {
    Thread.sleep(10)
    changeNumber()
  }
  
  /**
   * 	This is a method to change the numbers
   */
  private def changeNumber() = {
    numberManager.change()
  }
}