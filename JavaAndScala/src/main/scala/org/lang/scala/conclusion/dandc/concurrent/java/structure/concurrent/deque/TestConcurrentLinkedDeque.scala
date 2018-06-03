package org.lang.scala.conclusion.dandc.concurrent.java.structure.concurrent.deque

import java.util.concurrent.Callable
import java.util.concurrent.ConcurrentLinkedDeque

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

import org.lang.scala.conclusion.dandc.common.cases.spark.task.ResultTask
import org.lang.scala.conclusion.dandc.common.cases.spark.task.ShuffleMapTask
import org.lang.scala.conclusion.dandc.common.classes.spark.task.Task
import org.lang.scala.conclusion.dandc.common.utils.ThreadUtils

/**
 * 	This is a stand-alone object to test ConcurrentLinkedDeque class
 *  -- This class can efficiently prevent queue cutting when adding elements in concurrent environment (e.g., multi-threading)
 *     -- Since it uses CAS (Compare-And-Swap/Set)
 *  -- Suitable for situation where there is high-concurrency
 * 
 * 	@author VinceYuan
 */
object TestConcurrentLinkedDeque {
 
  /*	Necessary instance variables	*/
  private val schedulableQueue = new ConcurrentLinkedDeque[Task]()
  private lazy val taskList = List(ShuffleMapTask(), ResultTask())
  private val threadPoolExecutor = ThreadUtils.newCachedThreadPool()
  private val producerThreadNum = 10
  private val producerThreads = generateProducerThreads(producerThreadNum)
  private val consumerThreadNum = 1
  private val consumerThreads = generateConsumerThreads(consumerThreadNum)

  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testConcurrentLinkedDeque()
  }
  
  /**
   * 	This is a method to test ConcurrentLinkedDeque class
   */
  private def testConcurrentLinkedDeque(): Unit = {
    
    /*	Invoke threads to submit tasks	*/
    val futureResults = threadPoolExecutor.invokeAll(producerThreads)
    
    /*	Invoke threads to process submitted tasks	 */
    if (futureResults.filter { taskResult => taskResult.get == false }.size != 0) System.exit(-1)
    threadPoolExecutor.invokeAll(consumerThreads)
    threadPoolExecutor.shutdown()
  }
  
  /**
   * 	This is a method to generate producer threads
   */
  private def generateProducerThreads(threadNum: Int) = {
    
    /*	Initialize a list to store call-able threads	 */
    var threads = List[Callable[Boolean]]()
    
    /*	Add call-able thread into the list	*/
    for (i <- 0 until threadNum) {
      val thread = new Callable[Boolean]() {
        override def call(): Boolean = {
          try {
            val randomIdx = math.floor(math.random * taskList.size).toInt
            val task = taskList(randomIdx)
            submitTask(i, task)
            true
          } catch {
            case t: Throwable => false
          }
        }
      }
      threads :+= thread
    }
    
    /*	Return the list	 */
    threads
  }
  
  /**
   * 	This is a method to generate consumer threads
   */
  private def generateConsumerThreads(threadNum: Int) = {
    
    /*	Initialize a list to store call-able threads	 */
    var threads = List[Callable[Unit]]()
    
    /*	Add call-able thread into the list	*/
    for (i <- 0 until threadNum) {
      val thread = new Callable[Unit]() {
        override def call(): Unit = {
          while (!schedulableQueue.isEmpty()) {
            val task = schedulableQueue.remove()  
            processTask(task) 
          }
        }
      }
      threads :+= thread
    }
    
    /*	Return the list	 */
    threads
  }
  
  /*	Here are utility methods	*/
  private def submitTask(threadNum: Int, task: Task) = this.synchronized {
    schedulableQueue.add(task)
    println(s"Thread ${threadNum} has submitted ${task}") 
  }
  private def processTask(task: Task) = task match {
    case ShuffleMapTask() => println("ShuffleMapTask has been processed...")
    case ResultTask() => println("ResultTask has been processed...")
  }
}