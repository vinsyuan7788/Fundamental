package org.lang.scala.conclusion.jvm.management.os

import java.lang.management.ManagementFactory

/**
 * 	This is a stand-alone object to test OperatingSystemMXBean
 *  -- This class can access the information of operating system of the platform that is running current JVM
 *  -- The information includes but not limited to:
 *     -- Available processors, system load average for the last minute, OS name, OS version, OS architecture, etc.
 * 
 * 	@author VinceYuan
 */
object TestOperatingSystemMXBean {
  
  /*	Necessary instance variables	*/
  private val operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testOperatingSystemMXBean()
  }
  
  /**
   * 	This is a method to test OperatingSystemMXBean
   */
  private def testOperatingSystemMXBean(): Unit = {
    
    /*	Get available processors	*/
    val availableProcessors = operatingSystemMXBean.getAvailableProcessors      // Mostly cared
    println(s"*Available processors to current JVM: ${availableProcessors}")
    println(s"""*If above is the same as \"Runtime.getRuntime.availableProcessors\"? ${availableProcessors == Runtime.getRuntime.availableProcessors()} """)
    
    /*
     * 	Get the hint of system load average for the last minute
     *  -- System load average: (the number of runnable entities queued to + running on the availableProcessors) / a period of time
     */
    val systemLoadAverage = operatingSystemMXBean.getSystemLoadAverage
    println(s"\nThe system average load for the last minute: ${isAvailable(systemLoadAverage)}")
    
    /*	Get the name, version and architecture of the OS that is running current JVM	*/
    val osName = operatingSystemMXBean.getName
    val osVersion = operatingSystemMXBean.getVersion
    val osArchitecture = operatingSystemMXBean.getArch
    println(s"\nOS name: ${osName}")
    println(s"""If above is the same as \"System.getProperty("os.name")\"? ${osName == System.getProperty("os.name")}""")
    println(s"\nOS version: ${osVersion}")
    println(s"""If above is the same as \"System.getProperty("os.version")\"? ${osVersion == System.getProperty("os.version")}""")
    println(s"\nOS architecture: ${osArchitecture}")
    println(s"""If above is the same as \"System.getProperty("os.arch")\"? ${osArchitecture == System.getProperty("os.arch")}""")
  }
  
  /**
   * 	Here are the methods to predicate if the value represent an available value 
   */
  private def isAvailable(systemLoadAverage: Double) = if (systemLoadAverage != -1) systemLoadAverage else "unavailable"
}