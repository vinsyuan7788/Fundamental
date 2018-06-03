package org.lang.scala.conclusion.annotation.util

import scala.reflect.runtime.universe._

/**
 * 	This is a stand-alone object to parse annotation for a member of class
 * 
 * 	@author VinceYuan
 */
object AnnotationParserForMemberOfClass {
  
  /**
   * 	This is a method to parse the annotation on a class
   */
  def parse[T : TypeTag](memberName: String) = {
    
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
}