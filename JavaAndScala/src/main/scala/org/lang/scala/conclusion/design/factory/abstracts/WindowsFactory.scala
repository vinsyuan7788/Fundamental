package org.lang.scala.conclusion.design.factory.abstracts

import org.lang.scala.conclusion.design.factory.abstracts.common.WindowsBorder
import org.lang.scala.conclusion.design.factory.abstracts.common.WindowsButton

/**
 * 	This is a stand-alone class to implement abstract factory pattern
 *  -- This class must implement a parent trait
 *  
 * 	@author VinceYuan
 */
class WindowsFactory extends BrandFactory {
  	
	override def getButton() = new WindowsButton()
	override def getBorder() = new WindowsBorder()
}