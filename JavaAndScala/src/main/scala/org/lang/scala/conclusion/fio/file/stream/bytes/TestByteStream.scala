package org.lang.scala.conclusion.fio.file.stream.bytes

import scala.reflect.io.File
import scala.reflect.io.Path
import org.lang.scala.configuration.Configuration

/**
 * 	This is a stand-alone object to test byte stream
 * 
 * 	@author VinceYuan
 */
object TestByteStream {
  
  /*	Necessary instance variables	*/
  private val filePathForByteStream = Configuration.Conclusion.FILE_PATH_TO_TEST_BYTE_STREAM
  private val filePathForByteStream_copy = Configuration.Conclusion.FILE_PATH_TO_TEST_BYTE_STREAM_COPY
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testWriteBytesToFile()
    testAppendBytesToFile()
    testReadBytesFromFile()
    testCopyBytes()    
  }
  
  /**
   * 	This is a method to write bytes to a file
   */
  private def testWriteBytesToFile() = {
    
    /*	Get a file instance	 */
    val file = File(Path(filePathForByteStream))

    /*	Initialize a line	 */
    val line = "大家好大家好，哇哈哈哈哈哈哈 Howdy Hello~~~\t\r"
    
    /*	Get an output stream	*/
    val outputStream = file.bufferedOutput(false)

    /*	Write bytes to a file	*/
    outputStream.write(line.getBytes)
    
    /*	Close output stream	 */
    outputStream.close()    
        
    /*	Print a message	 */
    println("Writing bytes to a file successfully...")
  }
  
  /**
   * 	This is a method to append bytes to a file
   */
  private def testAppendBytesToFile() = {

    /*	Get a file instance	 */
    val file = File(Path(filePathForByteStream))
    
    /*	Initialize a line	 */
    val line = "大家好大家好，哇哈哈哈哈哈哈 Howdy Hello~~~\t\r"
    
    /*	Get an output stream	*/
    val outputStream = file.bufferedOutput(true)
    
    /*	Write bytes to a file	*/
    outputStream.write(line.getBytes)
    
    /*	Close output stream	 */
    outputStream.close()   
    
    /*	Print a message	 */
    println("Appending bytes to a file successfully...")
  }
  
  /**
   * 	This is a method to read bytes from a file
   */
  private def testReadBytesFromFile() = {
    
    /*	Get a file instance	 */
    val file = File(Path(filePathForByteStream))
    
    /*	Get input stream from a file	*/
    val inputStream = file.bufferedInput()

    /*	Read bytes from a file	 */
    var data = inputStream.read()
    while (data != -1) {
      print(data.asInstanceOf[Char])
      data = inputStream.read()
    }
    
    /*	Close input stream	 */
    inputStream.close()   
    
    /*	Print a message	 */
    println("Reading bytes from a file successfully...")
  }
  
  /**
   * 	This is a method to copy a file of bytes
   */
  private def testCopyBytes() = {
    
    /*	Get file instances	*/
    val originalFile = File(Path(filePathForByteStream))
    val copyFile = File(Path(filePathForByteStream_copy))
    
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
    
    /*	Print a message	 */
    println("Copying a file of bytes successfully...")
  }
}