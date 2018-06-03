package org.lang.scala.conclusion.office.excel.jxl

import java.io.File

import jxl.Workbook
import jxl.write.Label
import org.lang.scala.common.utils.FileUtils
import org.lang.scala.configuration.Configuration

/**
 * 	This is a stand-alone object to perform operation on office excel by using JXL (Java Excel)
 * 
 * 	@author VinceYuan
 */
object ExcelOperation {
 
  /*	Necessary instance variables	*/
  private val demoFilePath = Configuration.Conclusion.FILE_PATH_TO_TEST_EXCEL_OPERATION
  
  /**
   * 	This is a method to write a demo excel file
   */
  def writeDemo() = {
    
    /*	Create the file path	*/
    FileUtils.createFileIfNotExists(demoFilePath)
    
    /*	Create a demo work-book	*/
    val workBook = Workbook.createWorkbook(new File(demoFilePath))
    
    /*	Create a demo sheet	in the work-book 	*/
    var sheet = workBook.createSheet("demo_sheet_1", 0)
    
    /*	Add data into the demo sheet	*/
    for (row <- 0 until 20; col <- 0 until 10) {
      sheet.addCell(new Label(col, row, s"(${row + 1}, ${col + 1})"))
    }
    
    /*	Create another two demo sheets in the work-book and add data 	*/
    sheet = workBook.createSheet("demo_sheet_3", 1)
    for (row <- 0 until 40; col <- 0 until 30) {
      sheet.addCell(new Label(col, row, s"(${row + 1}, ${col + 1})"))
    }
    sheet = workBook.createSheet("demo_sheet_2", 1)
    for (row <- 0 until 30; col <- 0 until 20) {
      sheet.addCell(new Label(col, row, s"(${row + 1}, ${col + 1})"))
    }
    
    /*	Write the work-book into file system	*/
    workBook.write()
    
    /*	Close the work-book	 */
    workBook.close()
    
    /*	Print a message	 */
    println("Demo excel file has been created and written data successfully...")
  }
  
  /**
   * 	This is a method to read a demo excel file
   */
  def readDemo() = {
  
    /*	Get the demo excel file from file system	*/
    val workBook = Workbook.getWorkbook(new File(demoFilePath))
    
    /*	Get all sheets from the demo excel file	 */
    val sheets = workBook.getSheets
    
    /*	Print all sheets	*/
    var sheetIndex = 0
    sheets.foreach { sheet => {
    
      /*	Print a message	 */
      println(s"Contents in sheet ${sheetIndex + 1}:")
      
      /*	Get the number of rows and columns in current sheet	 */
      val rowNum = sheet.getRows
      val colNum = sheet.getColumns
      
      /*	Print the contents in each cell	 */
      for (row <- 0 until rowNum; col <- 0 until colNum) {
        println(s"Cell (${row + 1}, ${col + 1}): ${sheet.getCell(col, row).getContents}")
      }
      
      /*	Sheet index increments	*/
      sheetIndex += 1
    } }
    
    /*	Close the demo work-book	*/
    workBook.close()
  }
}