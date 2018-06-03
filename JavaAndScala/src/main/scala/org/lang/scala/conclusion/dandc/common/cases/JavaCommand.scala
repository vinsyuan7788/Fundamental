package org.lang.scala.conclusion.dandc.common.cases

import org.lang.scala.conclusion.dandc.common.classes.GenericCommand

/**
 * 	This is a case class to encapsulate Java command
 * 
 * 	@author VinceYuan
 */
case class JavaCommand(

    val javaCmd: String,
    val javaOpt: List[String],
    val jarPath: String,
    val userOpt: List[String]
    
) extends GenericCommand {
  
}