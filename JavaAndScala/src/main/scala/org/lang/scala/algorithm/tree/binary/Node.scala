package org.lang.scala.algorithm.tree.binary

/**
 * 	This is a stand-alone class to define nodes for binary trees
 * 
 * 	@author VinceYuan
 */
class Node[T] {
 
  /*	Necessary variables	 */
  var name: String = _
  var value: T = _
  private var _index: Int = _
  private var _parent: Node[T] = _
  private var _leftChild: Node[T] = _
  private var _rightChild: Node[T] = _
  private var _status: String = _
  
  /*	Auxiliary constructors	 */
  def this(name: String, value: T) = {
    this()
    this.name = name
    this._index = 0
    this.value = value
    this._parent = null
    this._status = "active"
  }
  def this(name: String, value: T, parent: Node[T], isLeftChildOfParent: Boolean) = {
    this(name, value)
    this._parent = parent
    if (isLeftChildOfParent == true) {
      this._index = this.parent.index * 2 + 1
      this.parent._leftChild = this
    } else {
      this._index = this.parent.index * 2 + 2
      this.parent._rightChild = this
    }
  }
  
  /*	Here are the methods as public getters	*/
  def index = _index
  def parent = _parent
  def leftChild = _leftChild
  def rightChild = _rightChild
  def status = _status
  def isRoot = if (parent == null) true else false
  
  /*	For readability	 */
  override def toString() = {
    // If the node is an isolated node
    if (parent == null && leftChild == null && rightChild == null) {
      s"Node[name=${name}, value=${value}, index=${index}, isRoot=${isRoot}, status=${status}]"
    // If the node is a root node
    } else if (parent == null && (leftChild != null || rightChild != null)) {
      s"Node[name=${name}, value=${value}, index=${index}, leftChild=${leftChild.name}, rightChild=${rightChild.name}, isRoot=${isRoot}, status=${status}]" 
    // If the node is a leaf node with children
    } else if (parent != null && (leftChild != null || rightChild != null)){
      s"Node[name=${name}, value=${value}, index=${index}, parent=${parent.name}, leftChild=${leftChild.name}, rightChild=${rightChild.name}, isRoot=${isRoot}, status=${status}]" 
    // If the node is a leaf node without children
    } else {
      s"Node[name=${name}, value=${value}, index=${index}, parent=${parent.name}, isRoot=${isRoot}, status=${status}]" 
    }
  }
}