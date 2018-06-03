package org.lang.scala.algorithm.graph.floyd

import org.lang.scala.algorithm.graph.floyd.classes.Edge
import org.lang.scala.algorithm.graph.floyd.classes.Graph
import org.lang.scala.algorithm.graph.floyd.classes.Vertex

/**
 * 	This is a stand-alone object to implement Floyd algorithm
 *  -- This algorithm is to search the shortest path of all vertices from any source
 *  -- The weight (or cost) of edge can be negative, 0 or positive
 *  -- But negative-weighted cycle is NOT allowed
 *  -- This algorithm is a DP (Dynamic Programming) algorithm
 * 
 * 	@author VinceYuan
 */
object Floyd {
  
  /**
   * 	This is a method to implement Floyd algorithm
   */
  private def floyd(graph: Graph) = {
    
    /*	Get the information of vertices and edges from graph	*/
    val vertices = graph.vertices
    val edges = graph.edges
    
    /******************************* Core in Floyd algorithm ******************************/
    /*	Initialize the array that contains previous vertex for each vertex	*/
    val size = vertices.size
    var prevs = new Array[Array[Vertex]](size)
    for (i <- 0 until size) {
      var arr = Array[Vertex]()
      vertices.foreach { vertex => arr :+= vertex }
      prevs(i) = arr
    }
    
    /*	Loop to compute the shortest path and update the previous vertex for each vertex	*/
    for (k <- 0 until size; i <- 0 until size; j <- 0 until size) {
      val dist = edges(i)(k).cost + edges(k)(j).cost
      if (dist < edges(i)(j).cost) {
        edges(i)(j).cost = dist
        prevs(i)(j) = prevs(i)(k)
      }
    }
    /**************************************************************************************/
    
    /*	Return the computational result	*/
    graph.getResult(edges, prevs)
  }
  
  /**
   * 	This is a method to implement path construction from source to destination based on Floyd algorithm
   */
  private def floydSrc2Dest(graph: Graph, src: Vertex, dest: Vertex) = {
    
    /*	Get the vertices and previous vertices of each vertex	 */
    val vertices = graph.vertices
    val prevs = graph.prevs
    
    /*	Find the shortest path from source to destination	 */
    var srcIdx = vertices.indexOf(src)
    var destIdx = vertices.indexOf(dest)
    var vertexSet = Set[Vertex]()
    // If srcIdx <= destIdx
    val src2Dest = if (srcIdx <= destIdx) {
      vertexSet = vertexSet + src
      val pathSet = Set(src)
      for (i <- srcIdx until destIdx) {
        vertexSet = vertexSet + prevs(i)(destIdx)
      }
      vertexSet
    // If srcId > destIdx
    } else {
      for (i <- (srcIdx - 1) to destIdx by -1) {
        vertexSet = vertexSet + prevs(i)(srcIdx)
      }
      vertexSet = vertexSet + dest
      vertexSet
    }
    s"From $src to $dest: " + src2Dest.toString()
  }
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testFloyd()
  }
  
  /**
   * 	This is a method to test Floyd algorithm
   */
  private def testFloyd(): Unit = {

    /*	Initialize graph information	*/
    val a = new Vertex("A")
    val b = new Vertex("B")
    val c = new Vertex("C")
    val d = new Vertex("D")
    val vertices = Array(a, b, c, d)
    val ab = new Edge(5)
    val ac = new Edge(10)
    val bc = new Edge(3)
    val bd = new Edge(10)
    val cd = new Edge(5)
    val inf = new Edge(Double.PositiveInfinity)
    val zero = new Edge(0)
    val edges = Array(
        Array(zero, ab, ac, inf),
        Array(ab, zero, bc, bd),
        Array(ac, bc, zero, cd),
        Array(inf, bd, cd, zero))
    val graph = new Graph(vertices, edges)
        
    /*	Run the algorithm and get result	*/
    val shortestPaths = floyd(graph)
    println(shortestPaths)
    val src2Dest1 = floydSrc2Dest(graph, a, a)
    val src2Dest2 = floydSrc2Dest(graph, a, b)
    val src2Dest3 = floydSrc2Dest(graph, a, c)
    val src2Dest4 = floydSrc2Dest(graph, a, d)
    val src2Dest5 = floydSrc2Dest(graph, d, a)
    val src2Dest6 = floydSrc2Dest(graph, d, b)
    val src2Dest7 = floydSrc2Dest(graph, d, c)
    val src2Dest8 = floydSrc2Dest(graph, d, d)
    println(src2Dest1)
    println(src2Dest2)
    println(src2Dest3)
    println(src2Dest4)
    println(src2Dest5)
    println(src2Dest6)
    println(src2Dest7)
    println(src2Dest8)
  }
}