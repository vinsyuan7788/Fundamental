package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety

/**
 * 	This is a stand-alone object to test thread safety
 * 	-- Concern of thread-safety: if moving-forward of the procedure to achieve target is correct
 *  -- For thread-safety, at least one shared resource must be involved
 * 
 * 	To ensure thread-safety, there are 2 ways:
 *  -- Mutable resources: make sure the shared resources can be manipulated correctly
 *     -- Synchronization: synchronize shared resources
 *     -- Volatile: modify the shared resources with "volatile" keyword
 *     -- Atomics: use AtomicInteger/Long/Boolean/Reference for shared resources
 *  -- Immutable resources: or make sure the shared resources cannot be manipulated at all
 *     -- Final: modify the shared resources with "final" keyword (in Java)
 *     -- Val: modify the shared resources with "val" keyword (in Scala)
 *  -- Data structures: ConcurrentHashMap, Collections.synchronized(map), etc.
 * 
 * 	@author VinceYuan
 */
object TestThreadSafety {

}