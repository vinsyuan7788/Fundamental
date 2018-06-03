package org.lang.scala.conclusion.dandc.common.cases

import org.lang.scala.conclusion.dandc.common.classes.GenericCommand

/**
 * 	This is a case class to encapsulate OS command
 * 
 * 	@author VinceYuan
 */
case class OSCommand(

    val osCmd: String,
    val osOpt: List[String]
    
) extends GenericCommand {
  
}