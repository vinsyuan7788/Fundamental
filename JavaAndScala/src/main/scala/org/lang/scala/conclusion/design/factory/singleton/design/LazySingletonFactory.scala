package org.lang.scala.conclusion.design.factory.singleton.design

import scala.reflect._
import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to implement lazy singleton factory pattern
 * 	-- Declare a private, volatile and Any-typed reference
 *  -- Declare a public and static getter to get this unique object:
 *     -- Double-checked locking pattern is used in this pattern
 *     
 *	@author VinceYuan
 */
object LazySingletonFactory {
  
  /*	Declare a private, volatile and Any-typed reference	 */
  @volatile private var instance: Any = _
  
  /**
   * 	This is a method to get the singleton instance for Scala only
   */
  def getInstance[T : ClassTag] = {
    
    /*
     * 	Here is double-checked locking pattern
     * 	-- To ensure there is only one thread that can access the resource in the synchronized block
     *  -- Predicate 1 cannot be removed, otherwise each time that a thread accesses here will grab the lock, which is unnecessary once the private field "instance" is assigned an instance
     *  -- Predicate 2 cannot be removed, otherwise 2 or more threads may pass the predicate 1 and wait to grab the lock to assign instances to the private field "instance" repeatedly 
     */
    if (instance == null || instance.equals(null)) {          // Predicate 1
      this.synchronized {
        if (instance == null || instance.equals(null)) {      // Predicate 2
          val clazz = ReflectionUtils.getJavaClassFromScalaType[T]
          instance = clazz.newInstance()
        }
      }
    }
    
    /*	Return the singleton instance	 */
    instance
  }
  
  /**
   * 	This is a method to get the singleton instance for the compatibility with Java
   */
  def getInstance(clazz: Class[_]) = {
    
    /*
     * 	Here is double-checked locking pattern
     * 	-- To ensure there is only one thread that can access the resource in the synchronized block
     *  -- Predicate 1 cannot be removed, otherwise each time that a thread accesses here will grab the lock, which is unnecessary once the private field "instance" is assigned an instance
     *  -- Predicate 2 cannot be removed, otherwise 2 or more threads may pass the predicate 1 and wait to grab the lock to assign instances to the private field "instance" repeatedly 
     */
    if (instance == null || instance.equals(null)) {          // Predicate 1
      this.synchronized {
        if (instance == null || instance.equals(null)) {      // Predicate 2
          instance = clazz.newInstance()
        }
      }
    }
    
    /*	Return the singleton instance	 */
    instance
  }
}