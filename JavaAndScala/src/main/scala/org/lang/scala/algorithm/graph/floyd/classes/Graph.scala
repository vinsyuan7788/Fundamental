package org.lang.scala.algorithm.graph.floyd.classes

import scala.collection.mutable.Buffer

/**
 * 	This is a stand-alone class to contain graph information
 * 
 * 	@author VinceYuan
 */
class Graph {
  
  /*	Instance variables	*/
  var vertices: Array[Vertex] = _
  var edges: Array[Array[Edge]] = _
  var prevs: Array[Array[Vertex]] = _

  /*	Constructors	*/
  def this(vertices: Array[Vertex], edges: Array[Array[Edge]]) = {
    this()
    this.vertices = vertices
    this.edges = edges
    this.prevs = null
  }
  
  /**
   * 	This is a method to get the result
   */
  def getResult(edges: Array[Array[Edge]], prevs: Array[Array[Vertex]]) = {
    val edgesBuffArr = edges.toBuffer
    val edgesBuffer = edgesBuffArr.map { arr => arr.toBuffer }
    this.prevs = prevs
    edgesBuffer
  }
}