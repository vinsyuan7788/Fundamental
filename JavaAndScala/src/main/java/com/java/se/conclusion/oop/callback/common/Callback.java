package com.java.se.conclusion.oop.callback.common;

import java.util.Map;

/**
 * 	This is an interface to be used to test callback
 * '-- This interface is a functional interface
 * 
 * @author VinceYuan
 *
 */
@FunctionalInterface
public interface Callback {

	public void callback(Map<String, String> map);
}
