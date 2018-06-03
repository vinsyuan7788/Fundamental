package org.lang.scala.conclusion.implicits.common.parameter.classes

abstract class Calculator[T] {
  
  def add(x: T, y: T): T
}