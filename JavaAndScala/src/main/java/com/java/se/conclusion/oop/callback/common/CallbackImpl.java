package com.java.se.conclusion.oop.callback.common;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 	This is a class to be used to test callback
 *  -- This class must inherit its parent interface (to implement the "callback()" method)
 *  
 * @author VinceYuan
 *
 */
public class CallbackImpl implements Callback {

	@Override
	public void callback(Map<String, String> map) {
		for (Iterator<Entry<String, String>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
