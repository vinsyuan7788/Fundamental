package org.lang.scala.conclusion.design.facade.facade

import org.lang.scala.conclusion.design.facade.chain.classes.A
import org.lang.scala.conclusion.design.facade.chain.classes.B
import org.lang.scala.conclusion.design.facade.chain.classes.C
import org.lang.scala.conclusion.design.facade.conversion.classes.Developer
import org.lang.scala.conclusion.design.facade.conversion.classes.Professor
import org.lang.scala.conclusion.design.facade.conversion.classes.ScalaDeveloper
import org.lang.scala.conclusion.design.facade.conversion.classes.Teacher
import org.lang.scala.conclusion.design.facade.parameter.traits.Monoid

/**
 * 	This is a stand-alone object to serve as facade for implicits parameter, conversion and chain
 *  -- Whatever file that introduces this file is in the same scope with this file
 * 	
 * 	@author VinceYuan
 */
object CustomPredef {

  /*	Here are the implicit parameters	*/
  implicit val int = 10
  implicit val char = 'M'
  implicit val str = "Lovelyz"
  implicit val confess = (str: String) => println("I love you " + str)
  implicit object StringMonoid extends Monoid[String] {
    def add(x: String, y: String): String = x concat y
    def unit: String = ""
  }
  implicit object IntMonoid extends Monoid[Int] {
    def add(x: Int, y: Int): Int = x + y
    def unit: Int = 0
  }
  
  /*	Here are the implicit conversion	*/
  implicit def teacher2Professor(instance: Teacher) = new Professor(instance)    
  implicit def developer2ScalaDeveloper(instance: Developer) = new ScalaDeveloper(instance)
  
  /*	Here are the implicit conversion for implicit chain	 */
  implicit def toA(n: Int): A = new A(n)
  implicit def aToB[A1](a: A1)(implicit f: A1 => A): B = new B(a.a, a.a)
  implicit def bToC[B1](b: B1)(implicit f: B1 => B): C = new C(b.a, b.b, b.a + b.b)  
}