package com.java.se.conclusion.reflection.common.advice;

/**
 * 	This is an interface to implement dynamic proxy pattern
 *  -- This interface serves as advice
 *  -- This interface is no need to be implemented
 *  -- This interface will be directly instantiated when it is needed
 *  
 * @author VinceYuan
 *
 */
public interface AfterAdvice {

	public void firstAfterAdvice ();
	public void secondAfterAdvice ();
}
