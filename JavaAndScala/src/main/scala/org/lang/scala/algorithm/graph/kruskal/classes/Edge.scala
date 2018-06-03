package org.lang.scala.algorithm.graph.kruskal.classes

class Edge {
  
  /*	Instance variables	*/
  var cost: Double = _
  var bothVertices: List[Vertex] = _
  
  /*	Constructors	*/
  def this(cost: Double, vertex1: Vertex, vertex2: Vertex) = {
    this()
    this.cost = cost
    this.bothVertices = List(vertex1, vertex2)
  }
  
  /*	For readability	 */
  override def toString() = {
    "Edge[name=" + bothVertices(0).name + bothVertices(1).name + ", cost=" + cost + "]"
  }
}