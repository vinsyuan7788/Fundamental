package org.lang.scala.conclusion.nio.channel.file

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.RandomAccessFile
import java.nio.ByteBuffer

import org.lang.scala.configuration.Configuration

/**
 * 	This is a stand-alone object to test FileChannel
 * 
 * 	@author VinceYuan
 */
object TestFileChannel {
  
  /*	Necessary instance variables	*/
  private val filePath_read = Configuration.Conclusion.FILE_PATH_TO_TEST_FILE_CHANNEL_READ
  private val filePath_write = Configuration.Conclusion.FILE_PATH_TO_TEST_FILE_CHANNEL_WRITE
  private val filePath_copy = Configuration.Conclusion.FILE_PATH_TO_TEST_FILE_CHANNEL_COPY
  private val mode = "rw"
  private var byteArr = Array[Byte]()
  private var charArr = Array[Char]()
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests reading from file channel:")
    testReadFromFileChannel()
    println("\nHere tests writing to file channel:")
    testWriteToFileChannel()
    println("\nHere tests transferring between channels:")
    testTransferringBetweenChannels()
  }
  
  /**
   * 	This is a method to test reading from file channel
   *  -- Original data --- (getChannel) ---> channel --- (read) ---> buffer --- (flip) --- (get) ---> data read
   */
  private def testReadFromFileChannel(): Unit = {
  
    /*	Get a random access file	*/
    val file = new RandomAccessFile(filePath_read, mode)
    
    /*	Get a file channel	*/
    val fileChannel = file.getChannel
    
    /*	Get a byte buffer	 */
    val byteBuffer = ByteBuffer.allocate(48)

    /*	Read from file channel: at this point byte buffer becomes write mode	 */
    var bytesRead = fileChannel.read(byteBuffer)
    
    /*	While there are bytes read	*/
    while (bytesRead != -1) {
      /*	How many bytes read	 */
      println(s"Read: ${bytesRead}")
      /*	Flip byte buffer from write mode to read mode	 */
      byteBuffer.flip()
      /*	While there are elements to read	*/
      while (byteBuffer.hasRemaining()) {
        /*	Read them	 */
        val byteRead = byteBuffer.get
        /*	Save them to arrays	 */
        byteArr = byteArr :+ byteRead
        charArr = charArr :+ byteRead.asInstanceOf[Char]
      }
      /*	Clear the byte buffer	 */
      byteBuffer.clear()
      /*	Read from channel to byte buffer again: at this point byte buffer becomes write mode	*/
      bytesRead = fileChannel.read(byteBuffer)
    }
    
    /*	Close necessary resources	 */
    fileChannel.close()
    file.close()
    
    /*	Print characters read	 */
    println(s"${charArr.mkString("")}")
  }
  
  /**
   * 	This is a method to test writing to file channel
   *  -- Original data --- (put) ---> buffer --- (flip) --- (write) ----> channel ---> data written
   */
  private def testWriteToFileChannel(): Unit = {
    
    /*	Get a random access file	*/
    val file = new RandomAccessFile(filePath_write, mode)
    
    /*	Get a file channel	*/
    val fileChannel = file.getChannel
    
    /*	Get a byte buffer	*/
    val byteBuffer = ByteBuffer.allocate(480)
    
    /*	Clear the buffer: reset position and limit	*/
    byteBuffer.clear()
    
    /*	Put the contents into byte buffer: at this point byte buffer becomes read mode	 */
    byteBuffer.put(byteArr)
    
    /*	Flip the buffer from read mode to write mode	*/
    byteBuffer.flip()
    
    /*	Write to file channel	 */
    while (byteBuffer.hasRemaining()) {
      val bytesWritten = fileChannel.write(byteBuffer)
      println(s"Write: ${bytesWritten}")
    }
    
    /*	Close necessary resources	 */
    fileChannel.close()
    file.close()
  }
  
  /**
   * 	This is a method to test transferring between channels
   */
  private def testTransferringBetweenChannels(): Unit = {
    
    /*	Get the source channel from source file	 */
    val sourceFile = new FileInputStream(filePath_read)
    val sourceChannel = sourceFile.getChannel
    
    /*	Get the target channel form target file	 */
    val targetFile = new FileOutputStream(filePath_copy)
    val targetChannel = targetFile.getChannel
  
    /*	Transfer data between channels	*/
    val position = 0
    val sourceChannelSize = sourceChannel.size()
    sourceChannel.transferTo(position, sourceChannelSize, targetChannel)
    
    /*	Close necessary resources	 */
    sourceFile.close()
    sourceChannel.close()
    targetFile.close()
    targetChannel.close()
  }
}