package org.lang.scala.conclusion.oop.method

/**
 * 	This is a stand-alone object to test method
 *  -- Method declaration: use "def" keyword
 *     -- def <methodName>[([parameterName: parameterType, ...])[(parameterName: parameterType, ...)...]][: returnType][ = ][{] methodBody [}]
 *     
 *  Typically, if:
 *  -- There is returnType and returnType is funcType, or there is no returnType
 *  -- MethodBody is in the form of "[{] Unit or ([parameterName[: parameterType], ...]) => [{] funcBody [}] [}]"
 *  Then this method is a METHOD that returns a function
 *  
 *  Practically, when declaring a method, no need to specify return type explicitly unless simple or necessary
 *  -- Since some method type may be complex, e.g., return a function
 *  
 *  Differences between method and functions:
 *  -- Method is not an object, function is an object
 *  -- Method can use generics, function cannot use generics
 *  -- Method can input varargs, function cannot input varargs
 *  -- Method can explicit have "return" keyword, function cannot have "return" keyword
 *  -- Method can be recursive, function cannot be recursive
 *  -- Method can be overloaded, function cannot be overloaded
 * 
 * 	@author VinceYuan
 */
object TestMethod {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testMethodThatReturnsFunc()
  }
  
  /**
   * 	This is a method to test method that returns a function
   */
  private def testMethodThatReturnsFunc(): Unit = {
    
    /*	Test parameterless methods that return regular functions	 */
    println("Here demonstrates parameterless methods that return regular functions:")
    println("parameterlessMethod1_returnFunc: " + parameterlessMethod1_returnFunc())
    println("parameterlessMethod2_returnFunc: " + parameterlessMethod2_returnFunc())
    println("parameterlessMethod3_returnFunc: " + parameterlessMethod3_returnFunc())
    println("parameterlessMethod4_returnFunc: " + parameterlessMethod4_returnFunc())
    println("parameterlessMethod5_returnFunc: " + parameterlessMethod5_returnFunc)
    println("parameterlessMethod6_returnFunc: " + parameterlessMethod6_returnFunc)
    println("parameterlessMethod7_returnFunc: " + parameterlessMethod7_returnFunc)
    println("parameterlessMethod8_returnFunc: " + parameterlessMethod8_returnFunc)
    
    /*	Test parameterless methods that return high-order functions	 */
    println("\nHere demonstrates parameterless methods that return high-order functions:")
    println("parameterlessMethod1_returnHighOrderFunc: " + parameterlessMethod1_returnHighOrderFunc())
    println("parameterlessMethod2_returnHighOrderFunc: " + parameterlessMethod2_returnHighOrderFunc())
    println("parameterlessMethod3_returnHighOrderFunc: " + parameterlessMethod3_returnHighOrderFunc())
    println("parameterlessMethod4_returnHighOrderFunc: " + parameterlessMethod4_returnHighOrderFunc())
    println("parameterlessMethod5_returnHighOrderFunc: " + parameterlessMethod5_returnHighOrderFunc())
    println("parameterlessMethod6_returnHighOrderFunc: " + parameterlessMethod6_returnHighOrderFunc())
    println("parameterlessMethod7_returnHighOrderFunc: " + parameterlessMethod7_returnHighOrderFunc)
    println("parameterlessMethod8_returnHighOrderFunc: " + parameterlessMethod8_returnHighOrderFunc)
    println("parameterlessMethod9_returnHighOrderFunc: " + parameterlessMethod9_returnHighOrderFunc)
    println("parameterlessMethod10_returnHighOrderFunc: " + parameterlessMethod10_returnHighOrderFunc)
    println("parameterlessMethod11_returnHighOrderFunc: " + parameterlessMethod11_returnHighOrderFunc)
    println("parameterlessMethod12_returnHighOrderFunc: " + parameterlessMethod12_returnHighOrderFunc)  
    
    /*	Test parameterless methods that return partial functions	*/
    println("\nHere demonstrates parameterless methods that return partial functions:")
    println("parameterlessMethod1_returnPartialFunc: " + parameterlessMethod1_returnPartialFunc())
    println("parameterlessMethod2_returnPartialFunc: " + parameterlessMethod2_returnPartialFunc())
    println("parameterlessMethod3_returnPartialFunc: " + parameterlessMethod3_returnPartialFunc)
    println("parameterlessMethod4_returnPartialFunc: " + parameterlessMethod4_returnPartialFunc)
    
    /*	Test parameter methods that return regular functions	 */
    println("\nHere demonstrates parameter methods that return regular functions:")
    println("parameterMethod1_returnFunc: " + parameterMethod1_returnFunc(10))
    println("parameterMethod2_returnFunc: " + parameterMethod2_returnFunc(10))
    println("parameterMethod3_returnFunc: " + parameterMethod3_returnFunc(10))
    println("parameterMethod4_returnFunc: " + parameterMethod4_returnFunc(10))
    
    /*	Test parameter methods that return high-order functions	 */
    println("\nHere demonstrates parameter methods that return high-order functions:")
    println("parameterMethod1_returnHighOrderFunc: " + parameterMethod1_returnHighOrderFunc(10))
    println("parameterMethod2_returnHighOrderFunc: " + parameterMethod2_returnHighOrderFunc(10))
    println("parameterMethod3_returnHighOrderFunc: " + parameterMethod3_returnHighOrderFunc(10))
    println("parameterMethod4_returnHighOrderFunc: " + parameterMethod4_returnHighOrderFunc(10))
    println("parameterMethod5_returnHighOrderFunc: " + parameterMethod5_returnHighOrderFunc(10))
    println("parameterMethod6_returnHighOrderFunc: " + parameterMethod6_returnHighOrderFunc(10))
    
    /*	Test parameter methods that return partial functions	*/
    println("\nHere demonstrates parameter methods that return partial functions:")
    println("parameterMethod1_returnPartialFunc: " + parameterMethod1_returnPartialFunc(10))
    println("parameterMethod2_returnPartialFunc: " + parameterMethod2_returnPartialFunc(10))
    println("parameterMethod3_returnPartialFunc: " + parameterMethod3_returnPartialFunc(10))
    println("parameterMethod4_returnPartialFunc: " + parameterMethod4_returnPartialFunc(10))
  }
  
  /**
   * 	Here are the parameterless methods that return regular functions
   *  -- When the method is parameterless, can skip the bracket "()"
   */
  private def parameterlessMethod1_returnFunc() = (x: Int, y: Float, z: Double) => x + y + z
  private def parameterlessMethod2_returnFunc() = {
    (x: Int, y: Float, z: Double) => {
      x + y + z
    }
  }
  private def parameterlessMethod3_returnFunc(): (Int, Float, Double) => Double = (x, y, z) => x + y + z
  private def parameterlessMethod4_returnFunc(): (Int, Float, Double) => Double = {
    (x, y, z) => {
      x + y + z
    }
  }
  private def parameterlessMethod5_returnFunc = (x: Int, y: Float, z: Double) => x + y + z
  private def parameterlessMethod6_returnFunc = {
    (x: Int, y: Float, z: Double) => {
      x + y + z
    }
  }
  private def parameterlessMethod7_returnFunc: (Int, Float, Double) => Double = (x, y, z) => x + y + z
  private def parameterlessMethod8_returnFunc: (Int, Float, Double) => Double = {
    (x, y, z) => {
      x + y + z
    }
  }
  
  /**
   * 	Here are the parameterless methods that return high-order functions
   *  -- When the method is parameterless, can skip the bracket "()"
   */
  private def parameterlessMethod1_returnHighOrderFunc() = (x: Int) => (y: Float) => (z: Double) => x + y + z
  private def parameterlessMethod2_returnHighOrderFunc() = {
    (x: Int) => {
      (y: Float) => {
        (z: Double) =>
        x + y + z
      }
    }
  }
  private def parameterlessMethod3_returnHighOrderFunc() = {
    (x: Int) => {
      val a = x
      (y: Float) => {
        val b = y
        (z: Double) => {
          val c = z
          a + b + c
        }
      }
    }    
  }
  private def parameterlessMethod4_returnHighOrderFunc(): Int => (Float => (Double => Double)) = x => y => z => x + y + z
  private def parameterlessMethod5_returnHighOrderFunc(): Int => (Float => (Double => Double)) = {
    x => {
      y => {
        z => {
          x + y + z
        }
      }
    }
  }
  private def parameterlessMethod6_returnHighOrderFunc(): Int => (Float => (Double => Double)) = {
    (x: Int) => {
      val a = x
      (y: Float) => {
        val b = y
        (z: Double) => {
          val c = z
          a + b + c
        }
      }
    }    
  }
  private def parameterlessMethod7_returnHighOrderFunc = (x: Int) => (y: Float) => (z: Double) => x + y + z
  private def parameterlessMethod8_returnHighOrderFunc = {
    (x: Int) => {
      (y: Float) => {
        (z: Double) =>
        x + y + z
      }
    }
  }
  private def parameterlessMethod9_returnHighOrderFunc = {
    (x: Int) => {
      val a = x
      (y: Float) => {
        val b =y
        (z: Double) => {
          val c = z
          a + b + c
        }
      }
    }    
  }
  private def parameterlessMethod10_returnHighOrderFunc: Int => (Float => (Double => Double)) = x => y => z => x + y + z
  private def parameterlessMethod11_returnHighOrderFunc: Int => (Float => (Double => Double)) = {
    x => {
      y => {
        z => {
          x + y + z
        }
      }
    }
  }
  private def parameterlessMethod12_returnHighOrderFunc: Int => (Float => (Double => Double)) = {
    (x: Int) => {
      val a = x
      (y: Float) => {
        val b = y
        (z: Double) => {
          val c = z
          a + b + c
        }
      }
    }    
  }
  
  /**
   * 	Here are the parameterless methods that return partial functions
   */
  private def parameterlessMethod1_returnPartialFunc(): PartialFunction[Any, Any] = {
    case x: Any => x
  }
  private def parameterlessMethod2_returnPartialFunc() = (x: Any) => {
    x match {
      case x: Any => x
    }
  }
  private def parameterlessMethod3_returnPartialFunc: PartialFunction[Any, Any] = {
    case x: Any => x
  }  
  private def parameterlessMethod4_returnPartialFunc = (x: Any) => {
    x match {
      case x: Any => x
    }
  }
  
  /**
   * 	Here are the parameter methods that return regular functions
   */
  private def parameterMethod1_returnFunc(x: Int) = (y: Float, z: Double) => x + y + z
  private def parameterMethod2_returnFunc(x: Int) = {
    (y: Float, z: Double) => {
      x + y + z
    }
  }
  private def parameterMethod3_returnFunc(x: Int): (Float, Double) => Double = (y, z) => x + y + z
  private def parameterMethod4_returnFunc(x: Int): (Float, Double) => Double = {
    (y, z) => {
      x + y + z
    }
  }
  
  /**
   * 	Here are the parameter methods that return high-order functions
   */
  private def parameterMethod1_returnHighOrderFunc(x: Int) = (y: Float) => (z: Double) => x + y + z
  private def parameterMethod2_returnHighOrderFunc(x: Int) = {
    (y: Float) => {
      (z: Double) =>
      x + y + z
    }
  }
  private def parameterMethod3_returnHighOrderFunc(x: Int) = {
    val a = x
    (y: Float) => {
      val b = y
      (z: Double) => {
        val c = z
        a + b + c
      }
    }   
  }
  private def parameterMethod4_returnHighOrderFunc(x: Int): Float => (Double => Double) = y => z => x + y + z
  private def parameterMethod5_returnHighOrderFunc(x: Int): Float => (Double => Double) = {
    y => {
      z => {
        x + y + z
      }
    }
  }
  private def parameterMethod6_returnHighOrderFunc(x: Int): Float => (Double => Double) = {
    val a = x
    (y: Float) => {
      val b = y
      (z: Double) => {
        val c = z
        a + b + c
      }
    }
  }    

  /**
   * 	Here are the parameter methods that return partial functions
   */
  private def parameterMethod1_returnPartialFunc(x: Int): PartialFunction[Any, Any] = {
    case x: Any => x
  }
  private def parameterMethod2_returnPartialFunc(x: Int) = (x: Any) => {
    x match {
      case x: Any => x
    }
  }
  private def parameterMethod3_returnPartialFunc(x: Int): PartialFunction[Any, Any] = {
    case x: Any => x
  }  
  private def parameterMethod4_returnPartialFunc(x: Int) = (x: Any) => {
    x match {
      case x: Any => x
    }
  }
}