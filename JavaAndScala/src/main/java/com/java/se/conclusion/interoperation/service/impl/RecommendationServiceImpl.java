package com.java.se.conclusion.interoperation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.lang.scala.conclusion.interoperation.recommendation.ALSRecommender;
import org.lang.scala.conclusion.interoperation.recommendation.AssociationRecommender;

import com.java.se.conclusion.interoperation.bean.AdPosition;
import com.java.se.conclusion.interoperation.bean.Item;
import com.java.se.conclusion.interoperation.dao.RecommendationDao;
import com.java.se.conclusion.interoperation.dao.impl.RecommendationDaoImpl;
import com.java.se.conclusion.interoperation.recommendation.HotRecommender;
import com.java.se.conclusion.interoperation.recommendation.ItemBasedRecommender;
import com.java.se.conclusion.interoperation.recommendation.UserBasedRecommender;
import com.java.se.conclusion.interoperation.service.RecommendationService;
import com.java.se.conclusion.interoperation.utils.IDMapper;

/**
 * 	This is a class to test interaction between Java and Scala
 * 	-- This class serves as a service interface implementation of a recommender system
 * 
 * @author VinceYuan
 *
 */
public class RecommendationServiceImpl implements RecommendationService {

	/*	Necessary instance variables	*/
	private RecommendationDao recommendationDao = new RecommendationDaoImpl();
	
	@Override
	public List<AdPosition> recommendItems(List<AdPosition> adPositions) {
		
		/*	Get all types of recommendation	 */
		List<Long> recommendedItems = new ArrayList<>();
		recommendedItems.add(getHotRecommendation());
		recommendedItems.add(getItemBasedRecommendation());
		recommendedItems.add(getUserBasedRecommendation());
		recommendedItems.add(getALSRecommendation());
		recommendedItems.add(getAssociationRecommendation());
		
		/*	Filter duplicate recommendation	 */
		List<Long> finalRecommendedItems = new ArrayList<>();
		recommendedItems.stream().distinct().forEach(recommendedItem -> {
			finalRecommendedItems.add(recommendedItem);
		});
		
		/*	Supplement personal recommendation	*/
		finalRecommendedItems.add(6L);
		finalRecommendedItems.add(9L);
		
		/*	Get String-typed IDs from Long-typed IDs	*/
		List<String> idList = new ArrayList<>();
		Map<Long, String> idMap = IDMapper.idMap;
		finalRecommendedItems.forEach(recommendedItem -> {
			idList.add(idMap.get(recommendedItem));
		});
		
		/*	Query items by IDs	*/
		List<Item> items = recommendationDao.queryItemsByIDs(idList);
		
		/*	Set recommendations into advertisement positions	*/
		for (int i = 0; i < adPositions.size(); i++) {
			adPositions.get(i).setItem(items.get(i));
		}
		
		/*	Return advertisement positions	*/
		return adPositions;
	}
	
	/**
	 * 	This is a method to get all hot recommendations and filter those over-recommended items
	 */
	private Long getHotRecommendation() {
		return HotRecommender.recommend().get(0);
	}	
	
	/**
	 * 	This is a method to get all item-based recommendations and filter those over-recommended items
	 */
	private Long getItemBasedRecommendation() {
		return ItemBasedRecommender.recommend().get(0);
	}
	
	/**
	 * 	This is a method to get all user-based recommendations and filter those over-recommended items
	 */
	private Long getUserBasedRecommendation() {
		return UserBasedRecommender.recommend().get(0);
	}
	
	/**
	 * 	This is a method to get all ALS recommendations and filter those over-recommended items
	 */
	private Long getALSRecommendation() {
		return (Long) ALSRecommender.recommend().get(0);
	}
	
	/**
	 * 	This is a method to get all association recommendations and filter those over-recommended items
	 */
	private Long getAssociationRecommendation() {
		return (Long) AssociationRecommender.recommend().get(0);
	}
}
