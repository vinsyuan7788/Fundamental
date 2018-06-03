package org.lang.scala.common.utils

import scala.reflect.runtime.universe._
import scala.reflect._

/**
 * 	This is a stand-alone object that contains reflection utility methods
 *  -- Scala reflection may need to be used together with Java reflection
 * 
 * 	@author VinceYuan
 */
object ReflectionUtils {
  
  /*==============	Reflection Utility Methods For Scala Type and Java Class	================*/
  def getScalaType[T : TypeTag] = {
    typeTag[T].tpe
  }
  
  def getScalaType[T : TypeTag](instance: T) = {
    typeTag[T].tpe
  }
  
  def getJavaClassFromScalaType[T : ClassTag] = {
    classTag[T].runtimeClass
  }
  
  def getJavaClassFromScalaType[T : ClassTag](instance: T) = {
    classTag[T].runtimeClass
  }
  
  /*=================	Reflection Utility Methods For Class and Object	===================*/
  /**
   * 	This is a method to get the runtime type of a type
   */
  def getRuntimeType[T : TypeTag] = {
    typeOf[T]
  }
  
  /**
   * 	This is a method to get the runtime type of an instance
   */
  def getRuntimeType[T : TypeTag](instance: T) = {
    typeOf[T]
  }
  
  /**
   * 	This is a method to get declared members of a class
   *  -- Excluding members that are not explicitly declared
   */
  def getDeclaredMembersOfClass[T : TypeTag] = {
    typeOf[T].decls
  }
  
  /**
   * 	This is a method to get declared members of a companion object
   *  -- Excluding members that are not explicitly declared
   */
  def getDeclaredMembersOfCompanionObject[T : TypeTag] = {
    typeOf[T].companion.decls  
  }
  
  /**
   * 	This is a method to get a declared member of a class
   */
  def getDeclaredMemberOfClass[T : TypeTag](memberName: String) = {
    typeOf[T].decl(TermName(memberName))
  }
  
  /**
   * 	This is a method to get a declared member of a companion object
   */
  def getDeclaredMemberOfCompanionObject[T : TypeTag](memberName: String) = {
    typeOf[T].companion.decl(TermName(memberName))
  }
  
  /**
   * 	This is a method to get ALL members of a class
   *  -- Including members that are not explicitly declared
   */
  def getAllMembersOfClass[T : TypeTag] = {
    typeOf[T].members
  }
  
  /**
   * 	This is a method to get ALL members of a companion object
   *  -- Including members that are not explicitly declared
   */
  def getAllMembersOfCompanionObject[T : TypeTag] = {
    typeOf[T].companion.members
  }
  
  /**
   * 	This is a method to get a member of a class
   */
  def getMemberOfClass[T : TypeTag](memberName: String) = {
    typeOf[T].member(TermName(memberName))
  }
  
  /**
   * 	This is a method to get a member of a companion object
   */
  def getMemberOfCompanionObject[T : TypeTag](memberName: String) = {
    typeOf[T].companion.member(TermName(memberName))
  }  
  
  /**
   * 	This is a method to get annotations on a class
   */
  def getAnnotationsOnClass[T : TypeTag] = {
    typeOf[T].typeSymbol.annotations
  }
  
  /**
   * 	This is a method to get annotations on a companion object
   */
  def getAnnotationsOnCompanionObject[T : TypeTag] = {
    typeOf[T].typeSymbol.companion.annotations
  }
  
  /**
   * 	This is a method to get annotations on a member of class
   */
  def getAnnotationsOnMemberOfClass[T: TypeTag](memberName: String) = {
    typeOf[T].decl(TermName(memberName)).annotations
  }
  
  /**
   * 	This is a method to get annotations on a member of class
   */
  def getAnnotationsOnMemberOfCompanionObject[T: TypeTag](memberName: String) = {
    typeOf[T].companion.decl(TermName(memberName)).annotations
  }
  
  /*========================	Reflection Utility Methods For Members	=============================*/
  // Necessary instance variables
  val INT = "scala.Int"
  val CHAR = "scala.Char"
  val STRING = "java.lang.String"
  
  /**
   * 	This is a method to get the Scala type of a declared member of a class
   */
  def getTypeOfDeclaredMemberOfClass[T : TypeTag](memberName: String) = {
    typeOf[T].decl(TermName(memberName)).info.typeSymbol.fullName
  }
  
  /**
   * 	This is a method to get the Scala type of a declared member of a companion object
   */
  def getTypeOfDeclaredMemberOfCompanionObject[T : TypeTag](memberName: String) = {
    typeOf[T].companion.decl(TermName(memberName)).info.typeSymbol.fullName
  }
  
  /*====================	Reflection Utility Methods for Instance	From Class ======================*/
  /**
   * 	This is a method to get an instance from a (stand-alone or companion) class (with parameterless constructor)
   */
  def getInstanceFromClass[T : TypeTag] = {
    runtimeMirror(getClass.getClassLoader)
      .reflectClass(typeOf[T].typeSymbol.asClass)
      .reflectConstructor(typeOf[T].decl(termNames.CONSTRUCTOR).asMethod)()
      .asInstanceOf[T]
  }
  
  /**
   * 	This is a method to get an instance from a (stand-alone or companion) class (with parameterless constructor)
   */
  def getInstanceFromClass[T : TypeTag](fullClassName: String) = {
    val javaUniverseMirror = runtimeMirror(getClass.getClassLoader);
    javaUniverseMirror
      .reflectClass(javaUniverseMirror.staticClass(fullClassName))
      .reflectConstructor(typeOf[T].decl(termNames.CONSTRUCTOR).asMethod)()
      .asInstanceOf[T]
  }
  
  /**
   * 	This is a method to get the value of a field
   */
  def getField[T : TypeTag : ClassTag](instance: T)(fieldName: String) = {
    runtimeMirror(getClass.getClassLoader)
      .reflect(instance)
      .reflectField(typeOf[T].decl(TermName(fieldName)).asTerm)
      .get
  }
  
  /**
   * 	This is a method to set the value of a field
   */
  def setField[T : TypeTag : ClassTag](instance: T)(fieldName: String)(fieldValue: Any) = {
    runtimeMirror(getClass.getClassLoader)
      .reflect(instance)
      .reflectField(typeOf[T].decl(TermName(fieldName)).asTerm)
      .set(fieldValue)
  }
  
  /**
   * 	This is a method to invoke a method
   */
  def invokeMethod[T: TypeTag : ClassTag](instance: T)(methodName: String)(methodArgs: Any*) = {
    runtimeMirror(getClass.getClassLoader)
      .reflect(instance)
      .reflectMethod(typeOf[T].decl(TermName(methodName)).asMethod)
      .apply(methodArgs: _*) 
  }
  
  /*===================	Reflection Utility Methods for Instance	From Object =====================*/
  /**
   * 	This is a method to get an instance from a companion object
   */
  def getInstanceFromCompanionObject[T: TypeTag] = {
    runtimeMirror(getClass.getClassLoader)
      .reflectModule(typeOf[T].typeSymbol.companion.asModule)
      .instance
  }
  
  /**
   * 	This is a method to get an instance from a (stand-alone or companion) object
   */
  def getInstanceFromObejct(fullObjectName: String) = {
    val javaUniverseMirror = runtimeMirror(getClass.getClassLoader);
    javaUniverseMirror
      .reflectModule(javaUniverseMirror.staticModule(fullObjectName))
      .instance
  }
}