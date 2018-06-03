package com.java.se.conclusion.thread.deadlock;

/**
 * This is a class to test dead lock
 * 
 *  Deadlock: a situation where two or more threads are blocked forever, waiting for each other. It occurs when: 
 * 	-- There is 1 sharable resource at least
 * 	-- There are 2 threads at least
 * 	-- All the threads are waiting for each to release the mutex lock
 * 
 * @author VinceYuan
 *
 */
public class TestDeadLock {

	/* Necessary instance variables */
	private String str1 = "Java";
	private String str2 = "Unix";
	private Thread thread;
	private Thread deadLockThread;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestDeadLock testDeadLock = new TestDeadLock();
		testDeadLock.testPreparation();
		testDeadLock.testDeadLock();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		
		thread = new Thread("Thread") {
			
			/*	Forever wait the mutex str1 and str2 subsequently	*/
			public void run() {
	            while(true){
	                synchronized(str1){
	                    synchronized(str2){
	                        System.out.println(this.getName() + ": " + (str1 + str2));
	                    }
	                }
	            }
			}
		};
		deadLockThread = new Thread("Thread for Deadlock") {
			
			/*	Forever wait the mutex str2 and str1 subsequently	*/
	        public void run(){
	            while(true){
	                synchronized(str2){
	                    synchronized(str1){
	                        System.out.println(this.getName() + ": " + (str2 + str1));
	                    }
	                }
	            }
	        }
		};
	}

	/**
	 * 	Test dead lock
	 */
	private void testDeadLock() {
		try {
			thread.start();
			deadLockThread.start();
			thread.join();
			deadLockThread.join();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
