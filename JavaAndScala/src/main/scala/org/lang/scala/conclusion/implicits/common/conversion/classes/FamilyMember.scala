package org.lang.scala.conclusion.implicits.common.conversion.classes

/**
 * 	This is a stand-alone class to test polymorphism of implicit conversion
 * 
 * 	@author VinceYuan
 */
class FamilyMember[T <: FamilyMemberInfo](val instance: T) {
  
  def getFamilyMemberInfo() = {
    println(s"FamilyMember[id=${instance.id}, name=${instance.name}, age=${instance.age}]")
  }
}