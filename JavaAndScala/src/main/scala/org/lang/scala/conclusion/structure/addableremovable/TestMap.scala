package org.scala.conclusion.structure.addableremovable

import scala.reflect.runtime.universe
import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test Map
 *  -- Map is immutable
 *     -- This can ensure thread-security
 *  
 *	@author VinceYuan
 */
object TestMap {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testMap()
  }
  
  /**
   * 	This is a method to test Map
   */
  private def testMap(): Unit = {
    
    /*	This is a map to store maps	 */
    var map: Map[Int, Any] = Map()
      
    /*	Initialize two ranges	 */
    var map1 = Map("name" -> "Vince", "age" -> 27)
    map1 = map1 + (("job", "scala engineer"))
    map1 = map1 ++ (Map("id" -> 1, "salary" -> 200000))
    map += (0 -> map1)
    var map2 = Map[String, Int]()
    map2 = map2 ++: (Map("age" -> 27))
    map2 = map2 ++: (Map("id" -> 1, "salary" -> 200000))
    map += (1 -> map2)
    
    /*	Output information	*/
    println("If " + map(0) + " and " + map(1) + " are the same: " + map(0).equals(map(1)))
    println("map(0) data type is: " + ReflectionUtils.getRuntimeType(map(0)))
    println("map1 data type is: " + ReflectionUtils.getRuntimeType(map1))
    println("map(1) data type is: " + ReflectionUtils.getRuntimeType(map(1)))
    println("map2 data type is: " + ReflectionUtils.getRuntimeType(map2))
    println("If map1 is [string, any]-map: " + map1.isInstanceOf[Map[String, Any]])
    println("If map2 is [string, int]-map: " + map2.isInstanceOf[Map[String, Int]])
    
    /*	Traverse a map using functional operation	 */
    val stringBuilder: StringBuilder = new StringBuilder()
    println("\nNow traverse a map using functional operation:")
    map1.map { x => stringBuilder.append(x + ", ") }
    println(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")))
  }
}