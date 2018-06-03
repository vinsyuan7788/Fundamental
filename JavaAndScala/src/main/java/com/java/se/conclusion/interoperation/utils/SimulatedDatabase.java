package com.java.se.conclusion.interoperation.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.se.conclusion.interoperation.bean.Item;
import com.java.se.conclusion.interoperation.enumeration.Color;
import com.java.se.conclusion.interoperation.enumeration.Price;

/**
 * 	This is a class to generate a list of items
 *  -- Assuming there are only 9 kinds of products in this item
 * 
 * @author VinceYuan
 *
 */
public class SimulatedDatabase {

	/*	Necessary instance variables	*/
	public static Map<String, Item> items = new HashMap<>();
	
	/*	Static block for initialization	 */
	static {
		List<String> idList = IDList.idList;
		items.put(idList.get(0), new Item(idList.get(0), "item1", Color.green, Price.high));
		items.put(idList.get(1), new Item(idList.get(1), "item2", Color.green, Price.median));
		items.put(idList.get(2), new Item(idList.get(2), "item3", Color.green, Price.low));
		items.put(idList.get(3), new Item(idList.get(3), "item4", Color.yellow, Price.high));
		items.put(idList.get(4), new Item(idList.get(4), "item5", Color.yellow, Price.median));
		items.put(idList.get(5), new Item(idList.get(5), "item6", Color.yellow, Price.low));
		items.put(idList.get(6), new Item(idList.get(6), "item7", Color.red, Price.high));
		items.put(idList.get(7), new Item(idList.get(7), "item8", Color.red, Price.median));
		items.put(idList.get(8), new Item(idList.get(8), "item9", Color.red, Price.low));
	}
}
