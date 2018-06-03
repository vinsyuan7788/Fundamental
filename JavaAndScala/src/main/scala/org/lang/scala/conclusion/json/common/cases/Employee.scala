package org.lang.scala.conclusion.json.common.cases

import java.util.Date
import java.util.List

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
case class Employee(

    val id: Int,
    val firstName: String,
    val lastName: String,
    val birthdate: Date,
    val roles: List[String],
    val departments: List[Department]
    
) {
  
  /**
   * 	For readability
   */
  override def toString = {
    s"Employee[id=${id}, firstName=${firstName}, lastName=${lastName}, birthdate=${birthdate}, roles=${roles}, departments=${departments}]"
  }
}