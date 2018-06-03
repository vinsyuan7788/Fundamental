package org.lang.scala.algorithm.graph.dijkstra.classes

/**
 * 	This is a stand-alone class to contain edge information
 * 
 * 	@author VinceYuan
 */
class Edge {
  
  /*	Instance variables	*/
  var cost: Double = _
  
  /*	Constructors	*/
  def this(cost: Double) = {
    this()
    this.cost = cost
  }
  
  /*	For readability	 */
  override def toString() = {
    "Edge[cost=" + cost + "]"
  }
}