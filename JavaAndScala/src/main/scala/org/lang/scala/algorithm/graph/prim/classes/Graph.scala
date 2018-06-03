package org.lang.scala.algorithm.graph.prim.classes

import scala.collection.mutable.ListBuffer

/**
 * 	This is a stand-alone class to contain graph information
 * 
 * 	@author VinceYuan
 */
class Graph {
  
  /*	Instance variables	*/
  var vertices: List[Vertex] = _
  var edges: List[Edge] = _
  
  /*	Constructors	*/
  def this(vertices: List[Vertex], edges: List[Edge]) = {
    this()
    this.vertices = vertices
    this.edges = edges
  }
  
  /**
   * 	This is a method to get the computational result
   */
  def getResult(newVertices: ListBuffer[Vertex], newEdges: List[Edge]) = {
    (newVertices, newEdges)
  }
}