package com.java.se.conclusion.design.factory.method;

/**
 * 	This is an interface to be used to implement factory method pattern
 *  -- This interface must be implemented by its child classes
 *  
 * @author VinceYuan
 *
 */
public interface ConfigurationFactory {

	public Object getInstance(String configFileName);
}
