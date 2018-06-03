package com.java.se.conclusion.oop.callback.common;

import java.util.Map;

/**
 * 	This is a class to be used to test callback
 *  -- This class must have (at least) a method to invoke the callback
 * 
 * @author VinceYuan
 *
 */
public class CallbackTest {

	public static void getMapInfo(Map<String, String> map, Callback callback) {
		callback.callback(map);
	}
}
