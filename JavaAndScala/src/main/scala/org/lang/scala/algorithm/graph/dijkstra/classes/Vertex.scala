package org.lang.scala.algorithm.graph.dijkstra.classes

/**
 * 	This is a stand-alone class to contain vertex information
 * 
 * 	@author VinceYuan
 */
class Vertex {
  
  /*	Instance variables	*/
  var name: String = _
  var path: Double = _
  var isSource: Boolean = _
  var isVisited: Boolean = _
  var prevVertex: Vertex = _
  var src2Dest: String = _
  
  /*	Constructors	*/
  def this(name: String, isSource: Boolean = false) = {
    this()
    this.name = name
    this.path = if (isSource) 0 else Double.PositiveInfinity
    this.isSource = isSource
    this.isVisited = false
    this.prevVertex = null
    this.src2Dest = null
  }
  
  /*	For readability	 */
  override def toString() = {
    "Vertex[name=" + name + ", path=" + path + ", isSource=" + isSource + ", isVisited=" + isVisited + ", src2Dest=" + src2Dest + "]"
  }
}