package org.lang.scala.conclusion.datatype.common

class Person(

    var id: String,
    var name: String,
    var age: Int
    
) {
  
  def this() = {
    this(null, null, 0)
  }
  
  override def toString() = {
    s"Person[id=${id}, name=${name}, age=${age}]"
  }
}