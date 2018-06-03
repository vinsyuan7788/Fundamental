package org.lang.scala.algorithm.graph.prim

import scala.annotation.migration
import scala.collection.mutable.ListBuffer

import org.lang.scala.algorithm.graph.prim.classes.Edge
import org.lang.scala.algorithm.graph.prim.classes.Graph
import org.lang.scala.algorithm.graph.prim.classes.Vertex

/**
 * 	This is a stand-alone object to test Prim algorithm
 *  -- This algorithm is used to find minimum-spanning tree (MST)
 *  -- The weight (or cost) of edges can be negative, 0 or positive
 *  -- This algorithm is a greedy algorithm
 * 
 * 	@author VinceYuan
 */
object Prim {
  
  /**
   * 	This is a method to implement Prim algorithm
   */
  private def prim(graph: Graph) = {
    
    /*	Get the information of vertices and edges from graph	*/
    val vertices = graph.vertices
    val edges = graph.edges
    
    /*	Initialize newVertices to contain vertices that will be visited and newEdges to contain minimum-cost edges (or tree branches)	 */ 
    val source = vertices.filter { vertex => vertex.isSource }.head
    val newVertices = ListBuffer[Vertex]()
    newVertices += source
    var newEdges = List[Edge]()
    
    /********************************* Core in Prim algorithm	************************************/
    /*	While newVertices < vertices, find the minimum-spanning tree	*/
    while (newVertices.length < vertices.length) {
      // Temporary list to contain minimum-cost edges originating from each vertex in newVertices
      var minEdges = List[Edge]()
      // For each vertex in newVertices
      for (i <- 0 until newVertices.length) {
        // Get the current vertex 
        val currVertex = newVertices(i)
        // Get the minimum-cost edge of current vertex
        val minEdge = edges.filter { edge => {
          // One vertex should be currentVertex
          val bool1 = edge.bothVertices.contains(currVertex)
          // Another one should be NOT in (newVertice - currentVertex)
          var bool2 = true
          val remaining = newVertices - currVertex
          val remainingSize = remaining.size
          for (i <- 0 until remainingSize if (remaining.size > 0)) {
            if (edge.bothVertices.contains(remaining(i))) bool2 = false
          }
          bool1 && bool2
        } }.minBy { edge => edge.cost }
        // Add to the temporary list
        minEdges :+= minEdge   
      }
      // Get the minimum-cost edge from the temporary list
      val minEdge = minEdges.minBy { edge => edge.cost }
      // Get the vertex that is not yet contained in newVertices from minimum-cost edge
      val newVertex = minEdge.bothVertices.find { vertex => !newVertices.contains(vertex) }.get
      // Add the vertex and minimum-cost edge into newVertices and newEdges respectively
      newVertices += newVertex
      newEdges :+= minEdge
    }
    /*********************************************************************************************/
    
    /*	Return the computational result	 */
    graph.getResult(newVertices, newEdges)
  }
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testPrim()
  }
  
  /**
   * 	This is a method to test Prim algorithm
   */
  private def testPrim(): Unit = {
    
    /*	Initialize graph information	*/
    val a = new Vertex("A", true)
    val b = new Vertex("B")
    val c = new Vertex("C")
    val d = new Vertex("D")
    val vertices = List(a, b, c, d)
    val ab = new Edge(5, a, b)
    val ac = new Edge(10, a, c)
    val ad = new Edge(15, a, d)
    val bc = new Edge(8, b, c)
    val bd = new Edge(20, b, d)
    val cd = new Edge(3, c, d)
    val edges = List(ab, ac, ad, bc, bd, cd)
    val graph = new Graph(vertices, edges)
    
    /*	Run the algorithm and get result	*/
    val result = prim(graph)
    val treeNodes = result._1
    val treeBranches = result._2
    println(treeNodes)
    println(treeBranches)
  }
}