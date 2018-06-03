package com.java.se.conclusion.interoperation.recommendation;

import java.util.ArrayList;
import java.util.List;

/**
 * 	This is a class to recommend hot items
 *  -- The recommendation process and results are simulated
 *  -- Practically it can be done by collecting and analyzing data warehousing through Hive, etc.
 * 
 * @author VinceYuan
 *
 */
public class HotRecommender {

	public static List<Long> recommend() {

		List<Long> hotItems = new ArrayList<>();
		hotItems.add(3L);
		hotItems.add(6L);
		hotItems.add(1L);
		return hotItems;
	}
}
