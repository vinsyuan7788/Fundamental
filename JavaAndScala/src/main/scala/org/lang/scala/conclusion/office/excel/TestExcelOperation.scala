package org.lang.scala.conclusion.office.excel

import org.lang.scala.conclusion.office.excel.jxl.ExcelOperation

/**
 * 	This is a stand-alone object to test excel operation
 * 
 * 	There are 2 ways for Excel operation in Java
 * 	-- JXL (Java Excel)
 * 	-- Apache POI (Poor Obfuscation Implementation)
 * 
 * 	@author VinceYuan
 */
object TestExcelOperation {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests creating and writing data into an Excel file:")
    testWriteExcelWithJXL()
    println("\nHere tests reading data from an Excel file:")
    testReadExcelWithJXL()
  }
  
  /**
   * 	This is a method to test writing excel with JXL
   */
  private def testWriteExcelWithJXL(): Unit = {
    ExcelOperation.writeDemo()
  }
  
  /**
   * 	This is a method to test reading excel with JXL
   */
  private def testReadExcelWithJXL(): Unit = {
    ExcelOperation.readDemo()
  }
}