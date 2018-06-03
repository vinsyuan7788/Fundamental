package org.lang.scala.conclusion.reflection

import scala.reflect.runtime.universe._

import org.lang.scala.conclusion.reflection.annotation.GetClassName
import org.lang.scala.conclusion.reflection.annotation.IsSingleton
import org.lang.scala.conclusion.reflection.bean.Person

/**
 * 	This is a stand-alone object to test reflection for annotation
 *  -- It includes parsing annotations
 * 	-- Details regarding annotation refer to "annotation/TestAnnotation.scala" and relevant Scala files
 * 
 * 	@author VinceYuan
 */
object TestReflectionForAnnotation {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testReflectionForAnnotation()
  }
  
  /**
   * 	This is a method to test reflection for annotation
   */
  private def testReflectionForAnnotation() = {
  
    /*	Using reflection to parse annotation for class	*/
    println("Using reflection to parse annotation for class:")
    annotationParserForClass[Person]
    
    /*	Using reflection to parse annotation for companion object	 */
    println("\nUsing reflection to parse annotation for companion object:")
    annotationParserForCompanionObject[Person]
    
    /*	Using reflection to parse annotation for method	 */
    println("\nUsing reflection to parse annotation for method of class:")
    annotationParserForMemberOfClass[Person]("live")
    annotationParserForMemberOfClass[Person]("study")
    annotationParserForMemberOfClass[Person]("toString")
    
    /*	Using reflection to parse annotation for method	 */
    println("\nUsing reflection to parse annotation for method of companion object:")
    annotationParserForMemberOfCompanionObject[Person]("live")
    annotationParserForMemberOfCompanionObject[Person]("study")
    annotationParserForMemberOfCompanionObject[Person]("toString")
  }
  
  /**
   * 	This is an annotation parser for class
   */
  def annotationParserForClass[T : TypeTag] = {
    
    /*	For each annotation on a specific class	 */
    typeOf[T].typeSymbol.annotations.foreach { 
      annotation => {
        
        /*	Get the annotation name and annotation (constructor) parameters	 */
        val annotationNameRepresentation = annotation.tree.children.head.toString()
        val annotationName = annotationNameRepresentation.substring(annotationNameRepresentation.lastIndexOf('.') + 1)
        val annotationParameterValues = annotation.tree.children.tail
        
        /*	Match the annotationName to different cases	*/
        annotationName match {
          
          /*	If annotationName is "GetClassName"	 */
          case "GetClassName" => {
            val bool = annotationParameterValues(0).toString().toBoolean
            bool match {
              case true => println("Class name: " + typeOf[T].typeSymbol.name)
              case false => {}
            }
            val defaultName = annotationParameterValues(1).toString()
            defaultName match {
              case "null" => {}
              case anyOtherName => println("Default name: " + anyOtherName)
            }
          }
          
          /*	If annotationName is "IsSingleton"	*/
          case "IsSingleton" => {
            val bool = annotationParameterValues(0).toString().toBoolean
            bool match {
              case true => println("This is a singleton class")
              case false => println("This is a multiton class")
            }
          }
          
          /*	If annotationName is another one	*/
          // case ....
        }
      } 
    }
  }
  
  /**
   * 	This is an annotation parser for companion object
   */
  def annotationParserForCompanionObject[T : TypeTag] = {
    
    /*	For each annotation on a specific companion object	*/
    typeOf[T].typeSymbol.companion.annotations.foreach { 
      annotation => {
        
        /*	Get the annotation name and annotation (constructor) parameters	 */
        val annotationNameRepresentation = annotation.tree.children.head.toString()
        val annotationName = annotationNameRepresentation.substring(annotationNameRepresentation.lastIndexOf('.') + 1)
        val annotationParameterValues = annotation.tree.children.tail
        
        /*	Match the annotationName to different cases	*/
        annotationName match {
          
          /*	If annotationName is "GetClassName"	 */
          case "GetObjectName" => {
            val bool = annotationParameterValues(0).toString().toBoolean
            bool match {
              case true => println("Object name: " + typeOf[T].typeSymbol.companion.name)
              case false => {}
            }
            val defaultName = annotationParameterValues(1).toString()
            defaultName match {
              case "null" => {}
              case anyOtherName => println("Default name: " + anyOtherName)
            }
          }
          
          /*	If annotationName is "IsSingleton"	*/
          case "IsSingleton" => {
            val bool = annotationParameterValues(0).toString().toBoolean
            bool match {
              case true => println("This is a singleton class")
              case false => println("This is a multiton class")
            }
          }
          
          /*	If annotationName is another one	*/
          // case ....
        }
      } 
    }    
  }
  
  /**
   * 	This is an annotation parser for member of class
   */
  def annotationParserForMemberOfClass[T : TypeTag](memberName: String) = {
    
    /*	For each annotation on a specific member of a specific class	*/
    typeOf[T].decl(TermName(memberName)).annotations.foreach { 
      annotation => {

        /*	Get the annotation name and annotation (constructor) parameters	 */
        val annotationNameRepresentation = annotation.tree.children.head.toString()
        val annotationName = annotationNameRepresentation.substring(annotationNameRepresentation.lastIndexOf('.') + 1)
        val annotationParameterValues = annotation.tree.children.tail
        
        /*	Match the annotationName to different cases	*/
        annotationName match {
          
          /*	If annotationName is "GetMethodName"	 */
          case "GetMethodName" => {
            val bool = annotationParameterValues(0).toString().toBoolean
            bool match {
              case true => println("Method name: " + typeOf[T].decl(TermName(memberName)).name)
              case false => {}
            }
          }
          
          /*	If annotationName is another one	*/
          // case ....
        }
      } 
    }
  }
  
  /**
   * 	This is an annotation parser for member of companion object
   */
  def annotationParserForMemberOfCompanionObject[T : TypeTag](memberName: String) = {
    
    /*	For each annotation on a specific member of a specific companion object  */
    typeOf[T].companion.decl(TermName(memberName)).annotations.foreach { 
      annotation => {

        /*	Get the annotation name and annotation (constructor) parameters	 */
        val annotationNameRepresentation = annotation.tree.children.head.toString()
        val annotationName = annotationNameRepresentation.substring(annotationNameRepresentation.lastIndexOf('.') + 1)
        val annotationParameterValues = annotation.tree.children.tail
        
        /*	Match the annotationName to different cases	*/
        annotationName match {
          
          /*	If annotationName is "GetMethodName"	 */
          case "GetMethodName" => {
            val bool = annotationParameterValues(0).toString().toBoolean
            bool match {
              case true => println("Method name: " + typeOf[T].companion.decl(TermName(memberName)).name)
              case false => {}
            }
          }
          
          /*	If annotationName is another one	*/
          // case ....
        }
      } 
    }
  }
}