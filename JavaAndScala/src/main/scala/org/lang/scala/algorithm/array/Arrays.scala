package org.lang.scala.algorithm.array

import org.lang.scala.common.utils.ExceptionUtils
import scala.reflect.ClassTag

/**
 * 	This is a stand-alone object to implement array operations
 *     
 *  Features of array (for any start index)
 *  -- From size perspective:
 *     -- The tree size (or array) N is (endIdx - startIdx + 1) 
 *  -- From index perspective:
 *     -- For inserting left: 
 *        -- IdxThatNeedShiftRight = (selectedIdx - offSetIdx) or (selectedIdx - offSetIdx - arrLen)
 *        -- IdxAfterShiftRight = (idxThatNeedShiftRight + 1) or (idxThatNeedShiftRight + 1 - arrLen)
 *        -- IdxToInsert = (selectedIdx - actualInsertNum) or (selectedIdx - actualInsertNum + arrLen)
 *     -- For inserting right:
 *        -- IdxThatNeedShiftLeft = (selectedIdx + offSetIdx) or (selectedIdx + offSetIdx - arrLen)
 *        -- IdxAfterShiftLeft = (IdxThatNeedShiftLeft - 1) or (IdxThatNeedShiftLeft - 1 + arrLen)
 *        -- IdxToInsert = (selectedIdx + actualInsertNum) or (selectedIdx + actualInsertNum - arrLen)
 *        
 *  Using theses features can:
 *  -- Handle sub-array in-place
 *  -- etc.
 * 
 * 	@author VinceYuan
 */
object Arrays {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    
    val arr = Array(5, 1, 4, 2, 8, 9, 7, 3)
    println(s"Original array:\n${arr.mkString(", ")}")
    
    swap(arr, 0, 3)
    println(s"\nSwapped array:\n${arr.mkString(", ")}")
    
    insertLeft(arr, 3, 5)
    println(s"\nLeft-inserted array:\n${arr.mkString(", ")}")
    
    insertRight(arr, 6, 5)
    println(s"\nRight-inserted array:\n${arr.mkString(", ")}")
    
    rotateLeft(arr, 6)
    println(s"\nLeft-rotated array:\n${arr.mkString(", ")}")
    
    rotateRight(arr, 6)
    println(s"\nRight-rotated array:\n${arr.mkString(", ")}")
    
