package org.lang.scala.conclusion.reflection

import scala.reflect.runtime.universe._
import scala.reflect._

/**
 * 	This is a stand-alone object to test reflection for type
 *  -- It includes TypeTag and ClassTag
 *     -- TypeTag: a SCALA-friendly API that can interact with other Scala runtime APIs to achieve Scala reflection
 *     -- ClassTag: a JAVA-friendly API that can be used to obtain Java class objects
 *  
 *  TypeTag: it encapsulates the runtime Scala type of some type T, which can be used to
 *  -- Access the runtime type of some type T or from the instance of some type T
 *     -- Even the type T is T[C], namely containing a parameterized type C
 *  -- To instantiate some type T, access the members and annotations of type T, etc.
 *     -- Refer to "TestReflectionMechanism.scala" and other "TestReflectionForXXX.scala"
 *  
 *  ClassTag: it stores the erased Java class T of a given type T, which can be used to
 *  -- Access the runtime class C of some type T or from the instance of some type T
 *     -- Since ClassTag stores parameterized type C
 *  -- Typically instantiate an Array whose element type is unknown at compile-time
 *  
 *  Comparisons between TypeTag and ClassTag:  
 *  -- ClassTag is a weaker special case of TypeTag, since:
 *     -- TypeTag knows both top-level type and argument type
 *     -- ClassTag only knows the top-level class of a type, without necessarily knowing all of its argument types. 
 *        -- This is why this runtime information is enough for runtime Array creation
 *  -- TypeTag returns Scala type (or universe.Type) object while ClassTag returns Java class (or Class[_]) object
 * 
 * 	@author VinceYuan
 */
