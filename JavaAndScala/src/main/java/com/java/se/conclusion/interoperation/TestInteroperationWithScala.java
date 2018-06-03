package com.java.se.conclusion.interoperation;

import java.util.List;

import com.java.se.conclusion.interoperation.bean.AdPosition;
import com.java.se.conclusion.interoperation.service.RecommendationService;
import com.java.se.conclusion.interoperation.service.impl.RecommendationServiceImpl;
import com.java.se.conclusion.interoperation.utils.AdPosistionList;

/**
 * 	This is a class to test interoperation with Scala
 *  -- The interoperation with Scala refers to "service/impl/RecommendationServiceImpl.java"
 * 
 * @author VinceYuan
 *
 */
public class TestInteroperationWithScala {

	/*	Necessary instance variables	*/
	private RecommendationService recommendationService = new RecommendationServiceImpl();
	
	/**
	 * 	This is a main method for execution
	 * 
	 * 	@param args
	 */
	public static void main(String[] args) {
		
		/*	Get an instance for testing	 */
		TestInteroperationWithScala test = new TestInteroperationWithScala();
		
		/*	Initialize a list of AdPosition	 */
		List<AdPosition> adPositions = AdPosistionList.adPositionList;
		
		/*	Get recommendations	 */
		adPositions = test.recommendationService.recommendItems(adPositions);
		adPositions.forEach(adPosition -> {
			System.out.println(adPosition.getItem());
		});
	}
}
