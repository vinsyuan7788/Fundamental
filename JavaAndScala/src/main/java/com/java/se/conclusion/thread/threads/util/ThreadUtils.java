package com.java.se.conclusion.thread.threads.util;

/**
 * 	This is a class to implement thread utility method
 * 
 * @author VinceYuan
 *
 */
public class ThreadUtils {

	/**
	 * 	This is a method to get the information of a thread
	 * @param thread
	 */
	public static void getThreadInfo(Thread thread) {
		
		System.out.println("Thread ID: " + thread.getId());
		System.out.println("Thread name: " + thread.getName());
		System.out.println("Thread state: " + thread.getState());
		System.out.println("Thread priority: " + thread.getPriority());
		System.out.println("Thread group: " + thread.getThreadGroup().getName());
		System.out.println("If thread is alive: " + thread.isAlive());
		System.out.println("If thread is daemon: " + thread.isDaemon());
		System.out.println("If thread is interrupted: " + thread.isInterrupted());
	}
}
