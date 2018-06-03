package com.java.se.conclusion.interoperation.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.java.se.conclusion.interoperation.bean.Item;
import com.java.se.conclusion.interoperation.dao.RecommendationDao;
import com.java.se.conclusion.interoperation.utils.SimulatedDatabase;

/**
 * 	This is a class to test interaction between Java and Scala
 * 	-- This class serves as a DAO interface implementation of a recommender system
 * 
 * @author VinceYuan
 *
 */
public class RecommendationDaoImpl implements RecommendationDao {

	/*	Necessary instance variables	*/
	private Map<String, Item> items = SimulatedDatabase.items;
	
	/**
	 * 	This is a method to query items by IDs
	 */
	@Override
	public List<Item> queryItemsByIDs(List<String> idList) {
		
		/*	Create a list to store items	*/
		List<Item> items = new ArrayList<>();
		
		/*	Query items from simulated database	 */
		idList.forEach(id -> {
			items.add(this.items.get(id));
		});
		
		/*	Return the list of items	*/
		return items;
	}
}
