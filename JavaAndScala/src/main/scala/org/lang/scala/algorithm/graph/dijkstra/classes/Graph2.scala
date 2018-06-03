package org.lang.scala.algorithm.graph.dijkstra.classes

/**
 * 	This is a stand-alone class to contain graph information
 * 
 * 	@author VinceYuan
 */
class Graph2 {
  
  /*	Instance variables	 */
  var vertices: List[Vertex] = _
  var edges: List[Edge2] = _
  
  /*	Constructors	*/
  def this(vertice: List[Vertex], edges: List[Edge2]) = {
    this()
    this.vertices = vertice
    this.edges = edges
  }
  
  /**
   * 	This is a method to get the computational result of the graph
   */
  def getResult(vertices: List[Vertex]) = {  
    /*	For each vertex	 */
    val newVertices = vertices.map { vertex => {    
      // Get the source of the vertex
      val strBuilder = new StringBuilder(vertex.name)     
      // Concatenate from source to destination
      var prevVertex = vertex.prevVertex
      while (prevVertex != null) {
        strBuilder.append(">--" + prevVertex.name)     // Here use ">--" for convenience of string reverse later
        prevVertex = prevVertex.prevVertex
      } 
      vertex.src2Dest = strBuilder.reverse.toString()  // Reverse the string   
      // Return the vertex
      vertex
    } }  
    /*	Return the vertices	 */
    newVertices
  }
}