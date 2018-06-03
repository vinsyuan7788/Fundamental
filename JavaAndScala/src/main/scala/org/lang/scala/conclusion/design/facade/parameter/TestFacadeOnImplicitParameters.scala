package org.lang.scala.conclusion.design.facade.parameter

import org.lang.scala.conclusion.design.facade.facade.CustomPredef.IntMonoid
import org.lang.scala.conclusion.design.facade.facade.CustomPredef.StringMonoid
import org.lang.scala.conclusion.design.facade.facade.CustomPredef.char
import org.lang.scala.conclusion.design.facade.facade.CustomPredef.confess
import org.lang.scala.conclusion.design.facade.facade.CustomPredef.int
import org.lang.scala.conclusion.design.facade.facade.CustomPredef.str
import org.lang.scala.conclusion.design.facade.parameter.traits.Monoid

/**
 * 	This is a stand-alone object to test facade pattern on implicit parameters
 * 
 * 	@author VinceYuan
 */
object TestFacadeOnImplicitParameters {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testFacadeOnImplicitParameters()
  }
  
  /**
   * 	This is a method to test facade on implicit parameters
   */
  private def testFacadeOnImplicitParameters(): Unit = {
    
    sayHello("GFriend")
    sayHello("GFriend")(10, 'F', "Baby")
    sayTo("Pristin")
    sayTo("Pristin")(name => println("Go fighting! " + name))
    sayAloha[String]("Lovelyz")
    sayAloha("Lovelyz")("Livelyz") 
    println(sum(List(1, 2, 3)))
    println(sum(List("a", "b", "c")))
  }
  
  /**
   * 	Here are the methods to test facade pattern on implicit
   */
  private def sayHello(name: String)(implicit x: Int, y: Char, z: String) = {
    println(s"Hello $name, $x, $y, $z")
  }
  private def sayTo(name: String)(implicit f: String => Unit) {
    f(name)
  }  
  private def sum[T](list: List[T])(implicit monoid: Monoid[T]): T = {
    if (list.isEmpty) monoid.unit
    else monoid.add(list.head, sum(list.tail))  
  }
  private def sayAloha[T](name: String)(implicit value: T) {
    println(s"Hello $name, $value")
  }
}