package org.lang.scala.conclusion.interoperation

import scala.collection.JavaConversions.asScalaBuffer

import com.java.se.conclusion.interoperation.service.impl.RecommendationServiceImpl
import com.java.se.conclusion.interoperation.utils.AdPosistionList

/**
 * 	This is a stand-alone object to test interoperation with Java
 * 
 * 	@author VinceYuan
 */
object TestInteroperationWithJava {
  
  /*	Necessary instance variables	*/
  private val recommendationService = new RecommendationServiceImpl()
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {  

    /*	Initialize a list of AdPosition	 */
    var adPositions = AdPosistionList.adPositionList
    
    /*	Get recommendations	 */
    adPositions = recommendationService.recommendItems(adPositions)
    adPositions.foreach { adPosition => {
      println(adPosition.getItem)
    } }
  }
}