package org.lang.scala.algorithm.graph.kruskal

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Queue

import org.lang.scala.algorithm.graph.kruskal.classes.Edge
import org.lang.scala.algorithm.graph.kruskal.classes.Graph
import org.lang.scala.algorithm.graph.kruskal.classes.Vertex

/**
 * 	This is a stand-alone object to test Kruskal algorithm
 *  -- This algorithm is used to find minimum-spanning tree (MST)
 *  -- The weight (or cost) of edges can be negative, 0 or positive
 *  -- This algorithm is a greedy algorithm
 * 
 * 	@author VinceYuan
 */
object Kruskal {
  
  /**
   * 	This is a method to implement Kruskal algorithm
   */
  private def krustal(graph: Graph) = {
  
    /*	Get the information of vertices and edges from graph	*/
    val vertices = graph.vertices
    val edges = graph.edges
    
    /*	Sort the edges, initialize a newEdges to contain minimum-cost edges (or tree branches) and a clusters to contain sets of vertices to predicate if there is a cycle when forming the MST 	*/
    val srtEdges = new Queue[Edge]()
    edges.sortBy { edge => edge.cost }.foreach { edge => srtEdges += edge }
    var newEdges = ListBuffer[Edge]()
    val clusters = ListBuffer[Set[Vertex]]()
    
    /******************************** Core in Kruskal algorithm	**********************************/
    /*	While newEdges (or tree branch) < vertices - 1, find minimum-spanning tree	 */
    def findMinTree(vertices: List[Vertex], srtEdges: Queue[Edge], newEdges: ListBuffer[Edge], clusters: ListBuffer[Set[Vertex]]): ListBuffer[Edge] = {
      // If newEdges < vertices - 1
      if (newEdges.size < vertices.size - 1) {
        // Get the minimum-cost edge and find if each vertex of the edge is contained in a set
        val minEdge = srtEdges.dequeue()
        val bothVertices = minEdge.bothVertices 
        val setIdx1 = bothVertices(0).findSet(clusters)
        val setIdx2 = bothVertices(1).findSet(clusters)
        // If both vertices are not contained in any set
        if (setIdx1 == -1 && setIdx2 == -1) {
          // Add the minimum-cost edge into newEdges (or tree branches)
          newEdges += minEdge
          // Update the clusters
          var vertexSet = Set[Vertex]()
          bothVertices.foreach { vertex => vertexSet = vertexSet + vertex }
          clusters += vertexSet
          // Continue finding MST
          findMinTree(vertices, srtEdges, newEdges, clusters)
        // If there is one vertex contained a set and another one is not 
        } else if (setIdx1 != -1 && setIdx2 == -1) {
          // Add the minimum-cost edge into newEdges (or tree branches)
          newEdges += minEdge
          // Update the clusters
          clusters(setIdx1) += bothVertices(1)
          // Continue finding MST
          findMinTree(vertices, srtEdges, newEdges, clusters)
        } else if (setIdx1 == -1 && setIdx2 != -1) {
          // Add the minimum-cost edge into newEdges (or tree branches)
          newEdges += minEdge
          // Update the clusters
          clusters(setIdx2) += bothVertices(0)
          // Continue finding MST
          findMinTree(vertices, srtEdges, newEdges, clusters)
        // If both vertices are contained in a set respectively, but the sets are different
        } else if (setIdx1 != -1 && setIdx2 != -1 && setIdx1 != setIdx2) {
          // Add the minimum-cost edge into newEdges (or tree branches)
          newEdges += minEdge
          // Update the clusters
          val set1 = clusters(setIdx1)
          val set2 = clusters(setIdx2)
          val newSet = set1.union(set2)
          clusters -= set1
          clusters -= set2
          clusters += newSet
          // Continue finding MST
          findMinTree(vertices, srtEdges, newEdges, clusters)
        // If both vertices are contained in a set respectively, and the sets are the same: setIdx1 != -1 && setIdx2 != -1 && setIdx1 == setIdx2
        } else {
          // Continue finding MST
          findMinTree(vertices, srtEdges, newEdges, clusters)
        } 
      // If newEdges < vertices - 1 is not satisfied, return newEdges (i.e., tree branches)
      } else {
        return newEdges 
      }
    }
    newEdges = findMinTree(vertices, srtEdges, newEdges, clusters)
    /*********************************************************************************************/
    
    /*	Return the computational result	 */
    graph.getResult(clusters, newEdges)
  }
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testKruskal()
  }
  
  /**
   * 	This is a method to test Kruskal algorithm
   */
  private def testKruskal(): Unit = {

    /*	Initialize graph information	*/
    val a = new Vertex("A")
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
    val result = krustal(graph)
    val treeNodes = result._1
    val treeBranches = result._2
    println(treeNodes)
    println(treeBranches)
  }
}