object TestReflectionForType {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests TypeTag:")
    testTypeTag()
    println("\nHere tests ClassTag:")
    testClassTag()
    println("\nHere tests comparison between TypeTag and ClassTag:")
    testComparisonBetweenTypeTagAndClassTag()
    println("\nHere tests conversion from TypeTag to ClassTag:")
    testConversionFromScalaTypeToJavaClass()
  }
  
  /**
   * 	This is a method to test TypeTag
   */
  private def testTypeTag(): Unit = {
    
    /*	Get runtime type of some type T	 */ 
    var runtimeType = getRuntimeType[Int]
    var runtimeType_deSugar = getRuntimeType_deSugar[Int]
    println(s"The runtime type of type ${typeTag[Int].tpe}:\n${runtimeType}")
    println(s"""If \"getRuntimeType\" and \"getRuntimeType_deSugar\" returns the same:\n${runtimeType.equals(runtimeType_deSugar)}""")    
    runtimeType = getRuntimeType[Boolean]
    runtimeType_deSugar = getRuntimeType_deSugar[Boolean]
    println(s"The runtime type of type ${typeTag[Boolean].tpe}:\n${runtimeType}")
    println(s"""If \"getRuntimeType\" and \"getRuntimeType_deSugar\" returns the same:\n${runtimeType.equals(runtimeType_deSugar)}""")  
    runtimeType = getRuntimeType[List[Char]]
    runtimeType_deSugar = getRuntimeType_deSugar[List[Char]]
    println(s"The runtime type of type ${typeTag[List[Char]].tpe}:\n${runtimeType}")
    println(s"""If \"getRuntimeType\" and \"getRuntimeType_deSugar\" returns the same:\n${runtimeType.equals(runtimeType_deSugar)}""")
    
    /*	Get runtime type from the instance of some type T	 */
    val str = "Hello World"
    runtimeType = getRuntimeType(str)
    runtimeType_deSugar = getRuntimeType_deSugar(str)
    println(s"The runtime type of instance ${str}:\n${runtimeType}")
    println(s"""If \"getRuntimeType\" and \"getRuntimeType_deSugar\" returns the same:\n${runtimeType.equals(runtimeType_deSugar)}""")
    val dbl = 123d
    runtimeType = getRuntimeType(dbl)
    runtimeType_deSugar = getRuntimeType_deSugar(dbl)
    println(s"The runtime type of instance ${dbl}:\n${runtimeType}")
    println(s"""If \"getRuntimeType\" and \"getRuntimeType_deSugar\" returns the same:\n${runtimeType.equals(runtimeType_deSugar)}""")
    val list = List(1f, 2f, 3f, 4f, 5f)
    runtimeType = getRuntimeType(list)
    runtimeType_deSugar = getRuntimeType_deSugar(list)
    println(s"The runtime type of instance ${list}:\n${runtimeType}")
    println(s"""If \"getRuntimeType\" and \"getRuntimeType_deSugar\" returns the same:\n${runtimeType.equals(runtimeType_deSugar)}""")
  }
  
  /**
   * 	This is a method to test ClassTag
   */
  private def testClassTag(): Unit = {

    /*	Get runtime class of some type T	 */ 
    var runtimeClass = getRuntimeClass[Int]
    var runtimeClass_deSugar = getRuntimeClass_deSugar[Int]
    println(s"The runtime class of type ${typeTag[Int].tpe}:\n${runtimeClass}")
    println(s"""If \"getRuntimeClass\" and \"getRuntimeClass_deSugar\" returns the same:\n${runtimeClass.equals(runtimeClass_deSugar)}""")    
    runtimeClass = getRuntimeClass[Boolean]
    runtimeClass_deSugar = getRuntimeClass_deSugar[Boolean]
    println(s"The runtime class of type ${typeTag[Boolean].tpe}:\n${runtimeClass}")
    println(s"""If \"getRuntimeClass\" and \"getRuntimeClass_deSugar\" returns the same:\n${runtimeClass.equals(runtimeClass_deSugar)}""")  
    runtimeClass = getRuntimeClass[List[Char]]
    runtimeClass_deSugar = getRuntimeClass_deSugar[List[Char]]
    println(s"The runtime class of type ${typeTag[List[Char]].tpe}:\n${runtimeClass}")
    println(s"""If \"getRuntimeClass\" and \"getRuntimeClass_deSugar\" returns the same:\n${runtimeClass.equals(runtimeClass_deSugar)}""")
    
    /*	Get runtime class from the instance of some type T	*/
    val str = "Hello World"
    runtimeClass = getRuntimeClass(str)
    runtimeClass_deSugar = getRuntimeClass_deSugar(str)
    println(s"The runtime class of instance ${str}:\n${runtimeClass}")
    println(s"""If \"getRuntimeClass\" and \"getRuntimeClass_deSugar\" returns the same:\n${runtimeClass.equals(runtimeClass_deSugar)}""")
    val dbl = 123d
    runtimeClass = getRuntimeClass(dbl)
    runtimeClass_deSugar = getRuntimeClass_deSugar(dbl)
    println(s"The runtime class of instance ${dbl}:\n${runtimeClass}")
    println(s"""If \"getRuntimeClass\" and \"getRuntimeClass_deSugar\" returns the same:\n${runtimeClass.equals(runtimeClass_deSugar)}""")
    val list = List(1f, 2f, 3f, 4f, 5f)
    runtimeClass = getRuntimeClass(list)
    runtimeClass_deSugar = getRuntimeClass_deSugar(list)
    println(s"The runtime class of instance ${list}:\n${runtimeClass}")
    println(s"""If \"getRuntimeClass\" and \"getRuntimeClass_deSugar\" returns the same:\n${runtimeClass.equals(runtimeClass_deSugar)}""")
        
    /*	Make an array	 */
    val arr = mkArray(1, 2, 3, 4, 5)
    println(s"Array created through ClassTag:\n${arr.mkString(", ")}")
  }
  
  /**
   * 	This is a method to test comparison between TypeTag and ClassTag
   */
  private def testComparisonBetweenTypeTagAndClassTag(): Unit = {
    
    /*	Get runtime Scala type and Java class of some type T	*/ 
    var scalaTypeAndJavaClass = getRuntimeScalaTypeAndJavaClass[Int]
    var scalaTypeAndJavaClass_deSugar = getRuntimeScalaTypeAndJavaClass_deSugar[Int]
    println(s"The runtime Scala type and Java class of type ${typeTag[Int].tpe}:\n${scalaTypeAndJavaClass}")
    println(s"""If \"getRuntimeScalaTypeAndJavaClass\" and \"getRuntimeScalaTypeAndJavaClass_deSugar\" returns the same:\n${scalaTypeAndJavaClass.equals(scalaTypeAndJavaClass_deSugar)}""")
    scalaTypeAndJavaClass = getRuntimeScalaTypeAndJavaClass[List[Boolean]]
    scalaTypeAndJavaClass_deSugar = getRuntimeScalaTypeAndJavaClass_deSugar[List[Boolean]]
    println(s"The runtime Scala type and Java class of type ${typeTag[Boolean].tpe}:\n${scalaTypeAndJavaClass}")
    println(s"""If \"getRuntimeScalaTypeAndJavaClass\" and \"getRuntimeScalaTypeAndJavaClass_deSugar\" returns the same:\n${scalaTypeAndJavaClass.equals(scalaTypeAndJavaClass_deSugar)}""")
    scalaTypeAndJavaClass = getRuntimeScalaTypeAndJavaClass[List[Char]]
    scalaTypeAndJavaClass_deSugar = getRuntimeScalaTypeAndJavaClass_deSugar[List[Char]]
    println(s"The runtime Scala type and Java class of type ${typeTag[List[Char]].tpe}:\n${scalaTypeAndJavaClass}")
    println(s"""If \"getRuntimeScalaTypeAndJavaClass\" and \"getRuntimeScalaTypeAndJavaClass_deSugar\" returns the same:\n${scalaTypeAndJavaClass.equals(scalaTypeAndJavaClass_deSugar)}""")
    
    /*	Get runtime Scala type and Java class from the instance of some type T	*/
    val str = "Hello World"
    scalaTypeAndJavaClass = getRuntimeScalaTypeAndJavaClass(str)
    scalaTypeAndJavaClass_deSugar = getRuntimeScalaTypeAndJavaClass_deSugar(str)
    println(s"The runtime Scala type and Java class of instance ${str}:\n${scalaTypeAndJavaClass}")
    println(s"""If \"getRuntimeScalaTypeAndJavaClass\" and \"getRuntimeScalaTypeAndJavaClass_deSugar\" returns the same:\n${scalaTypeAndJavaClass.equals(scalaTypeAndJavaClass_deSugar)}""")
    val dbl = 123d
    scalaTypeAndJavaClass = getRuntimeScalaTypeAndJavaClass(dbl)
    scalaTypeAndJavaClass_deSugar = getRuntimeScalaTypeAndJavaClass_deSugar(dbl)
    println(s"The runtime Scala type and Java class of instance ${dbl}:\n${scalaTypeAndJavaClass}")
    println(s"""If \"getRuntimeScalaTypeAndJavaClass\" and \"getRuntimeScalaTypeAndJavaClass_deSugar\" returns the same:\n${scalaTypeAndJavaClass.equals(scalaTypeAndJavaClass_deSugar)}""")
    val list = List(1f, 2f, 3f, 4f, 5f)
    scalaTypeAndJavaClass = getRuntimeScalaTypeAndJavaClass(list)
    scalaTypeAndJavaClass_deSugar = getRuntimeScalaTypeAndJavaClass_deSugar(list)
    println(s"The runtime Scala type and Java class of instance ${list}:\n${scalaTypeAndJavaClass}")
    println(s"""If \"getRuntimeScalaTypeAndJavaClass\" and \"getRuntimeScalaTypeAndJavaClass_deSugar\" returns the same:\n${scalaTypeAndJavaClass.equals(scalaTypeAndJavaClass_deSugar)}""")
  }
  
  /**
   * 	This is a method to test conversion between TypeTag and ClassTag
   */
  private def testConversionFromScalaTypeToJavaClass(): Unit = {
    
    /*	Convert some Scala type T to corresponding Java class	 */
    var runtimeType = getRuntimeType[Int]
    var runtimeType_deSugar = getRuntimeType_deSugar[Int]
    var runtimeClass = fromScalaTypeToJavaClass[Int]
    var runtimeClass_deSugar = fromScalaTypeToJavaClass_deSugar[Int]
    println(s"Conversion from TypeTag to ClassTag:\n${runtimeType} ---> ${runtimeClass}")
    println(s"De-sugar conversion:\n${runtimeType_deSugar} ---> ${runtimeClass_deSugar}")
    runtimeType = getRuntimeType[Boolean]
    runtimeType_deSugar = getRuntimeType_deSugar[Boolean]
    runtimeClass = fromScalaTypeToJavaClass[Boolean]
    runtimeClass_deSugar = fromScalaTypeToJavaClass_deSugar[Boolean]
    println(s"Conversion from TypeTag to ClassTag:\n${runtimeType} ---> ${runtimeClass}")
    println(s"De-sugar conversion:\n${runtimeType_deSugar} ---> ${runtimeClass_deSugar}")
    runtimeType = getRuntimeType[List[Char]]
    runtimeType_deSugar = getRuntimeType_deSugar[List[Char]]
    runtimeClass = fromScalaTypeToJavaClass[List[Char]]
    runtimeClass_deSugar = fromScalaTypeToJavaClass_deSugar[List[Char]]
    println(s"Conversion from TypeTag to ClassTag:\n${runtimeType} ---> ${runtimeClass}")
    println(s"De-sugar conversion:\n${runtimeType_deSugar} ---> ${runtimeClass_deSugar}")
    
    /*	Convert the Scala type T of some instance to corresponding Java class	 */
    val str = "Hello World"
    runtimeType = getRuntimeType(str)
    runtimeType_deSugar = getRuntimeType_deSugar(str)
    runtimeClass = fromScalaTypeToJavaClass(str)
    runtimeClass_deSugar = fromScalaTypeToJavaClass_deSugar(str)
    println(s"Conversion from TypeTag to ClassTag:\n${runtimeType} ---> ${runtimeClass}")
    println(s"De-sugar conversion:\n${runtimeType_deSugar} ---> ${runtimeClass_deSugar}")
    val dbl = 123d
    runtimeType = getRuntimeType(dbl)
    runtimeType_deSugar = getRuntimeType_deSugar(dbl)
    runtimeClass = fromScalaTypeToJavaClass(dbl)
    runtimeClass_deSugar = fromScalaTypeToJavaClass_deSugar(dbl)
    println(s"Conversion from TypeTag to ClassTag:\n${runtimeType} ---> ${runtimeClass}")
    println(s"De-sugar conversion:\n${runtimeType_deSugar} ---> ${runtimeClass_deSugar}")
    val list = List(1f, 2f, 3f, 4f, 5f)
    runtimeType = getRuntimeType(list)
    runtimeType_deSugar = getRuntimeType_deSugar(list)
    runtimeClass = fromScalaTypeToJavaClass(list)
    runtimeClass_deSugar = fromScalaTypeToJavaClass_deSugar(list)
    println(s"Conversion from TypeTag to ClassTag:\n${runtimeType} ---> ${runtimeClass}")
    println(s"De-sugar conversion:\n${runtimeType_deSugar} ---> ${runtimeClass_deSugar}")
  }
  
  /*****************************	Methods for TypeTag  ************************************/
  private def getRuntimeType[T : TypeTag] = {
     typeTag[T].tpe    // Or typeOf[T]
  }
  private def getRuntimeType_deSugar[T](implicit ttag: TypeTag[T]) = {
    ttag.tpe           // Or typeOf[T]
  }
  private def getRuntimeType[T : TypeTag](instance: T) = {
    typeTag[T].tpe     // Or typeOf[T]
  }
  private def getRuntimeType_deSugar[T](instance: T)(implicit ttag: TypeTag[T]) = {
    ttag.tpe           // Or typeOf[T]
  }
  
  /*****************************	Methods for ClassTag  ***********************************/
  private def mkArray[C : ClassTag](elems: C*) = {
    Array[C](elems: _*)
  }
  private def mkArray_deSugar[C](elems: C*)(implicit ctag: ClassTag[C]) = {
    Array[C](elems: _*)
  }
  private def getRuntimeClass[C: ClassTag] = {
    classTag[C].runtimeClass
  }
  private def getRuntimeClass_deSugar[C](implicit ctag: ClassTag[C]) = {
    ctag.runtimeClass
  }
  private def getRuntimeClass[C: ClassTag](instance: C) = {
    classTag[C].runtimeClass
  }
  private def getRuntimeClass_deSugar[C](list: C)(implicit ctag: ClassTag[C]) = {
    ctag.runtimeClass
  }
  
  /********************** Methods to compare TypeTag and ClassTag *************************/
  private def getRuntimeScalaTypeAndJavaClass[T : TypeTag: ClassTag] = {
    val scalaType = typeTag[T].tpe      // Or typeOf[T]
    val javaClass = classTag[T].runtimeClass
    (scalaType, javaClass)
  }
  private def getRuntimeScalaTypeAndJavaClass_deSugar[T](implicit ttag: TypeTag[T], ctag: ClassTag[T]) = {
    val scalaType = ttag.tpe            // Or typeOf[T]
    val javaClass = ctag.runtimeClass
    (scalaType, javaClass)
  }
  private def getRuntimeScalaTypeAndJavaClass[T : TypeTag: ClassTag](instance: T) = {
    val scalaType = typeTag[T].tpe      // Or typeOf[T]
    val javaClass = classTag[T].runtimeClass
    (scalaType, javaClass)
  }
  private def getRuntimeScalaTypeAndJavaClass_deSugar[T](instance: T)(implicit ttag: TypeTag[T], ctag: ClassTag[T]) = {
    val scalaType = ttag.tpe            // Or typeOf[T]
    val javaClass = classTag[T].runtimeClass
    (scalaType, javaClass)
  }
  
  /*****	Methods for conversion from TypeTag (or Scala type)to ClassTag (Java class)	*****/
  private def fromScalaTypeToJavaClass[T : TypeTag] = {
    runtimeMirror(getClass.getClassLoader).runtimeClass(typeTag[T].tpe)        // Note: here is NOT equal to "typeOf[T].getClass"
  }
  private def fromScalaTypeToJavaClass_deSugar[T](implicit ttag: TypeTag[T]) = {
    runtimeMirror(getClass.getClassLoader).runtimeClass(ttag.tpe)              // Note: here is NOT equal to "typeOf[T].getClass"
  }
  private def fromScalaTypeToJavaClass[T : TypeTag](instance: T) = {
    runtimeMirror(getClass.getClassLoader).runtimeClass(typeTag[T].tpe)        // Note: here is NOT equal to "typeOf[T].getClass"
  }
  private def fromScalaTypeToJavaClass_deSugar[T](instance: T)(implicit ttag: TypeTag[T]) = {
    runtimeMirror(getClass.getClassLoader).runtimeClass(ttag.tpe)              // Note: here is NOT equal to "typeOf[T].getClass"
  }
}