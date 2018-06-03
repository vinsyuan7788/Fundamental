package org.lang.scala.conclusion.design.factory.singleton.objects

/**
 * 	This is a stand-alone object to implement singleton factory pattern
 * 	-- With object, there is actually no need to implement this pattern in Scala solely
 *  -- But from engineering perspective, for the compatibility with Java, it maybe still necessary to implement this pattern
 *  
 *  @author VinceYuan
 */
object Professor {
  
  /**
   * 	For readability
   */
  override def toString() = {
    s"This is a professor instance"
  }
}