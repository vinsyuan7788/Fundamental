package org.lang.scala.conclusion.thread

/**
 * 	This is a method to test thread
 * 
 * 	@author VinceYuan
 */
object TestThread {
  
  /*	Necessary instance variables	*/
  val thread1 = new Thread() {
    val threadId = getId
    override def run(): Unit = {
      for (i <- 0 until 10) {
        println(s"ID: ${threadId}; Count: ${i}")
      } 
    }
  }
  val thread2 = new Thread() {
    val threadId = getId
    override def run(): Unit = {
      for (i <- 0 until 10) {
        println(s"ID: ${threadId}; Count: ${i}")
      } 
    }
  }
  val thread3 = new Thread() {
    val threadId = getId
    override def run(): Unit = {
      for (i <- 0 until 10) {
        println(s"ID: ${threadId}; Count: ${i}")
      } 
    }
  }
  
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