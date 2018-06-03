package org.lang.scala.conclusion.annotation

import scala.reflect.runtime.universe

import org.lang.scala.conclusion.annotation.annotations.GetClassName
import org.lang.scala.conclusion.annotation.annotations.IsSingleton
import org.lang.scala.conclusion.annotation.bean.Person
import org.lang.scala.conclusion.annotation.util.AnnotationParserForClass
import org.lang.scala.conclusion.annotation.util.AnnotationParserForCompanionObject
import org.lang.scala.conclusion.annotation.util.AnnotationParserForMemberOfClass
import org.lang.scala.conclusion.annotation.util.AnnotationParserForMemberOfCompanionObject

/**
 * 	This is a stand-alone object to test annotation
 * 
 * 	To declare an annotation in Scala:
 *  -- Declare a case class that extends "[scala.annotation.]StaticAnnotation"
 *  
 * 	There are 2 types of annotation:
 * 	-- Static annotation: 
 *     -- The annotation that is visible at runtime in Scala
 *     -- This type of annotation can be accessed via Scala reflection API
 *  -- Class-file annotation: 
 *     -- The annotation that is invisible at runtime in Scala
 *     -- To access this type of annotation with reflection API at runtime, MUST write them in Java and access them with Java reflection API
 *     
 *  Annotation is organized in a tree structure, as of version 2.11.8 & 2.12.1
 *  -- The tree structure of annotation as a root can be obtained by: annotataion.tree
 *  -- The children (or node) information can be obtained as a List by: annnotation.tree.children
 *  -- In the "annnotation.tree.children" List:
 *     -- First element is regarding the annotation (name) representation: annnotation.tree.children.head
 *     -- The rest of elements are the value of each parameter in the annotation: annotation.tree.children.tail
 *        -- Once get values of annotation parameters, can do the corresponding processing
 *     
 *  Note that reflection regarding annotation is usable, but still marked as experimental and not mature enough, as of version 2.11.8 & 2.12.1
 *  -- More details refer to "http://docs.scala-lang.org/overviews/reflection/annotations-names-scopes.html"
 *  
 *	@author VinceYuan
 */
object TestAnnotation {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testAnnotation()
  }
  
  /**
   * 	This is a method to test annotation
   */
  private def testAnnotation(): Unit = {
    
    /*	Annotation parser for class	 */
    println("Here is annotation parser for class:")
    AnnotationParserForClass.parse[Person]
    
    /*	Annotation parser for companion object	*/
    println("\nHere is annotation parser for companion object:")
    AnnotationParserForCompanionObject.parse[Person]
    
    /*	Annotation parser for a member of class	 */
    println("\nHere is annotation parser for a member of class:")
    AnnotationParserForMemberOfClass.parse[Person]("live")
    AnnotationParserForMemberOfClass.parse[Person]("study")
    AnnotationParserForMemberOfClass.parse[Person]("toString")
    
    /*	Annotation parser for a member of companion object	*/
    println("\nHere is annotation parser for a member of companion object:")
    AnnotationParserForMemberOfCompanionObject.parse[Person]("live")
    AnnotationParserForMemberOfCompanionObject.parse[Person]("study")
    AnnotationParserForMemberOfCompanionObject.parse[Person]("toString")
  }
}