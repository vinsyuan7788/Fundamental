package org.lang.scala.conclusion.properties

import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.FileReader
import java.io.FileWriter
import java.util.Properties

import scala.collection.JavaConversions.asScalaSet

import org.lang.scala.common.utils.FileUtils
import org.lang.scala.configuration.Configuration

/**
 * 	This is a stand-alone object to test Properties class
 * 	-- Properties is a sub-class of Map: since it implements "hashTable"
 *     -- Hence it is unordered when creating property file
 *  
 *  Exemplary application scenario:
 *  -- Store (create) property file for configuration
 *  -- Load (read) property file for configuration
 *  
 *  @author VinceYuan
 */
object TestProperties {
  
  /*	Instance variables	*/
  val filePath_Properties_ENG = Configuration.Conclusion.FILE_PATH_TO_TEST_PROPERTIES_ENG
  val filePath_Properties_CHN = Configuration.Conclusion.FILE_PATH_TO_TEST_PROPERTIES_CHN
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
		println("Here tests basics of properties:")
		testBasicsOfProperties()
		println("\nHere tests storing properties:")
		testStorePropertyFile()
		println("\nHere tests loading properties:")
		testLoadPropertyFile()
  }
  
  /**
   * 	This is a method to test the basics of Properties
   */
  private def testBasicsOfProperties(): Unit = {
    
		/*	Instantiate a Properties object & set necessary properties	*/
		val properties = new Properties()
		properties.setProperty("host", "gmail.com")
		properties.setProperty("username", "456")
		properties.setProperty("password", "uio")
		
		/*	Get the properties	*/
		println("The properties:")
		println(properties.getProperty("host"))
		println(properties.getProperty("username"))
		println(properties.getProperty("password"))
		println()
		
		/*	Traverse the properties through entry set	 */
		val entrySet = properties.entrySet()
		println("The entry set:")
		entrySet.foreach(entry => {
		  println(s"${entry.getKey}: ${entry.getValue}")
		})
		println()
		
		/*	Traverse the properties through property names	*/
		val propertyNames = properties.stringPropertyNames()
		println("The entry set:")
		propertyNames.foreach { propName => {
		  println(s"${propName}: ${properties.getProperty(propName)}")
		} }
  }
  
  /**
   * 	This is a method to store properties into a file
   */
  private def testStorePropertyFile(): Unit = {
    
	  val properties_eng = new Properties()
		properties_eng.setProperty("host", "gmail.com")
		properties_eng.setProperty("username", "456")
		properties_eng.setProperty("password", "uio")
		val properties_chn = new Properties()
		properties_chn.setProperty("host", "gmail.com")
		properties_chn.setProperty("username", "456")
		properties_chn.setProperty("password", "uio")
		properties_chn.setProperty("地点", "旧金山")
			
		/*	Create 2 files to store the properties if the file does not exist	*/
		val filePaths_Properties = List(filePath_Properties_ENG, filePath_Properties_CHN)
		filePaths_Properties.foreach { filePath => {
		  FileUtils.createFileIfNotExists(filePath)
		} }
			
		/*	Store properties into the files	 */
		properties_eng.store(new BufferedOutputStream(new FileOutputStream(filePath_Properties_ENG)), "This is the testing property file")
		properties_chn.store(new BufferedWriter(new FileWriter(filePath_Properties_CHN)), "This is the testing property file")
  }
  
  /**
   * 	This is a method to load properties file
   */
  private def testLoadPropertyFile(): Unit = {
    
		/*	Instantiate Properties objects & load necessary property files	*/
		val properties_eng = new Properties()
		properties_eng.load(new BufferedInputStream(new FileInputStream(filePath_Properties_ENG)))
		val properties_chn = new Properties()
		properties_chn.load(new BufferedReader(new FileReader(filePath_Properties_CHN)))
		
		/*	See the result	*/
		println("The properties_eng:")
		println(properties_eng.getProperty("host"))
		println(properties_eng.getProperty("username"))
		println(properties_eng.getProperty("password"))
		println("\nThe properties_chn:")
		println(properties_chn.getProperty("host"))
		println(properties_chn.getProperty("username"))
		println(properties_chn.getProperty("password"))
		println(properties_chn.getProperty("地点"))
  }
}