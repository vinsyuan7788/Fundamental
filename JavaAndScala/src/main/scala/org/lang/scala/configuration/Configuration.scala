package org.lang.scala.configuration

/**
 * 	This is a stand-alone object that stores the configuration for Scala conclusion
 * 
 * 	@author vinsy
 */
object Configuration {
  
  /*	Necessary instance variables	*/
	private val FILE_PATH_PREFIX = System.getProperty("user.dir") + "/Test/"
	
	/***************************************	For Common	******************************************/
	object Common {
	  
	  val FILE_PATH_TO_TEST_BYTE_STREAM_UTILS = FILE_PATH_PREFIX + "ScalaTest/FIO/byte/hello.txt"
  	val FILE_PATH_TO_TEST_BYTE_STREAM_UTILS_COPY = FILE_PATH_PREFIX + "ScalaTest_Copy/FIO/byte/hello.txt"
  	
  	val FILE_PATH_TO_TEST_CHARACTER_STREAM_UTILS = FILE_PATH_PREFIX + "ScalaTest/FIO/character/hello.txt"
  	val FILE_PATH_TO_TEST_CHARACTER_STREAM_UTILS_COPY = FILE_PATH_PREFIX + "ScalaTest_Copy/FIO/character/hello.txt"
  	
  	val FILE_PATH_TO_TEST_FILE_UTILS = FILE_PATH_PREFIX + "ScalaTest/NIO/Channel/FileChannel/test_copy.txt"
	}
	
  /*************************************	For Conclusion	****************************************/
	object Conclusion {
	 
    /*	For distributed and concurrent	*/
	  val FILE_PATH_FOR_JAR_FILE = FILE_PATH_PREFIX + "ScalaTest/Concurrent/generateRandomIntegers.jar"
	  val FILE_PATH_FOR_OUTPUT = FILE_PATH_PREFIX + "ScalaTest/Concurrent/testProgramOutput.txt"
	  
	  /*	For design	*/
	  val FILE_PATH_TO_TEST_DECORATOR = FILE_PATH_PREFIX + "ScalaTest/DesignPattern/Decorator/Hello.txt"
	  val FILE_PATH_TO_TEST_INHERITANCE = FILE_PATH_PREFIX + "ScalaTest/DesignPattern/Inheritance/Hello.txt"
	  
	  /*	For FIO	 */
	  val FILE_PATH_TO_TEST_BYTE_STREAM = FILE_PATH_PREFIX + "ScalaTest/FIO/byte/hello.txt"
	  val FILE_PATH_TO_TEST_BYTE_STREAM_COPY = FILE_PATH_PREFIX + "ScalaTest_Copy/FIO/byte/hello.txt"
	  
	  val FILE_PATH_TO_TEST_CHARACTER_STREAM = FILE_PATH_PREFIX + "ScalaTest/FIO/character/hello.txt"
	  val FILE_PATH_TO_TEST_CHARACTER_STREAM_COPY = FILE_PATH_PREFIX + "ScalaTest_Copy/FIO/character/hello.txt"
	  
	  val FILE_PATH_TO_TEST_FILE = FILE_PATH_PREFIX + "ScalaTest/FIO/file/test.txt";
	  
	  val FILE_PATH_TO_TEST_SOURCE = FILE_PATH_PREFIX + "ScalaTest/FIO/hello.txt"
	  
	  /*	For NIO	 */
	  val FILE_PATH_TO_TEST_BYTE_BUFFER_READ = FILE_PATH_PREFIX + "ScalaTest/NIO/Buffer/ByteBuffer/test_read.txt"
	  val FILE_PATH_TO_TEST_BYTE_BUFFER_WRITTEN = FILE_PATH_PREFIX + "ScalaTest/NIO/Buffer/ByteBuffer/test_written.txt"
	  
	  val FILE_PATH_TO_TEST_FILE_CHANNEL_READ = FILE_PATH_PREFIX + "ScalaTest/NIO/Channel/FileChannel/test_read.txt"
	  val FILE_PATH_TO_TEST_FILE_CHANNEL_WRITE = FILE_PATH_PREFIX + "ScalaTest/NIO/Channel/FileChannel/test_write.txt"
	  val FILE_PATH_TO_TEST_FILE_CHANNEL_COPY = FILE_PATH_PREFIX + "ScalaTest/NIO/Channel/FileChannel/test_copy.txt"
	  
	  /*	For office	*/
	  val FILE_PATH_TO_TEST_EXCEL_OPERATION = FILE_PATH_PREFIX + "ScalaTest/Office/Excel/test.xls"
	  
	  /*	For properties	*/
	  val FILE_PATH_TO_TEST_PROPERTIES_ENG = FILE_PATH_PREFIX + "ScalaTest/Properties/test_eng.properties"
	  val FILE_PATH_TO_TEST_PROPERTIES_CHN = FILE_PATH_PREFIX + "ScalaTest/Properties/test_chn.properties"
	}
}