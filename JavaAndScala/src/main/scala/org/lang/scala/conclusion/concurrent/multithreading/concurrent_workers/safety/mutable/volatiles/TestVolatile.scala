package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.volatiles

import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.volatiles.common.ChangeNumber
import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.volatiles.common.ChangeNumberJava
import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.volatiles.common.NumberManager
import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.volatiles.common.NumberManagerJava
import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.volatiles.common.PrintNumber
import org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.volatiles.common.PrintNumberJava

/**
 * 	This is a stand-alone object to test "volatile" keyword for thread-safety
 * 	-- "volatile" ensures:
 *     -- When getting value of variable modified by "volatile", it must be loaded from JVM main memory to working memory of a thread instance
 *     -- If the value of variable modified by "volatile" is changed during the accessing of threads, the new value will be written to JVM main memory
 * 
 * 	@author VinceYuan
 */
object TestVolatile {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
//    testVolatile()
    testVolatileJava()
  }
  
  /**
   * 	This is a method to test "volatile" keyword (in Scala)
   * `-- The correct results in this case are (1, 2) or (3, 3)
   *  -- However without "volatile" keyword, result (1, 3) may appear occasionally, which is not desirable
   */
  private def testVolatile(): Unit = {
    
    /*	Initialization of shared resources and threads	*/
    val numberManager = new NumberManager()
    
    /*	Start threads	 */
    for (i <- 0 until 20) {
      new PrintNumber(numberManager).start()
      new ChangeNumber(numberManager).start()
    }
  }
  
  /**
   * 	This is a method to test "volatile" keyword in Java
   * `-- The correct results in this case are (1, 2) or (3, 3)
   *  -- However without "volatile" keyword, result (1, 3) may appear occasionally, which is not desirable
   */
  private def testVolatileJava(): Unit = {
  
    /*	Initialization of shared resources and threads	*/
    val numberManager = new NumberManagerJava()
    
    /*	Start threads	 */
    for (i <- 0 until 20) {
      new PrintNumberJava(numberManager).start()
      new ChangeNumberJava(numberManager).start()
    }
  }
}