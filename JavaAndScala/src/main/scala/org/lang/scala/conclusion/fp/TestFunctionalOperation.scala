package org.lang.scala.conclusion.fp

import scala.collection.parallel.mutable.ParArray

/**
 * 	This is a stand-alone object to test operation in FP (Functional Programming) style
 *  -- On data processing field, FP encourage to focus on the OPERATION on data
 *     -- NOT focus on manipulating to obtain DATA itself
 *     
 *  Example 1: assuming there is a List(1, 2, 3, 4, 5), now need to double them and put them into a new list
 *  -- Pseudo code in FP style: list.map { element => newList + (element * 2) }
 *     -- DIRECTLY apply the core logic {double them and put into a new list} on the element
 *  -- Pseudo code in OOP style: iterator = list.iterator; while (iterator.hasNext) { newList + (iterator.Next * 2) }
 *     -- Decompose the list to get the ELEMENTS to double them and put them into a new list
 *     
 *  Example 2: assuming there is a List("ABC", 'U', 3, true), now need to print out the 3rd element in this list
 *  -- Pseudo code in FP style: print(list(2))
 *  -- Pseudo code in OOP style: print(list.get(2))
 *  
 *  Functional
 * 
 * 	@author VinceYuan
 */
object TestFunctionalOperation {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testFunctionalOperation()
  }
  
  /**
   * 	This is a method to test functional operation
   */
  private def testFunctionalOperation(): Unit = {
    
    val intArray = Array(1, 2, 3, 4, 5, 6, 7, 8)
    val parArray = ParArray(1, 2, 3, 4, 5, 6, 7, 8)
    
    val toBuffer = intArray.map { x => x + 10 }.toBuffer
    val sum = intArray.map { x => x + 10 }.sum
    val max = intArray.map { x => x + 10 }.max
    val min = intArray.map { x => x + 10 }.min
    val sortBy = intArray.map { x => x + 10 }.sortBy { elem => elem }.toBuffer
    val sortByAndReverse = intArray.map { x => x + 10 }.sortBy { elem => elem }.reverse.toBuffer
    val sortWith_asc= intArray.map { x => x + 10 }.sortWith(_.compareTo(_) < 0).toBuffer
    val sortWith_desc = intArray.map { x => x + 10 }.sortWith(_.compareTo(_) > 0).toBuffer
    val groupByAndMapValues = intArray.map { x => x + 10 }.groupBy { elem => if (elem % 2 == 0) "even" else "odd" }.mapValues { elem => elem.toBuffer }.toBuffer
    val filter = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.toBuffer
    val reduce = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.reduce(_ + _)
    val reduceLeft = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.reduceLeft(_ + _)
    val reduceRight = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.reduceLeft(_ + _)
    val fold_noInit = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.fold(0)(_ + _)
    /*
     * 	Below statement demonstrates "fold" operation is sequential and recursive:
     *  -- ((((0 + 12) + 100) + 14 + 100) + 16 + 100) + 18 + 100 = 460
     */
    val fold_noInit_recursive = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.fold(0)(_ + _ + 100)
    val fold_withInit = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.fold(10)(_ + _)
    /*
     * 	Below statement demonstrates "fold" operation is sequential and recursive:
     *  -- ((((10 + 12) + 100) + 14 + 100) + 16 + 100) + 18 + 100 = 470
     */
    val fold_withInit_recursive = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.fold(10)(_ + _ + 100)
    /*
     * 	Below uncompilable statement demonstrates initial value of "fold" only serves as initial value
     *  -- The initial value of "fold" cannot decide the data type (or the way) to combine elements
     */
//    val fold_withInit_initType = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.fold(List(10))(_ + _)
    val foldLeft_noInit = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.foldLeft(0)(_ + _)
    val foldLeft_noInit_recursive = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.foldLeft(0)(_ + _ + 100)
    val foldLeft_withInit = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.foldLeft(10)(_ + _)
    /*
     * 	Below statement demonstrates "foldLeft" operation is sequential and recursive:
     *  -- (((10 + 12 + 100) + 14 + 100) + 16 + 100) + 18 + 100 = 470
     */
    val foldLeft_withInit_recursive = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.foldLeft(10)(_ + _ + 100)
    /*
     * 	Below statement demonstrates initial value of "foldLeft" can serves as not only initial value
     *  -- The initial value of "foldLeft" can decide the data type (or the way) to combine elements
     *  -- (((List(10) :+ 12) :+ 14) :+ 16) :+ 18 = List(10, 12, 14, 16, 18)
     */
    val foldLeft_withInit_initType = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.foldLeft(List(10))(_ :+ _)
    /*
     * 	Below statement works like this:
     *  -- (((List(10) :+ (12 + 100)) :+ (14 + 100)) :+ (16 + 100)) :+ (18 + 100) = List(10, 112, 114, 116, 118)
     */
    val foldLeft_withInit_initType2 = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.foldLeft(List(10))((list, elem) => list :+ (elem + 100))
    val foldRight_noInit = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.foldRight(0)(_ + _)
    val foldRight_noInit_recursive = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.foldRight(0)(_ + _ + 100)
    val foldRight_withInit = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.foldRight(10)(_ + _)
    /*
     * 	Below statement demonstrates "foldRight" operation is sequential and recursive:
     *  -- 12 + 100 + (14 + 100 + (16 + 100 + (18 + 100 + 10))) = 470
     *  -- More demonstration can be seen below
     */
    val foldRight_withInit_recursive = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.foldRight(10)(_ + _ + 100)
    /*
     * 	Below statement demonstrates initial value of "foldRight" can serves as not only initial value
     *  -- The initial value of "foldRight" can decide the data type (or the way) to combine elements
     *  -- 12 :: (14 :: (16 :: (18 :: List(10)))) = List(12, 14, 16, 18, 10)
     */
    val foldRight_withInit_initType = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.foldRight(List(10))(_ :: _)
    /*
     * 	Below statement works like this:
     * 	-- (12 + 100) :: ((14 + 100) :: ((16 + 100) :: ((18 + 100) :: List(10)))) = List(112, 114, 116, 118, 10)
     */
    val foldRight_withInit_initType2 = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.foldRight(List(10))((elem, list) => (elem + 100) :: list)
    /*
     * 	Below statements demonstrate "aggregate" is the SAME as "foldLeft" in NON-PARALLEL computation
     *  -- Namely "combop" argument of "aggregate" will be ignored in non-parallel computation 
     */
    val aggregate_noInit = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.aggregate(0)(_ + _, _ + _)
    val aggregate_noInit_noCombop = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.aggregate(0)(_ + _, null)
    val aggregate_noInit_recursive = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.aggregate(0)(_ + _ + 100, _ + _)
    val aggregate_noInit_recursive_noCombop = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.aggregate(0)(_ + _ + 100, null)
    val aggregate_withInit = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.aggregate(10)(_ + _, _ + _)
    val aggregate_withInit_noCombop = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.aggregate(10)(_ + _, null)
    val aggregate_withInit_recursive = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.aggregate(10)(_ + _ + 100, _ + _)
    val aggregate_withInit_recursive_noCombop = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.aggregate(10)(_ + _ + 100, null)
    val aggregate_withInit_initType = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.aggregate(List(10))(_ :+ _, _ ++ _)
    val aggregate_withInit_initType_noCombop = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.aggregate(List(10))(_ :+ _, null)
    val aggregate_withInit_initType2 = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.aggregate(List(10))((list, elem) => list :+ (elem + 100), (list1, list2) => list1 ++ list2)
    val aggregate_withInit_initType2_noCombop = intArray.filter { x => x % 2 == 0 }.map { x => x + 10 }.aggregate(List(10))((list, elem) => list :+ (elem + 100), null)
    println(s"toBuffer: $toBuffer")
    println(s"sum: $sum")
    println(s"max: $max")
    println(s"min: $min")
    println(s"sortBy: $sortBy")
    println(s"sortByAndReverse: $sortByAndReverse")
    println(s"sortWith_asc: $sortWith_asc")
    println(s"sortWith_desc: $sortWith_desc")
    println(s"groupByAndMapValues: $groupByAndMapValues")
    println(s"filter: $filter")
    println(s"reduce: $reduce")
    println(s"reduceLeft: $reduceLeft")
    println(s"reduceRight: $reduceRight")
    println(s"fold_noInit: $fold_noInit")
    println(s"fold_noInit_recursive: $fold_noInit_recursive")
    println(s"fold_withInit: $fold_withInit")
    println(s"fold_withInit_recursive: $fold_withInit_recursive")
    println(s"foldLeft_noInit: $foldLeft_noInit")
    println(s"foldLeft_noInit_recursive: $foldLeft_noInit_recursive")
    println(s"foldLeft_withInit: $foldLeft_withInit")
    println(s"foldLeft_withInit_recursive: $foldLeft_withInit_recursive")
    println(s"foldLeft_withInit_initType: $foldLeft_withInit_initType")
    println(s"foldLeft_withInit_initType2: $foldLeft_withInit_initType2")
    println(s"foldRight_noInit: $foldRight_noInit")
    println(s"foldRight_noInit_recursive: $foldRight_noInit_recursive")
    println(s"foldRight_withInit: $foldRight_withInit")
    println(s"foldRight_withInit_recursive: $foldRight_withInit_recursive")
    println(s"foldRight_withInit_initType: $foldRight_withInit_initType")
    println(s"foldRight_withInit_initType2: $foldRight_withInit_initType2")
    println(s"aggregate_noInit: $aggregate_noInit")
    println(s"aggregate_noInit_noCombop: $aggregate_noInit_noCombop")
    println(s"aggregate_noInit_recursive: $aggregate_noInit_recursive")
    println(s"aggregate_noInit_recursive_noCombop: $aggregate_noInit_recursive_noCombop")
    println(s"aggregate_withInit: $aggregate_withInit")
    println(s"aggregate_withInit_noCombop: $aggregate_withInit_noCombop")
    println(s"aggregate_withInit_recursive: $aggregate_withInit_recursive")
    println(s"aggregate_withInit_recursive_noCombop: $aggregate_withInit_recursive_noCombop")
    println(s"aggregate_withInit_initType: $aggregate_withInit_initType")
    println(s"aggregate_withInit_initType_noCombop: $aggregate_withInit_initType_noCombop")
    println(s"aggregate_withInit_initType2: $aggregate_withInit_initType2")
    println(s"aggregate_withInit_initType2_noCombop: $aggregate_withInit_initType2_noCombop")
  }
}