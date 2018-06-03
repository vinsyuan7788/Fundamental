package org.lang.scala.algorithm.graph.kruskal.classes

import scala.collection.mutable.ListBuffer

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
  def getResult(clusters: ListBuffer[Set[Vertex]], newEdges: ListBuffer[Edge]) = {
    (clusters, newEdges)
  }
}