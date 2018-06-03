package org.lang.scala.algorithm.graph.prim.classes

/**
 * 	This is a stand-alone class to contain vertex information
 * 
 * 	@author VinceYuan
 */
class Vertex {
  
  /*	Instance variables	*/
  var name: String = _
  var isSource: Boolean = _
  
  /*	Constructors	*/
  def this(name: String, isSource: Boolean = false) = {
    this()
    this.name = name
    this.isSource = isSource
  }
  
  /*	For readability	 */
  override def toString() = {
    "Vertex[name=" + name + ", isSource=" + isSource + "]"
  }
}