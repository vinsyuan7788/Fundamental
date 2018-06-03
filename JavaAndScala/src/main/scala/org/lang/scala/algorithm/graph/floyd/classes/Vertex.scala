package org.lang.scala.algorithm.graph.floyd.classes

/**
 * 	This is a stand-alone class to contain vertex information
 * 
 * 	@author VinceYuan
 */
class Vertex {
  
  /*	Instance variables	*/
  var name: String = _
  
  /*	Constructors	*/
  def this(name: String) = {
    this()
    this.name = name
  }
  
  /*	For readability	 */
  override def toString() = {
    "Vertex[name=" + name + "]"
  }
}