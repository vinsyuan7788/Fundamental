package com.java.se.conclusion.interoperation.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 	This is a class to get a list of String-typed UUIDs
 * 
 * @author VinceYuan
 *
 */
public class IDList {

	/*	Necessary instance variables	 */
	public static List<String> idList = new ArrayList<>();
	
	/*	Static block for initialization	 */
	static {
		idList.add(UUID.randomUUID().toString());
		idList.add(UUID.randomUUID().toString());
		idList.add(UUID.randomUUID().toString());
		idList.add(UUID.randomUUID().toString());
		idList.add(UUID.randomUUID().toString());
		idList.add(UUID.randomUUID().toString());
		idList.add(UUID.randomUUID().toString());
		idList.add(UUID.randomUUID().toString());
		idList.add(UUID.randomUUID().toString());
	}
}
