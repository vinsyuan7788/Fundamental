package org.lang.scala.conclusion.oop.function.apply

/**
 * 	This is a stand-alone object to test "apply"
 *  -- "apply" is a method for closing the gap between OOP and FP in Scala.
 *  
 *  Since in Scala, function is an object or instance, hence
 *  -- It should be able to be directly invoked as a function from FP perspective
 *     -- Hence function can be invoked by calling its reference (or name)
 *        -- Namely, func()
 *  -- And should be able to invoke methods as an object (or instance) from OOP perspective
 *     -- Hence function can invoke another method to INVOKE ITSELF
 *        -- Namely, func.apply()
 *        
 *  Since "func()" and "func.apply()" are equivalent, hence:
 *  -- Grammatically ".apply" can be skipped, and "apply" will be invoked implicitly in Scala
 *     -- This is widely-used in the declaration of object: 
 *        -- E.g., can define some "apply" methods inside an object and let the object invoke them accordingly
 *           -- More examples refer to "org/scala/conclusion/oop/TestObject.scala" and relevant Scala files
 * 
 * 	@author VinceYuan
 */
object TestApply {
  
  /*	Necessary instance variables	*/
  private val func = (x: Int, y: Int) => x + y
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    
    /*	Invoke a function from FP perspective	 */
    val res1 = func(1, 2)
    println(res1)
    
    /*	Invoke a function from OOP perspective	*/
    val res2 = func.apply(1, 2)
    println(res2)
  }
}