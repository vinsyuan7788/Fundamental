package org.lang.scala.conclusion.implicits.conversion.polymorphism

import java.util.UUID

import scala.reflect.runtime.universe

import org.lang.scala.conclusion.implicits.common.conversion.classes.Daughter
import org.lang.scala.conclusion.implicits.common.conversion.classes.Daughter.toFamilyMember
import org.lang.scala.conclusion.implicits.common.conversion.classes.Father
import org.lang.scala.conclusion.implicits.common.conversion.classes.Father.toFamilyMember
import org.lang.scala.conclusion.implicits.common.conversion.classes.Mother
import org.lang.scala.conclusion.implicits.common.conversion.classes.Mother.toFamilyMember
import org.lang.scala.conclusion.implicits.common.conversion.classes.ProductManager
import org.lang.scala.conclusion.implicits.common.conversion.classes.ProjectManager
import org.lang.scala.conclusion.implicits.common.conversion.classes.TechniqueManager
import org.lang.scala.conclusion.implicits.common.conversion.predef.PredefForPolymophismOfImplicitConversion.toManager

/**
 * 	This is a stand-alone object to test polymorphism of implicit conversion through ONE common implicit method (or function)
 *  -- The instances of MULTIPLE classes can be converted to the instance of ONE class through ONE common implicit method (or function)
 *     -- This common implicit method will do the implicit conversion for all classes that need to be converted(with or without self implicit conversion)
 *        -- Compiler will search the implicit methods from current scope (or a common scope) in this case
 *        -- No matter with or without self implicit conversion, generics is always needed
 *        -- This way is strongly RECOMMENDED due to high re-usability of the common implicit method 
 *     -- Technically another way is using different implicit methods that are defined in the companion objects (with or without self implicit conversion)
 *        -- Compiler will search the implicit methods from associated type in this case
 *        -- This way is highly NOT Recommended since if there are HUNDREDS of classes that need to be converted, HUNDREDS of implicit methods need to be defined
 *  -- To achieve this effect by proper design, details refer to below classes and objects:
 *     -- ProductManager, ProjectManager, TechniqueManager, ManagerInfo, Manager, PredefForPolymophismOfImplicitConversion
 *  
 * 	@author VinceYuan
 */
object TestPolymorphismOfImplicitConversion {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testPolymorphismOfImplicitConversionFromCurrentScope()
    println()
    testPolymorphismOfImplicitConversionFromAssociatedType()
  }
  
  /**
   * 	This is a method to test polymorphism of implicit conversion from current scope
   */
  private def testPolymorphismOfImplicitConversionFromCurrentScope(): Unit = {

    val vince = new ProductManager(UUID.randomUUID().toString(), "Vince", 27)
    val violet = new ProjectManager(UUID.randomUUID().toString(), "Violet", 25)
    val johnny = new TechniqueManager(UUID.randomUUID().toString(), "Johnny", 29)
    vince.getManagerInfo()
    violet.getManagerInfo()
    johnny.getManagerInfo()
  }
  
  /**
   * 	This is a method to test polymorphism of implicit conversion from associated type
   */
  private def testPolymorphismOfImplicitConversionFromAssociatedType(): Unit = {
    
    val vince = new Father(UUID.randomUUID().toString(), "Vince", 47)
    val violet = new Mother(UUID.randomUUID().toString(), "Violet", 45)
    val kenny = new Daughter(UUID.randomUUID().toString(), "Kenny", 29)
    vince.getFamilyMemberInfo()
    violet.getFamilyMemberInfo()
    kenny.getFamilyMemberInfo()
  }
}