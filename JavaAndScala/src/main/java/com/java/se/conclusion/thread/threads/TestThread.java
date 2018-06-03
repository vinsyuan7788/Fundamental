package com.java.se.conclusion.thread.threads;

import com.java.se.conclusion.thread.threads.common.Museum;
import com.java.se.conclusion.thread.threads.common.Visitor;
import com.java.se.conclusion.thread.threads.util.ThreadUtils;

/**
 * 	This is a class to test thread
 * 
 * 	There are 3 ways of thread creation:
 * 	-- 1st way for thread creation: "<? extends Thread> thread = new <? extends Thread>();"
 * 	   -- Create a class that extends "Thread" class
 * 	   -- Override the "run()" method
 *  -- 2nd way for thread creation: "Thread xxx = new Thread(<? implements Runnable> instance);"
 * 	   -- Create a class that implements "Runnable" interface
 *     -- Override the "run()" method
 *  -- 3rd way for thread creation: "Thread thread = new Thread(Runnable instance);"
 *     -- Can directly use lambda expression
 *     
 *  Comparison of thread creation:
 *  -- 1st way can customize instance variables and constructors
 *  -- 3rd way is the simplified version of 2nd way since 3rd way can directly use lambda expression
 *  
 * @author VinceYuan
 *
 */
public class TestThread {

	/*	Necessary instance variables	*/
	private Thread vince;
	private Thread violet;
	private Thread johnny;
	private long millionSeconds = 1000;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestThread testThread = new TestThread();
		testThread.testPreparation();
		testThread.testThreadOperation();
	}
	
	/**
	 * 	Test preparation
	 *  -- Create threads using 3 different ways
	 */
	private void testPreparation() {
		
		/*	Current thread information	*/
		System.out.println("Current thread information:");
		ThreadUtils.getThreadInfo(Thread.currentThread());
		
		/*	1st way to create a thread	*/
		vince = new Museum(millionSeconds);
		System.out.println("\nThe thread information:");
		ThreadUtils.getThreadInfo(vince);
		
		/*	2nd way to create a thread	*/
		violet = new Thread(new Visitor());
		System.out.println("\nThe thread information:");
		ThreadUtils.getThreadInfo(violet);
		
		/*	3rd way to create a thread	*/
		johnny = new Thread(() -> { System.out.println("Hello Thread!"); });
		System.out.println("\nThe thread information:");
		ThreadUtils.getThreadInfo(johnny);
	}
	
	/**
	 * 	Test thread operation
	 */
	private void testThreadOperation() {
	
		try {
			/*	Start the child thread	*/
			System.out.println("\nThe thread starts:");
			vince.start();
			
			/*	Main thread ends until this child thread dies	*/
			vince.join();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
