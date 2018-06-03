package org.lang.scala.conclusion.reflection.annotation

import scala.annotation.StaticAnnotation

/**
 * 	This is an annotation to test reflection
 * 
 * 	@author VinceYuan
 */
case class GetObjectName(bool: Boolean, defaultName: String) extends StaticAnnotation {
  
}