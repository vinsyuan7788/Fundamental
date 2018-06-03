package com.java.se.conclusion.thread.synchronization;

import com.java.se.conclusion.thread.synchronization.common.BankAccount;
import com.java.se.conclusion.thread.synchronization.common.HotItemSales;
import com.java.se.conclusion.thread.synchronization.common.TicketOffice;

/**
 * 	This is a class to test synchronization
 * 
 * 	One Java application has at least 2 threads
 *  -- One for main function: main thread that execute all the thread objects
 * 	-- One for garbage collection
 * 	-- Other custom thread objects
 * 
 * 	Thread-safety problem: one resources maybe accessed by multiple threads at a moment
 * 	-- It happens when:
 *     -- There are at least 2 threads
 * 	   -- There is one sharable resource
 *  -- To address thread-safety problem:
 *     -- Use synchronized block or method to resolve thread safety problem
 *     -- Recommend synchronized block: since it can specify the mutex and what blocks to be synchronized (more fine-grained)
 * 
 * @author VinceYuan
 *
 */
public class TestSynchronization {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestSynchronization testSynchronization = new TestSynchronization();
		System.out.println("Here tests synchronized block:");
		testSynchronization.testSynchronizedBlock();
		System.out.println("Here tests synchronized method:");
		testSynchronization.testSynchronizedMethod();
	}
	
	/**
	 * 	Test synchronized block
	 */
	private void testSynchronizedBlock() {
		
		try {
			/*	Create some thread objects for ticket sales	 */
			Thread office_1 = new TicketOffice("Ticket Office 1");
			Thread office_2 = new TicketOffice("Ticket Office 2");
			Thread office_3 = new TicketOffice("Ticket Office 3");
			
			// For temporary test: can be commented or deleted if unnecessary
			Thread office_4 = new HotItemSales();
			Thread office_5 = new HotItemSales();
			Thread office_6 = new HotItemSales();
			office_4.start();
			office_5.start();
			office_6.start();
			
			/*	Start these threads	 */
			office_1.start();
			office_2.start();
			office_3.start();
			
			/*	Wait until these threads die	*/
			office_1.join();
			office_2.join();
			office_3.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	Test synchronized method
	 */
	private void testSynchronizedMethod() {
		
		try {
			/*	Create some thread objects for deposit withdraw	*/
			Thread wife = new Thread(new BankAccount(), "wife");
			Thread husband = new Thread(new BankAccount(), "husband");
			Thread child = new Thread(new BankAccount(), "child");
			
			/*	Start these threads	 */
			wife.start();
			husband.start();
			child.start();
			
			/*	Wait until theses threads die	*/
			wife.join();
			husband.join();
			child.join();
//			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
