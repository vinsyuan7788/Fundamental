package org.lang.scala.algorithm.graph.kruskal.classes

import scala.collection.mutable.ListBuffer

class Vertex {
  
  /*	Instance variables	*/
  var name: String = _
  
  /*	Constructors	*/
  def this(name: String) = {
    this()
    this.name = name
  }
  
  /**
   * 	This is a method to find the index of set that contains current vertex from cluster (i.e., a series of sets)
   */
  def findSet(cluster: ListBuffer[Set[Vertex]]): Int = {
    if (cluster.size > 0) {
      val setWithCurrVtx = cluster.filter { set => set.contains(this) }
      if (setWithCurrVtx.size > 0) {
        cluster.indexOf(setWithCurrVtx.head)
      } else {
        -1
      }
    } else {
      -1
    }
  }
  
  /*	For readability	 */
  override def toString() = {
    "Vertex[name=" + name + "]"
  }
}