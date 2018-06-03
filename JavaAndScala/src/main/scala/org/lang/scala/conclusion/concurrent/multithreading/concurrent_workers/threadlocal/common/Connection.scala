package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.threadlocal.common

/**
 * 	This is a class to simulate a JDBC connection
 * 
 * 	@author VinceYuan
 */
class Connection(

    /*	Instance variables	*/
    val tid: Long

) {
  
  /**
   * 	For readability
   */
  override def toString() = {
    s"Connection[tid=${tid}]"
  }
}