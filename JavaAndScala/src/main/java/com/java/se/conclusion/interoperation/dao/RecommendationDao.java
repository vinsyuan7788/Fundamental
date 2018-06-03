package com.java.se.conclusion.interoperation.dao;

import java.util.List;

import com.java.se.conclusion.interoperation.bean.Item;

/**
 * 	This is an interface to test interaction between Java and Scala
 * 	-- This interface serves as a DAO interface of a recommender system
 * 
 * @author VinceYuan
 *
 */
public interface RecommendationDao {

	List<Item> queryItemsByIDs(List<String> idList);
}
