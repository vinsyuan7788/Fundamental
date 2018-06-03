package org.lang.scala.common.test

import java.util.Date
import java.util.UUID

import org.lang.scala.common.utils.SerDeUtils

/**
 * 	This is a stand-alone object to test SerDeUtils
 * 
 * 	@author VinceYuan
 */
object TestSerDeUtils {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testSerDeUtils()
  }
  
  /**
   * 	This is a method to test SerDeUtils
   */
  private def testSerDeUtils(): Unit = {
    
    val vince = Person(UUID.randomUUID().toString(), "Vince", 27, new Date())
    println(s"Original instance:\n${vince}")
    
    val instanceBytes = SerDeUtils.toByteArray(vince)
    println(s"To bytes:\n${instanceBytes}")
    
    val person = SerDeUtils.toInstance[Person](instanceBytes)
    println(s"Back to instance:\n${person}")
  }
}

/**
 * 	This is a case class for testing
 */
case class Person(
    
    id: String,
    name: String,
    age: Int,
    birthDate: Date
    
) extends Serializable {
  
}