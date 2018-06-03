package org.lang.scala.algorithm.graph.dijkstra

import org.lang.scala.algorithm.graph.dijkstra.classes.Edge
import org.lang.scala.algorithm.graph.dijkstra.classes.Edge2
import org.lang.scala.algorithm.graph.dijkstra.classes.Graph
import org.lang.scala.algorithm.graph.dijkstra.classes.Graph2
import org.lang.scala.algorithm.graph.dijkstra.classes.Vertex

/**
 * 	This is a stand-alone object to implement Dijkstra algorithm
 *  -- This algorithm is to search the shortest path of all vertices from one source
 *  -- For Dijkstra algorithm, the weight (or cost) of edge MUST be 0 or positive
 *  -- This algorithm is a BFS (Broad First Search) algorithm
 * 
 * 	@author VinceYuan
 */
object Dijkstra {
  
  /**
   * 	This is a method to implement Dijkstra algorithm
   */
  private def dijkstra(graph: Graph): List[Vertex] = {

    /*	Get the information of vertices and edges form graph	*/ 
    val vertices = graph.vertices
    val edges = graph.edges
    
    /*	Compute the shortest path from a source to each vertex	*/
    vertices.foreach { vertex => {
      /**************************** Core in Dijkstra algorithm *********************************/
      // Get all unvisited neighbors of current vertex 
      var unvisitedNeighbors = List[Vertex]()
      val currentVertexIdx = vertices.indexOf(vertex)
      for (i <- 0 until vertices.length) {
        if (i != currentVertexIdx && edges(currentVertexIdx)(i).cost != Double.PositiveInfinity) {
          val neighbor = vertices(i)
          if (!neighbor.isVisited) {
            unvisitedNeighbors :+= neighbor
          }
        }
      }      
      // For each unvisited neighbor of current vertex
      unvisitedNeighbors.foreach { unvisitedNeighbor => {
        val srcIdx = vertices.indexOf(vertex)
        val destIdx = vertices.indexOf(unvisitedNeighbor)
        val edge = edges(srcIdx)(destIdx)
        val distance = vertex.path + edge.cost
        if (distance < unvisitedNeighbor.path) {
          unvisitedNeighbor.path = distance
          unvisitedNeighbor.prevVertex = vertex
        }
      } }
      vertex.isVisited = true
      /*****************************************************************************************/
    } }

    /*	Return the computational result	 */
    graph.getResult(vertices)
  }
  
  /**
   * 	This is a method to implement Dijkstra algorithm with Scala features
   */
  private def dijkstraAdv(graph: Graph2) = {
    
    /*	Get the information of vertices and edges form graph	*/
    val vertices = graph.vertices
    val edges = graph.edges
    
    /*	Compute the shortest path from a source to each vertex	*/
    vertices.foreach { vertex => {
      /**************************** Core in Dijkstra algorithm *********************************/
      // Get all unvisited neighbors of current vertex 
      val edgesWithVtx = edges.filter { edge => edge.bothVertices.contains(vertex) }
      val unvisitedNeighbors = edgesWithVtx.flatMap { edge => edge.bothVertices }.distinct.filter { vertex => vertex.isVisited == false }.toBuffer - vertex
      // For each unvisited neighbor of current vertex
      unvisitedNeighbors.foreach { unvisitedNeighbor => {
        val edge = edgesWithVtx.filter { edge => edge.bothVertices.contains(vertex) && edge.bothVertices.contains(unvisitedNeighbor) }.head
        val distance = vertex.path + edge.cost
        if (distance < unvisitedNeighbor.path) {
          unvisitedNeighbor.path = distance
          unvisitedNeighbor.prevVertex = vertex
        }        
      } }
      vertex.isVisited = true
      /*****************************************************************************************/
    } }
    
    /*	Return the computational result	 */
    graph.getResult(vertices)
  }
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testDijkstra()
    testDijkstraAdv()
  }
  
  /**
   * 	This is a method to test Dijkstra algorithm
   */
  private def testDijkstra(): Unit = {
    
    /*	Initialize graph information	*/
    val a = new Vertex("A", true)
    val b = new Vertex("B")
    val c = new Vertex("C")
    val d = new Vertex("D")
    val vertices = List(a, b, c, d)
    val ab = new Edge(5)
    val ac = new Edge(10)
    val bc = new Edge(3)
    val bd = new Edge(10)
    val cd = new Edge(5)
    val inf = new Edge(Double.PositiveInfinity)
    val edges = Array(
        Array(inf, ab, ac, inf), 
        Array(ab, inf, bc, bd),
        Array(ac, bc, inf, cd),
        Array(inf, bd, cd, inf))
    // For directed graph, only half of edges are needed for computation, e.g., shown as below
//    val edges = Array(
//        Array(inf, ab, ac, inf), 
//        Array(inf, inf, bc, bd),
//        Array(inf, inf, inf, cd),
//        Array(inf, inf, inf, inf))
    val graph = new Graph(vertices, edges)
    
    /*	Run the algorithm and get result	*/
    val verticesWithShortestPaths = dijkstra(graph)
    println(verticesWithShortestPaths)
  }

  /**
   * 	This is a method to test Dijkstra implemented with Scala features
   */
  private def testDijkstraAdv(): Unit = {
    
    /*	Initialize graph information	*/
    val a = new Vertex("A", true)
    val b = new Vertex("B")
    val c = new Vertex("C")
    val d = new Vertex("D")
    val vertices = List(a, b, c, d)
    val ab = new Edge2(5d, a, b)
    val ac = new Edge2(10d, a, c)
    val bc = new Edge2(3d, b, c)
    val bd = new Edge2(10d, b, d)
    val cd = new Edge2(5d, c, d)
    val edges = List(ab, ac, bc, bd, cd)
    val graph = new Graph2(vertices, edges)

    /*	Run the algorithm and get result	*/
    val verticesWithShortestPaths = dijkstraAdv(graph)
    println(verticesWithShortestPaths)
  }
}