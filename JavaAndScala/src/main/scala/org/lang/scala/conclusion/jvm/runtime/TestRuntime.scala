package org.lang.scala.conclusion.jvm.runtime

import java.util.concurrent.TimeUnit

import org.lang.scala.conclusion.jvm.runtime.common.utils.JVMResources

/**
 * 	This is a stand-alone object to test Runtime
 * 
 * 	@author VinceYuan
 */
object TestRuntime {
  
  /*	Necessary instance variables	*/
  private val runtime = Runtime.getRuntime
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests retrieving the JVM resources:")
    testGetJVMResouceInfo()
    println("\nHere tests requesting GC (Garbage Collection):")
    testRequestGC()
    println("\nHere tests executing commands in a separate process:")
    testExecutingCommands()
  }
  
  /**
   * 	This is a method to get information of JVM resources
   */
  private def testGetJVMResouceInfo(): Unit = {
    
    /*	Get available processors, total memory, free memory, max memory	of the JVM	*/
    val availableProcessorsToJVM = runtime.availableProcessors()
    val totalMemoryInJVM = runtime.totalMemory()
    val freeMemoryInJVM = runtime.freeMemory()
    val maxMemoryAttemptToUseByJVM = runtime.maxMemory()
    
    /*	Put these resource info into a map	 */
    var jvmResourceInfo = Map[JVMResources.Value, Long]()
    jvmResourceInfo += (JVMResources.AVAILABLE_PROCESSORS -> availableProcessorsToJVM)
    jvmResourceInfo += (JVMResources.TOTAL_MEMORY -> totalMemoryInJVM)
    jvmResourceInfo += (JVMResources.FREE_MEMORY -> freeMemoryInJVM)
    jvmResourceInfo += (JVMResources.MAX_MEMORY -> maxMemoryAttemptToUseByJVM)
    println(s"JVM Resouce infomration:\n${jvmResourceInfo.mkString("\n")}")
  }

  /**
   * 	This is a method to test request GC (Garbage Collection)
   *  -- Even GC is explicitly requested, GC will still be performed automatically as needed, NOT as requested 
   */
  private def testRequestGC(): Unit = {
  
    var freeMem1 = 0l
    var freeMem2 = 0l       
    val arr = new Array[Any](100000)   
    freeMem1 = runtime.totalMemory()
    println(s"Initially, free memory is ${freeMem1}")
    
    for (idx <- 0 until arr.size) {
      arr(idx) = idx
    }
    freeMem2 = runtime.freeMemory()
    println(s"After allocation, free memory is ${freeMem2}")
    println(s"Hence memory used for allocation is ${freeMem1 - freeMem2}")
    
    runtime.gc()
    freeMem1 = runtime.freeMemory()
    println(s"After requesting GC, free memory is ${freeMem1}")
    println(s"Hence the memory released by GC is ${freeMem1 - freeMem2}")
  }
  
  /**
   * 	This is a method to execute commands
   *  -- This way is not as elegant as processBuilder.start() to create a process, since
   *     -- ProcessBuilder provides more information and functionality regarding the process that is going to be created
   *     -- This API is more shell-oriented while ProcessBuilder is more JVM-oriented
   */
  private def testExecutingCommands(): Unit = {
    
    /*	Initialization of commands	*/
    val commandArr = Array("notepad")
    
    /*	Execute commands with runtime	 */
    val process = runtime.exec(commandArr)
    println("Process started. Now wait for 5 seconds...")
    process.waitFor(5, TimeUnit.SECONDS)
    process.destroy()
    println("Process destroyed successfully.")
  }
}