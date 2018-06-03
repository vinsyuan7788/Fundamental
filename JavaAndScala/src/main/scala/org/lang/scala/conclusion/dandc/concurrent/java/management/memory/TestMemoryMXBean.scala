package org.lang.scala.conclusion.dandc.concurrent.java.management.memory

import java.lang.management.ManagementFactory

/**
 * 	This is a stand-alone object to test MemoryMXBean
 *  -- This class can access the information of memory of the platform that is running current JVM
 *  -- This information includes but not limited to:
 *     -- Heap memory usage, non-heap memory usage, etc.
 *     
 * 	@author VinceYuan
 */
object TestMemoryMXBean {
  
  /*	Necessary instance variables	*/
  private val memoryMXBean = ManagementFactory.getMemoryMXBean
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testHeapMemoryUsage()
    testNonHeapMemoryUsage()
  }
  
  /**
   * 	This is a method to test heap memory usage
   */
  private def testHeapMemoryUsage(): Unit = {
    
    /*	Get heap memory usage	 */
    val heapMemUsage = memoryMXBean.getHeapMemoryUsage
    
    /*	Access the information of heap memory	 */
    val heapMemInit = heapMemUsage.getInit
    val heapMemCommitted = heapMemUsage.getCommitted      // Most cared
    val heapMemUsed = heapMemUsage.getUsed                // Most cared
    val heapMemMax = heapMemUsage.getMax
    val ifHeapMemMaxGuaranteedAvailable = if (heapMemMax > heapMemCommitted) false else true
    println(s"The heap memory JVM initially requests from the operating system for memory management: ${toBytes(heapMemInit)} bytes (${toMB(heapMemInit)} MB)")
    println(s"*The heap memory committed and guaranteed for the Java virtual machine to use: ${heapMemCommitted} bytes (${toMB(heapMemCommitted)} MB)")
    println(s"*The heap memory currently used by JVM: ${heapMemUsed} bytes (${toMB(heapMemUsed)} MB)")
    println(s"The heap maximum memory that can be used for memory management: ${toBytes(heapMemMax)} bytes (${toMB(heapMemMax)} MB)")
    println(s"If heapMemMax is guaranteed to be available for memory management? ${ifHeapMemMaxGuaranteedAvailable}")
  }
  
  /**
   * 	This is a method to test non-heap memory usage
   */
  private def testNonHeapMemoryUsage(): Unit = {
    
    /*	Get Non-heap memory usage	 */
    val nonHeapMemUsage = memoryMXBean.getNonHeapMemoryUsage
    
    /*	Access the information of non-heap memory	 */
    val nonHeapMemInit = nonHeapMemUsage.getInit
    val nonHeapMemCommitted = nonHeapMemUsage.getCommitted
    val nonHeapMemUsed = nonHeapMemUsage.getUsed
    val nonHeapMemMax = nonHeapMemUsage.getMax
    val ifnonHeapMemMaxGuaranteedAvailable = if (nonHeapMemMax > nonHeapMemCommitted) false else true
    println(s"\nThe non-heap memory JVM initially requests from the operating system for memory management: ${toBytes(nonHeapMemInit)} bytes (${toMB(nonHeapMemInit)} MB)")
    println(s"The non-heap memory committed and guaranteed for the Java virtual machine to use: ${nonHeapMemCommitted} bytes (${toMB(nonHeapMemCommitted)} MB)")
    println(s"The non-heap memory currently used by JVM: ${nonHeapMemUsed} bytes (${toMB(nonHeapMemUsed)} MB)")
    println(s"The non-heap maximum memory that can be used for memory management: ${toBytes(nonHeapMemMax)} bytes (${toMB(nonHeapMemMax)} MB)")
    println(s"If nonHeapMemMax is guaranteed to be available for memory management? ${ifnonHeapMemMaxGuaranteedAvailable}")
  }
  
  /**
   * 	Here are the methodS for conversion to bytes and MB
   */
  private def toBytes(bytesInLong: Long) = if (bytesInLong != -1) bytesInLong else "undefined"
  private def toMB(bytesInLong: Long) = if (bytesInLong != -1) (bytesInLong / 1024d / 1024d).formatted("%.2f") else "undefined"
    
}