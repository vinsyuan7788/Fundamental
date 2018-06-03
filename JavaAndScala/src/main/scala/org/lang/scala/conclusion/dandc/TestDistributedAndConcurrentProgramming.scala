package org.lang.scala.conclusion.dandc

/**
 * 	This is a stand-alone object to test distributed and concurrent programming
 *  -- Distributed programming: focus on the achievement of a system whose components are located on networked computation units (machines, computers, etc.)
 *     -- It involves the communication between computation units (inter-machine)
 *  -- Concurrent programming: focus on the achievement of several computations that are executed concurrently 
 *     -- It involves the computation inside a computation unit (intra-machine)
 *     -- It is a special case of distributed programming (when the communication units lie on different entities (threads, processes, etc.) in the same machine)
 *     
 *  Synchronous I/O v.s. a-synchronous I/O: from the perspective of the communication (of both entities in distributed (inter-machine) and concurrent (intra-machine) programming)
 *  -- Synchronous: requester (entity) actively waits for the completion of the request
 *     -- Both side of communication keep contact according to some clock that is synchronized in real time
 *     -- E.g., a thread starts an I/O operation and immediately enters a wait state until the I/O request has completed
 *  -- Asynchronous: requester (entity) can process other jobs before the completion of the request until receiver finishes the request and sends the result back by interrupting requester processing other jobs 
 *     -- Other job processing can be done by starting another thread for requesting
 *     -- The interruption can be done by callback, etc.  
 *  Here entity can be thread, process, or even machine, etc.
 *  
 *  Blocking I/O v.s. non-blocking I/O: from the perspective of the status of the entity itself while waiting (in concurrent programming)
 *  -- Blocking: entity cannot do anything more while waiting until the I/O is completed
 *  -- Non-blocking: entity can process other jobs while waiting
 *  Here entity can be thread, process, or even machine, etc.
 *  
 *  Hence there are 4 kinds of paradigm if combining these I/O: (assuming there are 2 entities A and B, here entities can be threads, processes, or even machines, etc.)
 *  -- Synchronous and blocking (S&B): A sends a request to B and do nothing while waiting until B completes the request
 *     -- In this case, the communication between A and B is synchronous and A is blocking
 *     -- This way is rather resource-wasting if the request is large and need to take much resource and time to wait for the response
 *  -- Synchronous and non-blocking (S&N): A sends a request to B and process other jobs while waiting until B completes the request (meanwhile A periodically checks if B responds, etc.)
 *     -- In this case, the communication between A and B is synchronous and A is non-blocking
 *     -- This way is rather resource-occupying (always need to use at least 1 thread to wait for B's response), hence can be replaced by asynchronous and non-blocking (A&N)
 *     -- To achieve this, can start another thread (or multiple threads) in A to process other jobs, etc.
 *  -- Asynchronous and blocking (A&B): A sends a request to B, then quit waiting, then do nothing until B completes the request and informs A
 *     -- In this case, the communication between A and B is asynchronous and A is blocking
 *     -- This way is completely resource-wasting since the thread A is idle after quitting waiting for response of B (in synchronous and blocking, A at least spends resource in waiting B's response)
 *  -- Asynchronous and non-blocking (A&N): A sends a request to B, then quit waiting and process other jobs, until B completes the request and informs A by interrupting what A is doing
 *     -- In this case, the communication between A and B is asynchronous and A is non-blocking
 *     -- This way is much more efficient since A does not need to actively wait for B's response, and A can process other jobs
 *     -- To achieve this, can start another thread (or multiple threads) in A to process other jobs, etc.
 * 	Hence generally S&B > A&B; S&N < A&N
 * 
 * 	Thread-safety: A section of codes can function correctly as expected if executed simultaneously (or concurrently) by multiple threads. The codes can be:
 *  -- Atomic (or single) operation, e.g.:
 *     -- { atomicInteger.incrementAndGet }
 *     -- { concurrentLinkedQueue.add(element) }
 *     -- etc.
 *  -- Non-atomic (or multiple) operations, e.g.: 
 *     -- if (!concurrentLinkedQueue.isEmpty) { concurrentLinkedQueue.remove }
 *     -- { submitTask(task); println(...); } 
 *     -- etc.
 * 
 * 	@author VinceYuan
 */
object TestDistributedAndConcurrentProgramming {
  
}