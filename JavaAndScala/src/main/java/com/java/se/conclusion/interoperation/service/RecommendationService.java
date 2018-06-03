package com.java.se.conclusion.interoperation.service;

import java.util.List;

import com.java.se.conclusion.interoperation.bean.AdPosition;

/**
 * 	This is an interface to test interaction between Java and Scala
 * 	-- This interface serves as a service interface of a recommender system
 * 
 * @author VinceYuan
 *
 */
public interface RecommendationService {

	public List<AdPosition> recommendItems(List<AdPosition> adPositions);
}
