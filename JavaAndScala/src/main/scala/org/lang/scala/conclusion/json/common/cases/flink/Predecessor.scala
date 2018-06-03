package org.lang.scala.conclusion.json.common.cases.flink

/**
 * 	This is a case class to test conversion between Scala and JSON
 * 	-- If need to use collections, strongly RECOMMEND to use Java collections instead of Scala collections
 *     -- Since GSON is intrinsically designed and has basically perfect compatibility for Java
 *  -- E.g., when need to use List collections:
 *     -- If using Java List, there is no any problem
 *     -- If using Scala List[T], need to implement a custom (de)serializer for it and (it turns out) T can be only 1 type
 *        -- This largely limits the compatibility of implementation for Scala
 * 
 * 	@author VinceYuan
 */
case class Predecessor(

    val id: Long,
    val ship_strategy: String,
    val side: String
    
) {
  
  /**
   * 	For readability
   */
  override def toString() = {
    s"Predecessor[id=${id}, ship_strategy=${ship_strategy}, side=${side}]"
  }
}