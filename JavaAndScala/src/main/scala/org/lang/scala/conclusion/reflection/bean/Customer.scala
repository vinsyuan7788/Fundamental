package org.lang.scala.conclusion.reflection.bean

import org.lang.scala.conclusion.reflection.bean.parent.Human
import org.lang.scala.conclusion.reflection.bean.parent.Survive

/**
 * 	This is a stand-alone object to test reflection
 * 	-- Stand-alone object CANNOT be reflected through reflection
 *     -- Since a stand-alone object does not have a companion class for reflection
 * 
 * 	@author VinceYuan
 */
object Customer extends Human with Survive {

  /*	Instance variables	*/
  var location: String = _
  
  /*	Inherited methods to be overridden	*/
  override def live(name: String, age: Int, gender: Char, race: String): Unit = {
    println("A Customer[name=" + name + ", age=" + age + ", gender=" + gender + ", race=" + race + "] is living happily...")
  }
  override def study(id: String, name: String): Unit = {
    println("A Customer[id=" + id + ", name=" + name + "] is studying new technologies...")
  }
  
  /*	For readability	 */
  override def toString(): String = {
    "Customer[location=" + location + ", race=" + race + "]"
  }
}