    indexToHandleSubArray(arr)
  }
  
  /**
   * 	Here are the methods to swap two elements in an array
   */
  private def swap[T](arr: Array[T], index1: Int, index2: Int): Unit = {
    swap(arr, 0, arr.length - 1, index1, index2)
  }
  private def swap[T](arr: Array[T], startIdx: Int, endIdx: Int, index1: Int, index2: Int): Unit = {
    
    /*	Check sub-array indices	 */
    ExceptionUtils.checkSubArrayIndicesForSwap(arr, startIdx, endIdx, index1, index2)
    
    /*	Do the swap	 */
    val temp = arr(index1)
    arr(index1) = arr(index2)
    arr(index2) = temp
  }
  
  /**
   * 	Here are the methods to insert a selected element to the left or right
   * 	-- Time complexity: O(n)
   */
  private def insertLeft[T](arr: Array[T], selectedIdx: Int, insertNum: Int): Unit = {
    insertLeft(arr, 0, arr.length - 1, selectedIdx, insertNum)
  }
  private def insertLeft[T](arr: Array[T], startIdx: Int, endIdx: Int, selectedIdx: Int, insertNum: Int): Unit = {

    /*	Check sub-array indices	 */
    ExceptionUtils.checkSubArrayIndicesForInsert(arr, startIdx, endIdx, selectedIdx, insertNum)
    
    /*	Insert the selected element to the left	 */
    val arrLen = endIdx - startIdx + 1    
    val actualInsertNum = insertNum % arrLen
    val elemToInsert = arr(selectedIdx)
    if (actualInsertNum > 0) {
      for (offSetIdx <- 1 to actualInsertNum) {
        val idxThatNeedShiftRight = if (selectedIdx - offSetIdx >= startIdx) {
          selectedIdx - offSetIdx
        } else {
          selectedIdx - offSetIdx + arrLen
        }
        val IdxAfterShiftRight = if (idxThatNeedShiftRight + 1 <= endIdx) {
          idxThatNeedShiftRight + 1
        } else {
          idxThatNeedShiftRight + 1 - arrLen
        }
        arr(IdxAfterShiftRight) = arr(idxThatNeedShiftRight)
      }
      val idxToInsert = if (selectedIdx - actualInsertNum >= startIdx) {
        selectedIdx - actualInsertNum
      } else {
        selectedIdx - actualInsertNum + arrLen
      }
      arr(idxToInsert) = elemToInsert
    }
  }
  private def insertRight[T](arr: Array[T], selectedIdx: Int, insertNum: Int): Unit = {
    insertRight(arr, 0, arr.length - 1, selectedIdx, insertNum)
  }
  private def insertRight[T](arr: Array[T], startIdx: Int, endIdx: Int, selectedIdx: Int, insertNum: Int): Unit = {

    /*	Check sub-array indices	 */
    ExceptionUtils.checkSubArrayIndicesForInsert(arr, startIdx, endIdx, selectedIdx, insertNum)
    
    /*	Insert the selected element to the left	 */
    val arrLen = endIdx - startIdx + 1    
    val actualInsertNum = insertNum % arrLen
    val elemToInsert = arr(selectedIdx)
    if (actualInsertNum > 0) {
      for (offSetIdx <- 1 to actualInsertNum) {
        val idxThatNeedShiftLeft = if (selectedIdx + offSetIdx <= endIdx) {
          selectedIdx + offSetIdx
        } else {
          selectedIdx + offSetIdx - arrLen
        }
        val IdxAfterShiftLeft = if (idxThatNeedShiftLeft - 1 >= startIdx) {
          idxThatNeedShiftLeft - 1
        } else {
          idxThatNeedShiftLeft - 1 + arrLen
        }
        arr(IdxAfterShiftLeft) = arr(idxThatNeedShiftLeft)
      }
      val idxToInsert = if (selectedIdx + actualInsertNum <= endIdx) {
        selectedIdx + actualInsertNum
      } else {
        selectedIdx + actualInsertNum - arrLen
      }
      arr(idxToInsert) = elemToInsert
    }
  }
  
  /**
   * 	Here are the methods to rotate the given element to the left or right
   */
  private def rotateLeft[T : ClassTag](arr: Array[T], rotateNum: Int): Unit = {
    rotateLeft(arr, 0, arr.length - 1, rotateNum)
  }
  private def rotateLeft[T : ClassTag](arr: Array[T], startIdx: Int, endIdx: Int, rotateNum: Int): Unit = {
    
    val arrLen = endIdx - startIdx + 1
    val tempArrLen = rotateNum % arrLen
    
    var tempArr = Array[T]()
    for (index <- startIdx to (startIdx + tempArrLen -1)) {
      tempArr = tempArr :+ arr(index)
    }
    
    val remainingArrLen = arrLen - tempArrLen
    for (offSet <- 0 until remainingArrLen) {
      arr(startIdx + offSet) = arr(startIdx + tempArrLen + offSet)
    }
    
    for (index <- 0 until tempArrLen) {
      arr(startIdx + index + remainingArrLen) = tempArr(index)
    }
  }
  private def rotateRight[T : ClassTag](arr: Array[T], rotateNum: Int): Unit = {
    rotateRight(arr, 0, arr.length - 1, rotateNum)
  }
  private def rotateRight[T : ClassTag](arr: Array[T], startIdx: Int, endIdx: Int, rotateNum: Int): Unit = {
    
    val arrLen = endIdx - startIdx + 1
    val actualRotateNum = rotateNum % arrLen
    
    rotateLeft(arr, startIdx, endIdx, arrLen - actualRotateNum)
  }
  
  /**
   * 	This is a method to use index to handle sub-array
   */
  private def indexToHandleSubArray[T : ClassTag](arr: Array[T]): Unit = {
    
    swap(arr, 3, arr.length - 1, 4, 6)                      // Swap elements in the last 5 elements
    println(s"\nArray after swapping sub-array:\n${arr.mkString(", ")}")
    
    insertLeft(arr, 3, arr.length - 1, 5, 3)                // Insert left in the last 5 elements
    println(s"\nArray after left-inserting sub-array:\n${arr.mkString(", ")}")
    
    insertRight(arr, 3, arr.length - 1, arr.length - 1, 3)  // Insert right in the last 5 elements
    println(s"\nArray after right-inserting sub-array:\n${arr.mkString(", ")}")
    
    rotateLeft(arr, 3, arr.length - 1, 3)                   // Rotate left in the last 5 elements
    println(s"\nArray after left-rotated sub-array:\n${arr.mkString(", ")}")
    
    rotateRight(arr, 3, arr.length - 1, 3)                  // Rotate right in the last 5 elements
    println(s"\nArray after right-rotated sub-array:\n${arr.mkString(", ")}")
  }
  
  /**
   * 	This is a method to use index to keep track
   */
  private def indexToKeepTrack(): Unit = {
    
  }
}