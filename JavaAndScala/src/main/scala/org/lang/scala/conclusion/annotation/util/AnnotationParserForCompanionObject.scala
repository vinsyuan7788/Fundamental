package org.lang.scala.conclusion.annotation.util

import scala.reflect.runtime.universe._

/**
 * 	This is a stand-alone object to parse annotation for companion object
 * 
 * 	@author VinceYuan
 */
object AnnotationParserForCompanionObject {
  
  /**
   * 	This is a method to parse the annotation on a companion object
   */
  def parse[T : TypeTag] = {
    
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
}