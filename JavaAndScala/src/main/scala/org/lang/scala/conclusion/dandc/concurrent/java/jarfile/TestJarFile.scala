package org.lang.scala.conclusion.dandc.concurrent.java.jarfile

import java.util.jar.JarFile

import scala.collection.JavaConversions.enumerationAsScalaIterator

import org.lang.scala.conclusion.dandc.common.utils.Utils

/**
 * 	This is a stand-alone object to test JarFile class
 * 
 * 	@author VinceYuan
 */
object TestJarFile {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testJarFile()
  }
  
  /**
   * 	This is a method to test JarFile class
   */
  private def testJarFile(): Unit = {
    
    val jarFile = new JarFile(Utils.jarFile)
    println("The files contained in current JAR file:")
    jarFile.entries().foreach { jarEntry => println(jarEntry.getName) }    
  }
}