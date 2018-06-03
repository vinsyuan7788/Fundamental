package com.java.se.conclusion.interoperation.recommendation;

import java.util.ArrayList;
import java.util.List;

/**
 * 	This is a class to recommend items based on items
 *  -- The recommendation process and results are simulated
 *  -- Practically it can be done by Mahout Machine Learning API, etc.
 * 
 * @author VinceYuan
 *
 */
public class ItemBasedRecommender {

	public static List<Long> recommend() {

		List<Long> itemBasedRecommendedItems = new ArrayList<>();
		itemBasedRecommendedItems.add(5L);
		itemBasedRecommendedItems.add(2L);
		itemBasedRecommendedItems.add(1L);
		return itemBasedRecommendedItems;
	}
}
