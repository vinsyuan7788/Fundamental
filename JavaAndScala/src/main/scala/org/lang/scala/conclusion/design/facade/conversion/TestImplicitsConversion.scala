package org.lang.scala.conclusion.design.facade.conversion

import java.util.UUID

import org.lang.scala.conclusion.design.facade.conversion.classes.Developer
import org.lang.scala.conclusion.design.facade.conversion.classes.Teacher
import org.lang.scala.conclusion.design.facade.facade.CustomPredef.developer2ScalaDeveloper
import org.lang.scala.conclusion.design.facade.facade.CustomPredef.teacher2Professor

/**
 * 	This is a stand-alone object to test facade pattern on implicit conversions
 * 
 * 	@author VinceYuan
 */
object TestFacadeOnImplicitConversions {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testFacadeOnImplicitConversions()
  }
  
  /**
   * 	This is a method to test facade on implicit conversions
   */
  private def testFacadeOnImplicitConversions(): Unit = {
    
    val teacher = new Teacher()
    teacher.id = UUID.randomUUID().toString()
    teacher.name = "Vince"
    teacher.gender = 'M'
    println(teacher.getInfo())
    val developer = new Developer()
    developer.id = UUID.randomUUID().toString()
    developer.name = "Vince"
    developer.gender = 'M'
    println(developer.getInfo())
  }
}