package org.lang.scala.conclusion.dandc.common.classes.spark.context

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.atomic.AtomicReference

/**
 * 	This is a companion class to simulate SparkContext
 * 
 * 	@author VinceYuan
 */
class SparkContext private() {
  
  /*	Necessary instance variables	*/
  private val nextRddId = new AtomicInteger(0)
  private val nextShuffleId = new AtomicLong(0)
  
  /**
   * 	This is a method to get a new RDD ID
   */
  def newRddId() = nextRddId.getAndIncrement()
  
  /**
   * 	This is a method to get a new Shuffle ID
   */
  def newShuffleId() = nextShuffleId.getAndIncrement()
}

/**
 * 	This is a companion object to simulate SparkContext
 * 
 * 	@author VinceYuan
 */
object SparkContext {
  
  /*	Necessary instance variables	*/
  private val activeContext = new AtomicReference[SparkContext]()
  
  /**
   * 	This is a method to get or create an instance of SparkContext
   */
  def getOrCreate() = {
    val sparkContext = activeContext.get
    if (sparkContext == null || sparkContext.eq(null)) {
      setActiveContext(new SparkContext())
    }
    activeContext.get
  }
  
  /**
   * 	This is a method to set active context into an AtomicReference instance
   */
  private def setActiveContext(sparkContext: SparkContext) = {
    activeContext.set(sparkContext)
  } 
}