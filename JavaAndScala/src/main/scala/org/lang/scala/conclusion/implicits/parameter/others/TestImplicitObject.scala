package org.lang.scala.conclusion.implicits.parameter.others

case class Mono[T](degree: Int, coeff: T) {
  def Degree: Int = return degree
  def Coeff: T = return coeff
}

class Poly[T](private val terms: List[Mono[T]]) {

  def eval(x: T)(implicit r: Semiring[T]): T = {
    var termlist = terms
    var sum = r.unitA
    var expression = terms
    while(!termlist.isEmpty) {
      val term = expression.head
      val power = r.exponent(x, term.Degree)
      val termval = r.mul(power, term.Coeff)
      sum = r.add(sum, termval)
      termlist = termlist.tail
    }
    return sum
  }
}

trait Semiring[T] {
    def add(x:T, y:T): T
    def mul(x:T, y:T): T
    def exponent(x: T, n:Int): T
    val unitA: T
}

object Semiring {
  implicit object IntSemiring extends Semiring[Int] {
    def add(x: Int, y: Int): Int = x+y
    def mul(x: Int, y: Int): Int = x*y
    def exponent(x: Int, n:Int): Int = if(n==0) 1 else x*exponent(x, n-1)
    val unitA: Int = 0
  }

  implicit object SetSemiring extends Semiring[Set[Int]] {
    def add(x: Set[Int], y: Set[Int]): Set[Int] = x.union(y)
    def mul(x: Set[Int], y: Set[Int]): Set[Int] = x.intersect(y)
    def exponent(x: Set[Int], n: Int): Set[Int] = x
    val unitA: Set[Int] = Set()
  }
}