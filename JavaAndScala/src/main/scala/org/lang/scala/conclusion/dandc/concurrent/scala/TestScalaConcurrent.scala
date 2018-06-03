package org.lang.scala.conclusion.dandc.concurrent.scala

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration.Duration
import scala.concurrent.duration.SECONDS
import scala.util.Failure
import scala.util.Success
import org.lang.scala.conclusion.dandc.common.cases.Heartbeat
import scala.concurrent.Promise

/**
 * 	This is a stand-alone object to test Scala concurrent package
 *  -- This package is usually used as a complementary part for Java distributed and concurrent programming in big data framework development
 *     -- E.g., Spark, Flink, etc.
 * 
 * 	@author VinceYuan
 */
object TestScalaConcurrent {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests Future:")
    testFuture()
    Thread.sleep(1000)
    println("\nHere tests Promise:")
    testPromise()
    Thread.sleep(1000)
    println("\nHere tests Await:")
    testAwait()
  }
  
  /**
   * 	This is a method to test Future
   *  -- Future represents a result that will be returned (or received) afterwards (in the future), which can be returned from
   *     -- A thread: val future = Future { ... }; future.onComplete { ... }
   *     -- A promise: val promise = Promise[T](); ... ; promise.future.onComplete { ... }
   * 	-- Once a future is declared, it will be started running within the implicit ExecutionContext
   */
  private def testFuture(): Unit = {
    
    /*	Generate futures and let them run automatically	 */
    val (futures1, isCompletedList1) = generateFutures(List(11, 22, 33))
    if (isCompletedList1.filter { isCompleted => isCompleted == true }.size == 0) {
      /*
       *  To see this statement, may need to run this method for a couple of times
       *  -- Sometimes this statement is not shown because the threads are completed too quickly even before invoking "isCompleted"
       */
      println("All futures are not completed when just created!")
    }
    Thread.sleep(1)    // Wait for 1 seconds
    if (futures1.filter { future => !future.isCompleted }.size == 0) {
      println("After 1 seconds, all futures are completed!")
    }
    
    /*	Generate futures and do something according to the return results	 */
    var (futures2, isCompletedList2) = generateFutures(List(44, 55, 66))
    isCompletedList2 = doSomethingOnCompletionOfFutures(futures2)
    if (isCompletedList2.filter { isCompleted => isCompleted == false }.size == 0) {
      println("All futures are completed after doing something according to the return results!")
    }
  }
  
  /**
   * 	This is a method to test Promise
   * 	-- Promise is an object which can be completed with a value or failed with an exception
   *  -- A promise can only be set one value (either success)
   *  -- This is typically useful in the development of Scala Web framework
   *     -- Since it is good for non-blocking I/O
   */
  private def testPromise(): Unit = {
    
    /**
     * 	This is a method to get the future from a promise
     */
    def getFutureFromPromise() = {
      
      /*	Initialize a promise	*/
      val promise = Promise[String]
      
      /*	Run 2 threads to fulfill the promise	*/
      Future {
        println("A promise has been made, now thread 1 is working to fulfill the promise")
        Thread.sleep((math.random * 2000).toLong)
        promise.success("Succeed to fulfill the promise!")
      }
      Future {
        println("A promise has been made, now thread 2 is working to fulfill the promise")
        Thread.sleep((math.random * 2000).toLong)
        promise.failure(new Exception("Fail to fulfill the promise..."))
      }
      
      /*	Return the future of the promise	*/
      promise.future 
    }
    
    /*	Get the future from promise and completes the future	 */
    val future = getFutureFromPromise()
    println("Now it is time to check how the promise that has been made before turns out")
    future.onComplete { result => result match {
      case Success(message) => println(message)
      case Failure(exception) => println(exception.getMessage)
    } }
  }
  
  /**
   * 	This is a method to test Await
   */
  private def testAwait(): Unit = {
   
    /*	Generate some futures and await their results	 */
    val futures = generateFutures(List(11, 22, 33))._1
    val logResults = awaitResults(futures, Duration(1, SECONDS))
    logResults.foreach { logResult => println(s"Logging message successfully? ${logResult}") }
    futures.foreach { future => println(s"If future is completed: ${future.isCompleted}") }
  }
  
  /**
   * 	This is a method to generate a list of futures
   */
  private def generateFutures(workerIds: List[Long]) = {
    var isCompletedList = List[Boolean]()
    val futures = workerIds.map { workerId => 
      val future = Future {
        heartbeat(workerId)
      }.map { message => 
        logMessage(message) 
      }
      val isCompleted = future.isCompleted
      isCompletedList :+= isCompleted
      future
    }
    (futures, isCompletedList)
  }
  
  /**
   * 	This is a method to do something on the completion of futures according to the return results
   */
  private def doSomethingOnCompletionOfFutures[T](futures: List[Future[T]]) = {
    futures.map { future => 
      future.onComplete { 
        case Success(logResult) => println(s"Logging worker: ${logResult}")
        case Failure(exception) => println(s"Failure! ${exception.getMessage}")
      } 
      future.isCompleted
    }    
  }
  
  /**
   * 	This is a method to await return results of futures
   */
  private def awaitResults[T](futures: List[Future[T]], timeout: Duration) = {
    futures.map { future => {
      Await.result(future, timeout)
    } }
  }
  
  /**
   * 	Here are the methods to do some tasks
   */
  private def heartbeat(workerId: Long) = Heartbeat(workerId, 2, 49397653, true)
  private def logMessage[T](message: T) = message match {
    case Heartbeat(workerId, freeCores, freeMemory, isLive) => workerId
    case _ => throw new Exception("Unexpected message")
  }
}