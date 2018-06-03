package org.lang.scala.common.utils

import scala.reflect.io.File
import scala.reflect.io.Path

/**
 * 	This is a stand-alone object to implement utility methods regarding byte stream
 * 
 * 	@author VinceYuan
 */
object ByteStreamUtils {
  
  /**
   * 	This is a method to write data to a file
   */
  def writeToFile(filePath: String, data: String) {
    
    /*	Get a file instance	 */
    val file = File(Path(filePath))
    
    /*	Get an output stream	*/
    val outputStream = file.bufferedOutput(false)

    /*	Write bytes to a file	*/
    outputStream.write(data.getBytes)
    
    /*	Close output stream	 */
    outputStream.close() 
  }
  
  /**
   * 	This is a method to append data to a file
   */
  def appendToFile(filePath: String, data: String) = {
    
    /*	Get a file instance	 */
    val file = File(Path(filePath))
    
    /*	Get an output stream	*/
    val outputStream = file.bufferedOutput(true)

    /*	Write bytes to a file	*/
    outputStream.write(data.getBytes)
    
    /*	Close output stream	 */
    outputStream.close() 
  }
  
  /**
   * 	This is a method to read data from a file
   */
  def readFromFile(filePath: String) = {
    
    /*	Get a file instance	 */
    val file = File(Path(filePath))
    
    /*	Initialize a byte array	 */
    var byteArr = Array[Char]()
    
    /*	Get input stream from a file	*/
    val inputStream = file.bufferedInput()

    /*	Read bytes from a file	 */
    var data = inputStream.read()
    while (data != -1) {
      byteArr :+= data.asInstanceOf[Char]
      data = inputStream.read()
    }
    
    /*	Close input stream	 */
    inputStream.close() 
    
    /*	Return the byte array	 */
    byteArr
  }
  
  /**
   * 	This is a method to copy a file
   */
  def copyFile(originalFilePath: String, newFilePath: String) = {
    
    /*	Get file instances	*/
    val originalFile = File(Path(originalFilePath))
    val copyFile = File(Path(newFilePath))
    
    /*	Get an input and an output stream	 */
    val inputStream = originalFile.bufferedInput()
    val outputStream = copyFile.bufferedOutput(false)
    
    /*	Copy bytes from a file to another file	*/
    var data = inputStream.read()
    while (data != -1) {
      outputStream.write(data)
      data = inputStream.read()
    }
    
    /*	Close input and output stream	 */
    inputStream.close()
    outputStream.close()
  }
}