package com.java.se.conclusion.thread.synchronization.common;

import com.java.se.common.utils.OrdinalUtils;

/**
 * 	This is a class to implement synchronization
 *  -- Using synchronized block
 * 
 * @author VinceYuan
 *
 */
public class TicketOffice extends Thread {
	
	/*	This is the sharable resource for all possible threads	*/
	static int ticketNum = 50;
	
	/*	Override one of the constructors in Thread	*/
	public TicketOffice(String name) {
		super(name);
	}
	
	/*	Specify what current thread does: just specify and not invoke it	 */
	@Override
	public void run() {
		
		while (true) {
			/**	
			 * 	Synchronized block to resolve thread safety: 
			 * 	-- Mutex argument MUST be unique and sharable for all threads	
			 *     -- Class instance 
			 * 	   -- String instance e.g. "mutex", "abc", "hello", etc.
			 *        -- Due to string immutability
			 */
			synchronized (TicketOffice.class) {
				if (ticketNum > 0) {
					System.out.println(Thread.currentThread().getName() + " sold the " + OrdinalUtils.toOrdinal(ticketNum) + " ticket");
					ticketNum--;
				} else {
					System.out.println("The tickets sold up");
					break;
				}
			}	
		}
	}
}
