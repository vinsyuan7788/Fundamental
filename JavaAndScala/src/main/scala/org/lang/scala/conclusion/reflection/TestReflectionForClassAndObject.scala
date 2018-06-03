package org.lang.scala.conclusion.reflection

import scala.reflect.runtime.universe._

import org.lang.scala.common.utils.ReflectionUtils
import org.lang.scala.conclusion.reflection.bean.Person

/**
 * 	This is a stand-alone object to test reflection for class and object
 *  -- It includes getting members and annotations of class or object
 * 
 * 	@author VinceYuan
 */
object TestReflectionForClassAndObject {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testReflectionForType()
  }
  
  /**
   * 	This is a method to test reflection for type
   */
  private def testReflectionForType(): Unit = {
    
    println("Using reflection to get runtime type:")
    val personType = ReflectionUtils.getRuntimeType[Person]
    println(personType)
    
    println("\nUsing reflection to get declared members of a class:")
    val personDeclMembersOfClass = ReflectionUtils.getDeclaredMembersOfClass[Person]
    println(personDeclMembersOfClass)
    
    println("\nUsing reflection to get declared members of a companion object:")
    val personDeclMembersOfCompanionObject = ReflectionUtils.getDeclaredMembersOfCompanionObject[Person]
    println(personDeclMembersOfCompanionObject)
    
    println("\nUsing reflection to get a declared member of a class:")
    val personDeclMemberOfClass = ReflectionUtils.getDeclaredMemberOfClass[Person]("name")
    println(personDeclMemberOfClass)
    
    println("\nUsing reflection to get a declared member of a companion object:")
    val personDeclMemberOfCompanionObject = ReflectionUtils.getDeclaredMemberOfCompanionObject[Person]("location")
    println(personDeclMemberOfCompanionObject)
    
    println("\nUsing reflection to get all members of a class:")
    val personAllMembersOfClass = ReflectionUtils.getAllMembersOfClass[Person]
    println(personAllMembersOfClass)
    
    println("\nUsing reflection to get all members of a companion object:")
    val personAllMembersOfCompanionObject = ReflectionUtils.getAllMembersOfCompanionObject[Person]
    println(personAllMembersOfCompanionObject)
    
    println("\nUsing reflection to get a member of a class:")
    val personMemberOfClass = ReflectionUtils.getMemberOfClass[Person]("race")
    println(personMemberOfClass)
    
    println("\nUsing reflection to get a member of a companion object:")
    val personMemberOfCompanionObject = ReflectionUtils.getMemberOfCompanionObject[Person]("race")
    println(personMemberOfCompanionObject)
    
    println("\nUsing reflection to get annotations on a class:")
    val presonClassAnnotations = ReflectionUtils.getAnnotationsOnClass[Person]
    println(presonClassAnnotations)
    
    println("\nUsing reflection to get annotations on a companion object:")
    val presonObjAnnotations = ReflectionUtils.getAnnotationsOnCompanionObject[Person]
    println(presonObjAnnotations)
    
    println("\nUsing reflection to get annotations on fields of a class:")
    val idAnnotationsOfClass = ReflectionUtils.getAnnotationsOnMemberOfClass[Person]("id")
    val nameAnnotationsOfClass = ReflectionUtils.getAnnotationsOnMemberOfClass[Person]("name")
    val ageAnnotationsOfClass = ReflectionUtils.getAnnotationsOnMemberOfClass[Person]("age")
    val genderAnnotationsOfClass = ReflectionUtils.getAnnotationsOnMemberOfClass[Person]("gender")
    println(idAnnotationsOfClass)
    println(nameAnnotationsOfClass)
    println(ageAnnotationsOfClass)
    println(genderAnnotationsOfClass)
    
    println("\nUsing reflection to get annotations on fields of a companion object:")
    val idAnnotationsOfCompanionObject = ReflectionUtils.getAnnotationsOnMemberOfCompanionObject[Person]("id")
    val nameAnnotationsOfCompanionObject = ReflectionUtils.getAnnotationsOnMemberOfCompanionObject[Person]("name")
    val ageAnnotationsOfCompanionObject = ReflectionUtils.getAnnotationsOnMemberOfCompanionObject[Person]("age")
    val genderAnnotationsOfCompanionObject = ReflectionUtils.getAnnotationsOnMemberOfCompanionObject[Person]("gender")
    println(idAnnotationsOfCompanionObject)
    println(nameAnnotationsOfCompanionObject)
    println(ageAnnotationsOfCompanionObject)
    println(genderAnnotationsOfCompanionObject)
    
    println("\nUsing reflection to get annotations on methods of a class:")
    val liveAnnotationsOfClass = ReflectionUtils.getAnnotationsOnMemberOfClass[Person]("live")
    val studyAnnotationsOfClass = ReflectionUtils.getAnnotationsOnMemberOfClass[Person]("study")
    val toStringAnnotationsOfClass = ReflectionUtils.getAnnotationsOnMemberOfClass[Person]("toString")
    println(liveAnnotationsOfClass)
    println(studyAnnotationsOfClass)
    println(toStringAnnotationsOfClass)
    
    println("\nUsing reflection to get annotations on methods of a companion object:")
    val liveAnnotationsOfCompanionObject = ReflectionUtils.getAnnotationsOnMemberOfCompanionObject[Person]("live")
    val studyAnnotationsOfCompanionObject = ReflectionUtils.getAnnotationsOnMemberOfCompanionObject[Person]("study")
    val toStringAnnotationsOfCompanionObject = ReflectionUtils.getAnnotationsOnMemberOfCompanionObject[Person]("toString")
    println(liveAnnotationsOfCompanionObject)
    println(studyAnnotationsOfCompanionObject)
    println(toStringAnnotationsOfCompanionObject)
  }
}