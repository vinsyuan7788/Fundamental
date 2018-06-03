package org.lang.scala.conclusion.interoperation.recommendation

import scala.collection.JavaConverters.seqAsJavaListConverter

/**
 * 	This is a companion class to recommend associated items
 *  
 *  @author VinceYuan
 */
class AssociationRecommender {
  
}

/**
 * 	This is a companion object to recommend associated items
 *  -- The recommendation process and results are simulated
 *  -- Practically it can be done by Spark Machine Learning API, etc.
 *  
 *  @author VinceYuan
 */
object AssociationRecommender {
  
  def recommend() = {
    val items = List(8L, 1L, 3L).asJava
    items
  }
}