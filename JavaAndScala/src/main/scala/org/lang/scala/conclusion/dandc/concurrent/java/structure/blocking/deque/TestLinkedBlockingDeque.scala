package org.lang.scala.conclusion.dandc.concurrent.java.structure.blocking.deque

import java.util.concurrent.LinkedBlockingDeque

import org.lang.scala.conclusion.dandc.common.cases.spark.event.JobCancelled
import org.lang.scala.conclusion.dandc.common.cases.spark.event.JobSubmitted
import org.lang.scala.conclusion.dandc.common.cases.spark.event.MapStageSubmit
import org.lang.scala.conclusion.dandc.common.cases.spark.event.StageCancelled
import org.lang.scala.conclusion.dandc.common.cases.spark.event.TaskCancelled
import org.lang.scala.conclusion.dandc.common.cases.spark.event.TaskSubmitted
import org.lang.scala.conclusion.dandc.common.classes.spark.event.Event
import org.lang.scala.conclusion.dandc.common.utils.ThreadUtils

/**
 * 	This is a stand-alone object to test LinkedBlockingDeque class
 *  -- If there is no element inside LinkedBlockingDeque, this LinkedBlockingDeque can be blocked until there is new element coming in
 *     -- E.g., when invoking "take", "put" method, etc.
 *  -- LinkedBlockingDeque will take a lock before any modification (not using CAS)
 *  -- Suitable for situation where blocking is needed
 * 
 * 	@author VinceYuan
 */
object TestLinkedBlockingDeque {
  
  /*	Necessary instance variables	*/
  private val eventQueue = new LinkedBlockingDeque[Event]()
  private lazy val eventList = List(JobSubmitted(), JobCancelled(), MapStageSubmit(), StageCancelled(), TaskSubmitted(), TaskCancelled())
  private val threadPoolExecutor = ThreadUtils.newFixedThreadPool(2)
  private val eventProcessingThread = new Thread() {
    setDaemon(true)
    override def run(): Unit = {
      while (true) {
        // "take" method will block the thread and does not throw an exception when the queue is empty
        val event = eventQueue.take()
        processEvent(event)
      }
    }
  }
  private val eventSubmittingThread = new Thread() {
    setDaemon(true)
    override def run(): Unit = {
      while (true) {
        Thread.sleep(1000)
        val randomIdx = math.floor(math.random * eventList.size).toInt
        val event = eventList(randomIdx)
        submitEvent(event)
      }
    }
  } 
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = { 
    testLinkedBlockingDeque()
  }
  
  /**
   * 	This is a method to test LinkedBlockingDeque class
   */
  private def testLinkedBlockingDeque(): Unit = {
    threadPoolExecutor.execute(eventProcessingThread)
    threadPoolExecutor.execute(eventSubmittingThread)
    threadPoolExecutor.shutdown()
  }
  
  /*	Here are utility methods	*/
  private def submitEvent(event: Event) = eventQueue.put(event)
  private def processEvent(event: Event) = event match {
    case JobSubmitted() => println("Job has been submitted...")
    case JobCancelled() => println("Job has been cancelled...")
    case MapStageSubmit() => println("Map stage has been submitted...")
    case StageCancelled() => println("Stage has been cancelled...")
    case TaskSubmitted() => println("Task has been submitted...")
    case TaskCancelled() => println("Task has been cancelled...")
  }
}