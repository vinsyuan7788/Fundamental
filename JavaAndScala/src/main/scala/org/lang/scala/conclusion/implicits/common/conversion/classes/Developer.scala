package org.lang.scala.conclusion.implicits.common.conversion.classes

/**
 * 	This is a stand-alone class to test implicit conversion
 * 
 * 	@author VinceYuan
 */
class Developer {
  
  var id: String = _
  var name: String = _
  var gender: Char = _
  
  override def toString() = {
    "Developer[id=" + id + ", name=" + name + ", gender=" + gender + "]"
  }
}

/**
 * 	This is a companion object to test implicit conversion
 * 
 * 	@author VinceYuan
 */
object Developer {
  
  /*	Implicit methods for implicit conversion	 */
  implicit def toScalaDeveloper(developer: Developer) = {
    new ScalaDeveloper(developer)
  }
  implicit val toSparkDeveloper = (developer: Developer) => {
    new SparkDeveloper(developer)
  }
}