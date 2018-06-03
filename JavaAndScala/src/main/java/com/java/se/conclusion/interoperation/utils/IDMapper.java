package com.java.se.conclusion.interoperation.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 	This is a class to store the mapping between Long-typed IDs and String-typed IDs
 * 	-- From implementation perspective, can also use a list to store Long-typed IDs
 *     -- In this case, can sort the list and use binary-search (or other searching algorithms, etc.) to search String-typed IDs by Long-typed IDs
 * 
 * @author VinceYuan
 *
 */
public class IDMapper {

	/*	Necessary instance variables	*/
	public static Map<Long, String> idMap = new HashMap<>();
	
	/*	Static block for initialization	 */
	static {
		List<String> idList = IDList.idList;
		idMap.put(1l, idList.get(0));
		idMap.put(2l, idList.get(1));
		idMap.put(3l, idList.get(2));
		idMap.put(4l, idList.get(3));
		idMap.put(5l, idList.get(4));
		idMap.put(6l, idList.get(5));
		idMap.put(7l, idList.get(6));
		idMap.put(8l, idList.get(7));
		idMap.put(9l, idList.get(8));
	}
}
