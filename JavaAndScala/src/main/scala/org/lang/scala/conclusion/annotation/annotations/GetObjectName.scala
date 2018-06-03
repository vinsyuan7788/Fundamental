package org.lang.scala.conclusion.annotation.annotations

import scala.annotation.StaticAnnotation

/**
 * 	This is an annotation to test annotation
 * 
 * 	@author VinceYuan
 */
case class GetObjectName(bool: Boolean, defaultName: String) extends StaticAnnotation {
  
}