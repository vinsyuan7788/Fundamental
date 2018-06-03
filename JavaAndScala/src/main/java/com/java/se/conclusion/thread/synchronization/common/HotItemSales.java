package com.java.se.conclusion.thread.synchronization.common;

public class HotItemSales extends Thread {

	private Integer stock = 100;
	
	private Object lock = new Object();

	@Override
	public void run() {
		
//		while (stock > 0) {
			synchronized (lock) {
				stock--;
				System.out.println("Thread " + getId() + "'s transaction completes! Stock " + stock);
			}
//		}
	}
}
