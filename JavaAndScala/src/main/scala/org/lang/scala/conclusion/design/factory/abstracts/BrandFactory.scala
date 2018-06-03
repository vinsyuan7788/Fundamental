package org.lang.scala.conclusion.design.factory.abstracts

import org.lang.scala.conclusion.design.factory.abstracts.common.Border
import org.lang.scala.conclusion.design.factory.abstracts.common.Button

/**
 * 	This is a trait to implement abstract factory pattern
 *  -- This trait must be implemented by its child classes
 *  
 * 	@author VinceYuan
 */
trait BrandFactory {
  
  def getButton(): Button
  def getBorder(): Border
}