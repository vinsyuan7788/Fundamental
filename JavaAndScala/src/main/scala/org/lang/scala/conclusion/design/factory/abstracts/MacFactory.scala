package org.lang.scala.conclusion.design.factory.abstracts

import org.lang.scala.conclusion.design.factory.abstracts.common.MacBorder
import org.lang.scala.conclusion.design.factory.abstracts.common.MacButton

/**
 * 	This is a stand-alone class to implement abstract factory pattern
 *  -- This class must implement a parent trait
 *  
 * 	@author VinceYuan
 */
class MacFactory extends BrandFactory {
  	
	override def getButton() = new MacButton()
	override def getBorder() = new MacBorder()
}