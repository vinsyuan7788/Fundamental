package org.lang.scala.conclusion.thread

/**
 * 	This is a stand-alone object to test Runnable
 * 
 * 	@author VinceYuan
 */
object TestRunnable {
  
  /*	Necessary instance variables	*/
  val runnable = new Runnable() {
    val threadId = Thread.currentThread().getId
    override def run(): Unit = {
      for (i <- 0 until 10) {
        println(s"Thread ID: ${threadId}; Count: ${i}")
      }
    }
  }
  // All threads use the same logic to run
  val thread1 = new Thread(runnable)
  val thread2 = new Thread(runnable)
  val thread3 = new Thread(runnable)
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    thread1.start()
    thread2.start()
    thread3.start()
    thread1.join()
    thread2.join()
    thread3.join()
  }
}