package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.synchronization.common;

/**
 * 	This is a stand-alone class to serve as a shared resource
 * 
 * @author VinceYuan
 *
 */
public class ConvenienceStoreJava extends ConvenienceStore {

	/**
	 * 	This is a method that overrides parent's method
	 */
	@Override
	public synchronized void purchaseItem(int number) {
		itemStock_$eq(itemStock() + number);
		System.out.println("Supplier " + Thread.currentThread().getId() + " sold " + number + " items. Now " + itemStock() + " left in the store.");
	}
}
