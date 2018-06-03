package com.java.se.conclusion.interoperation.recommendation;

import java.util.ArrayList;
import java.util.List;

/**
 * 	This is a class to recommend items based on users
 *  -- The recommendation process and results are simulated
 *  -- Practically it can be done by Mahout Machine Learning API, etc.
 * 
 * @author VinceYuan
 *
 */
public class UserBasedRecommender {

	public static List<Long> recommend() {

		List<Long> userBasedRecommendedItems = new ArrayList<>();
		userBasedRecommendedItems.add(5L);
		userBasedRecommendedItems.add(3L);
		userBasedRecommendedItems.add(1L);
		return userBasedRecommendedItems;
	}
}
