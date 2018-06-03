package org.lang.scala.common.utils

/**
 * 	This is a stand-alone object that contains collection utility methods
 * 
 * 	@author VinceYuan
 */
object CollectionUtils {
  
  /**
   * 	This is a method to concatenate the items in a list
   */
  def toString(list: List[Any]): String = {
    val stringBuilder: StringBuilder = new StringBuilder()
    for (i <- 0 until list.size) {
      if (i > 0) stringBuilder.append(", ")
      stringBuilder.append(list(i))
    }
    stringBuilder.toString()
  }
}