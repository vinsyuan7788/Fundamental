package org.lang.scala.conclusion.design.singleton.design

/**
 * 	This is a companion class that implements lazy singleton
 * 
 * 	@author VinceYuan
 */
/*	Privatize main constructor	*/
class Student private() {
  
}

/**
 * 	This is a companion object that creates a singleton lazily
 * 
 * 	@author VinceYuan
 */
object Student {
  
  /*	Declare a null reference	*/
  @volatile private var instance: Student = _
  
  /*	This is a method to get a singleton instance lazily	 */
  def getInstance() = {
    
    /*
     * 	Here is double-checked locking pattern
     * 	-- To ensure there is only one thread that can access the resource in the synchronized block
     *  -- Predicate 1 cannot be removed, otherwise each time that a thread accesses here will grab the lock, which is unnecessary once the private field "instance" is assigned an instance
     *  -- Predicate 2 cannot be removed, otherwise 2 or more threads may pass the predicate 1 and wait to grab the lock to assign instances to the private field "instance" repeatedly 
     */
    if (instance == null || instance.eq(null)) {            // Predicate 1
      this.synchronized {
        if (instance == null || instance.eq(null)) {        // Predicate 2
          instance = new Student()
        }
      }
    }
    
    /*	Return the instance	 */
    instance
  }
}