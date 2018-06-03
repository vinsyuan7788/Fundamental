package org.lang.scala.conclusion.reflection

import java.util.UUID

import scala.reflect.runtime.universe._

import org.lang.scala.conclusion.reflection.annotation.GetClassName
import org.lang.scala.conclusion.reflection.annotation.IsSingleton
import org.lang.scala.conclusion.reflection.bean.Person

/**
 * 	This is a stand-alone object to test reflection mechanism
 * 	-- Reflection in Scala is MIRROR-driven with SYMBOL
 * 
 * 	Reflection model:
 *  -- runtimeMirror(ClassLoader) ---> Runtime Mirror --- reflectClass(ClassSymbol) ---> ClassMirror --- reflectConstructor(Constructor MethodSymbol) ---> Constructor MethodMirror ---> Class Instance
 *                                           |
 *                                           ---------- reflectModule(ModuleSymbol) ---> ModuleMirror ---> Object Instance
 *  																				 |
 *                                           ---- reflect(Class or Object Instance) ---> InstanceMirror --- reflectField(Field TermSymbol) ---> FieldMirror ---> Field getter and setter
 *                                                                                             |
 *                                                                                             -------- reflectMethod(Method MethodSymbol) ---> Method MethodMirror ---> method invocation
 *	Symbol information:
 *  -- All symbol information are contained in type tag: if can obtain the type, then can get these information
 *     -- ClassSymbol:
 *        -- val classSymbol = typeOf[someType].typeSymbol.asClass
 *     -- TermSymbol: 
 *        -- val fieldSymbol = typeOf[someType].decl(TermName(someName)).asTerm 
 *        -- val fieldSymbol = typeOf[someType].member(TermName(someName)).asTerm
 *     -- MethodSymbol: 
 *        -- val constructorSymbol = typeOf[someType].decl(termNames.CONSTRUCTOR).asMethod
 *        -- val constructorSymbol = typeOf[someType].member(termNames.CONSTRUCTOR).asMethod
 *        -- val methodSymbol = typeOf[someType].decl(TermName(someName)).asMethod 
 *        -- val methodSymbol = typeOf[someType].member(TermName(someName)).asMethod
 *        -- val getter = fieldSymbol.getter.asMethod
 *        -- val setter = fieldSymbol.setter.asMethod
 *     -- ModuleSymbol: 
 *        -- val moduleSymbol = typeOf[someType].typeSymbol.companion.asModule 
 * 
 * 	@author VinceYuan
 */
object TestReflectionMechanism {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testReflectionMechanism()
  }
  
  /**
   * 	This is a method to test reflection mechanism
   */
  private def testReflectionMechanism(): Unit = {
    
    println("Runtime type:")
    val pType = typeOf[Person]      // Or typeTag[Person].tpe
    println(pType)
  
    println("\nType-relevant info:")
    val personTypeSymbol = pType.typeSymbol
    val personTypeSymbolType = getRuntimeType(personTypeSymbol)
    val personTypeConstructor = pType.typeConstructor
    val personTypeConstructorType = getRuntimeType(personTypeConstructor)
    val personTypeParameters = pType.typeParams
    val personTypeParametersType = getRuntimeType(personTypeParameters)
    val personTypeArguments = pType.typeArgs
    val personTypeArgumentsType = getRuntimeType(personTypeArguments)
    println(personTypeSymbol)
    println(personTypeSymbolType)
    println(personTypeConstructor)
    println(personTypeConstructorType)
    println(personTypeParameters)
    println(personTypeParametersType)
    println(personTypeArguments)
    println(personTypeArgumentsType)
    
    println("\nRuntime declarations in a type:")
    val decls = pType.decls
    val declsType = getRuntimeType(decls)
    println(decls)
    println(declsType)
    
    println("\nA specific runtime declaration in a type:")
    val constructorDecl = pType.decl(termNames.CONSTRUCTOR)
    val constructorDeclType = getRuntimeType(constructorDecl)
    val constructor = constructorDecl.asMethod
    val constructorType = getRuntimeType(constructor)
    val id_fieldDecl = pType.decl(TermName("id"))
    val id_fieldDeclType = getRuntimeType(id_fieldDecl)
    val id_field = id_fieldDecl.asTerm
    val id_fieldType = getRuntimeType(id_field)
    val name_fieldDecl = pType.decl(TermName("name"))
    val name_fieldDeclType = getRuntimeType(name_fieldDecl)
    val name_field = name_fieldDecl.asTerm
    val name_fieldType = getRuntimeType(name_field)
    val age_fieldDecl = pType.decl(TermName("age"))
    val age_fieldDeclType = getRuntimeType(age_fieldDecl)
    val age_field = age_fieldDecl.asTerm
    val age_fieldType = getRuntimeType(age_field)
    val gender_fieldDecl = pType.decl(TermName("gender"))
    val gender_fieldDeclType = getRuntimeType(gender_fieldDecl)
    val gender_field = gender_fieldDecl.asTerm
    val gender_fieldType = getRuntimeType(gender_field)
    val idGetter_method = id_field.getter.asMethod
    val idGetter_methodType = getRuntimeType(idGetter_method)
    val idSetter_method = id_field.setter.asMethod
    val idSetter_methodType = getRuntimeType(idSetter_method)
    val nameGetter_method = name_field.getter.asMethod
    val nameGetter_methodType = getRuntimeType(nameGetter_method)
    val nameSetter_method = name_field.setter.asMethod
    val nameSetter_methodType = getRuntimeType(nameSetter_method)
    val ageGetter_method = age_field.getter.asMethod
    val ageGetter_methodType = getRuntimeType(ageGetter_method)
    val ageSetter_method = age_field.setter.asMethod
    val ageSetter_methodType = getRuntimeType(ageSetter_method)
    val genderGetter_method = gender_field.getter.asMethod
    val genderGetter_methodType = getRuntimeType(genderGetter_method)
    val genderSetter_method = gender_field.setter.asMethod
    val genderSetter_methodType = getRuntimeType(genderSetter_method)
    val toString_methodDecl = pType.decl(TermName("toString"))
    val toString_methodDeclType = getRuntimeType(toString_methodDecl)
    val toString_method = toString_methodDecl.asMethod
    val toString_methodType = getRuntimeType(toString_method)
    println(constructorDecl)
    println(constructorDeclType)
    println(constructor)
    println(constructorType)
    println(id_fieldDecl)
    println(id_fieldDeclType)
    println(id_field)
    println(id_fieldType)
    println(name_fieldDecl)
    println(name_fieldDeclType)
    println(name_field)
    println(name_fieldType)
    println(age_fieldDecl)
    println(age_fieldDeclType)
    println(age_field)
    println(age_fieldType)
    println(gender_fieldDecl)
    println(gender_fieldDeclType)
    println(gender_field)
    println(gender_fieldType)
    println(idGetter_method)
    println(idGetter_methodType)
    println(idSetter_method)
    println(idSetter_methodType)
    println(nameGetter_method)
    println(nameGetter_methodType)
    println(nameSetter_method)
    println(nameSetter_methodType)
    println(ageGetter_method)
    println(ageGetter_methodType)
    println(ageSetter_method)
    println(ageSetter_methodType)
    println(genderGetter_method)
    println(genderGetter_methodType)
    println(genderSetter_method)
    println(genderSetter_methodType)
    println(toString_methodDecl)
    println(toString_methodDeclType)
    println(toString_method)
    println(toString_methodType)
    
    println("\nRuntime members in a type:")
    val members = pType.members
    val membersType = getRuntimeType(members)
    println(members)
    println(membersType)
    
    println("\nA specific runtime member in a type:")
    val constructorMember = pType.member(termNames.CONSTRUCTOR)
    val constructorMemberType = getRuntimeType(constructorMember)
    val construct = constructorMember.asMethod
    val constructType = getRuntimeType(constructor)
    val id_fieldMember = pType.member(TermName("id"))
    val id_fieldMemberType = getRuntimeType(id_fieldMember)
    val id_fild = id_fieldMember.asTerm
    val id_fildType = getRuntimeType(id_fild)
    val name_fieldMember = pType.member(TermName("name"))
    val name_fieldMemberType = getRuntimeType(name_fieldMember)
    val name_fild = name_fieldMember.asTerm
    val name_fildType = getRuntimeType(name_fild)
    val age_fieldMember = pType.member(TermName("age"))
    val age_fieldMemberType = getRuntimeType(age_fieldMember)
    val age_fild = age_fieldMember.asTerm
    val age_fildType = getRuntimeType(age_fild)
    val gender_fieldMember = pType.member(TermName("gender"))
    val gender_fieldMemberType = getRuntimeType(gender_fieldMember)
    val gender_fild = gender_fieldMember.asTerm
    val gender_fildType = getRuntimeType(gender_fild)
    val idGetter_meth = id_fild.getter.asMethod
    val idGetter_methType = getRuntimeType(idGetter_meth)
    val idSetter_meth = id_fild.setter.asMethod
    val idSetter_methType = getRuntimeType(idSetter_meth)
    val nameGetter_meth = name_fild.getter.asMethod
    val nameGetter_methType = getRuntimeType(nameGetter_meth)
    val nameSetter_meth = name_fild.setter.asMethod
    val nameSetter_methType = getRuntimeType(nameSetter_meth)
    val ageGetter_meth = age_fild.getter.asMethod
    val ageGetter_methType = getRuntimeType(ageGetter_meth)
    val ageSetter_meth = age_fild.setter.asMethod
    val ageSetter_methType = getRuntimeType(ageSetter_meth)
    val genderGetter_meth = gender_fild.getter.asMethod
    val genderGetter_methType = getRuntimeType(genderGetter_meth)
    val genderSetter_meth = gender_fild.setter.asMethod
    val genderSetter_methType = getRuntimeType(genderSetter_meth)
    val toString_methodMember = pType.member(TermName("toString"))
    val toString_methodMemberType = getRuntimeType(toString_methodMember)
    val toString_meth = toString_methodMember.asMethod
    val toString_methType = getRuntimeType(toString_meth)
    println(constructorMember)
    println(constructorMemberType)
    println(construct)
    println(constructType)
    println(id_fieldMember)
    println(id_fieldMemberType)
    println(id_fild)
    println(id_fildType)
    println(name_fieldMember)
    println(name_fieldMemberType)
    println(name_fild)
    println(name_fildType)
    println(age_fieldMember)
    println(age_fieldMemberType)
    println(age_fild)
    println(age_fildType)
    println(gender_fieldMember)
    println(gender_fieldMemberType)
    println(gender_fild)
    println(gender_fildType)
    println(idGetter_meth)
    println(idGetter_methType)
    println(idSetter_meth)
    println(idSetter_methType)
    println(nameGetter_meth)
    println(nameGetter_methType)
    println(nameSetter_meth)
    println(nameSetter_methType)
    println(ageGetter_meth)
    println(ageGetter_methType)
    println(ageSetter_meth)
    println(ageSetter_methType)
    println(genderGetter_meth)
    println(genderGetter_methType)
    println(genderSetter_meth)
    println(genderSetter_methType)
    println(toString_methodMember)
    println(toString_methodMemberType)
    println(toString_meth)
    println(toString_methType)
    
    println("\nIf declaration can have the same effect as member:")
    println(constructor == construct)
    println(constructorType == constructType)
    println(id_field == id_fild)
    println(id_fieldType == id_fildType)
    println(name_field == name_fild)
    println(name_fieldType == name_fildType)
    println(age_field == age_fild)
    println(age_fieldType == age_fildType)
    println(gender_field == gender_fild)
    println(gender_fieldType == gender_fildType)
    println(idGetter_method == idGetter_meth)
    println(idGetter_methodType == idGetter_methType)
    println(idSetter_method == idSetter_meth)
    println(idSetter_methodType == idSetter_methType)
    println(nameGetter_method == nameGetter_meth)
    println(nameGetter_methodType == nameGetter_methType)
    println(nameSetter_method == nameSetter_meth)
    println(nameSetter_methodType == nameSetter_methType)
    println(ageGetter_method == ageGetter_meth)
    println(ageGetter_methodType == ageGetter_methType)
    println(ageSetter_method == ageSetter_meth)
    println(ageSetter_methodType == ageSetter_methType)
    println(genderGetter_method == genderGetter_meth)
    println(genderGetter_methodType == genderGetter_methType)
    println(genderSetter_method == genderSetter_meth)
    println(genderSetter_methodType == genderSetter_methType)
    println(toString_method == toString_meth)
    println(toString_methodType == toString_methType)
    
    println("\nErased type:")
    val erasedType = pType.erasure
    val erasedTypeType = getRuntimeType(erasedType)
    println(erasedType)
    println(erasedTypeType)
    
    println("\nClass and ClassLoader:")
    val clazz = getClass
    val classType = getRuntimeType(clazz)
    val classLoader = clazz.getClassLoader
    val classLoaderType = getRuntimeType(classLoader)
    println(clazz)
    println(classType)
    println(classLoader)
    println(classLoaderType)
    
    println("\nRuntime reflection mirror:")
    val runtimeReflectionMirror = runtimeMirror(classLoader)
    val runtimeReflectionMirrorType = getRuntimeType(runtimeReflectionMirror)
    println(runtimeReflectionMirror)
    println(runtimeReflectionMirrorType)
    
    println("\nClass mirror, constructor mirror:")
    val classSymbol = personTypeSymbol.asClass
    val classMirror = runtimeReflectionMirror.reflectClass(classSymbol)
    val classMirrorType = getRuntimeType(classMirror)
    val constructorMirror = classMirror.reflectConstructor(constructor)
    val constructorMirrorType = getRuntimeType(constructorMirror)
    println(classSymbol)
    println(classMirror)
    println(classMirror.isStatic)
    println(classMirrorType)
    println(constructorMirror)
    println(constructorMirrorType)
    
    println("\nInstantiation from constructor mirror:")
    val person = constructorMirror().asInstanceOf[Person]
    val personType = getRuntimeType(person)
    println(person)
    println(personType)
    
    println("\nInstance mirror, field mirror, method mirror:")
    val instanceMirror = runtimeReflectionMirror.reflect(person)
    val instanceMirrorType = getRuntimeType(instanceMirror)
    val id_fieldMirror = instanceMirror.reflectField(id_field)
    val id_fieldMirrorType = getRuntimeType(id_fieldMirror)
    val name_fieldMirror = instanceMirror.reflectField(name_field)
    val name_fieldMirrorType = getRuntimeType(name_fieldMirror)
    val age_fieldMirror = instanceMirror.reflectField(age_field)
    val age_fieldMirrorType = getRuntimeType(age_fieldMirror)
    val gender_fieldMirror = instanceMirror.reflectField(gender_field)
    val gender_fieldMirrorType = getRuntimeType(gender_fieldMirror)
    val idGetter_methodMirror = instanceMirror.reflectMethod(idGetter_method)
    val idGetter_methodMirrorType = getRuntimeType(idGetter_methodMirror)
    val idSetter_methodMirror = instanceMirror.reflectMethod(idSetter_method)
    val idSetter_methodMirrorType = getRuntimeType(idSetter_methodMirror)
    val nameGetter_methodMirror = instanceMirror.reflectMethod(nameGetter_method)
    val nameGetter_methodMirrorType = getRuntimeType(nameGetter_methodMirror)
    val nameSetter_methodMirror = instanceMirror.reflectMethod(nameSetter_method)
    val nameSetter_methodMirrorType = getRuntimeType(nameSetter_methodMirror)
    val ageGetter_methodMirror = instanceMirror.reflectMethod(ageGetter_method)
    val ageGetter_methodMirrorType = getRuntimeType(ageGetter_methodMirror)
    val ageSetter_methodMirror = instanceMirror.reflectMethod(ageSetter_method)
    val ageSetter_methodMirrorType = getRuntimeType(ageSetter_methodMirror)
    val genderGetter_methodMirror = instanceMirror.reflectMethod(genderGetter_method)
    val genderGetter_methodMirrorType = getRuntimeType(genderGetter_methodMirror)
    val genderSetter_methodMirror = instanceMirror.reflectMethod(genderSetter_method)
    val genderSetter_methodMirrorType = getRuntimeType(genderSetter_methodMirror)
    val toString_methodMirror = instanceMirror.reflectMethod(toString_method)
    val toString_methodMirrorType = getRuntimeType(toString_methodMirror)
    println(instanceMirror)
    println(instanceMirrorType)
    println(id_fieldMirror)
    println(id_fieldMirrorType)
    println(name_fieldMirror)
    println(name_fieldMirrorType)
    println(age_fieldMirror)
    println(age_fieldMirrorType)
    println(gender_fieldMirror)
    println(gender_fieldMirrorType)
    println(idGetter_methodMirror)
    println(idGetter_methodMirrorType)
    println(idSetter_methodMirror)
    println(idSetter_methodMirrorType)
    println(nameGetter_methodMirror)
    println(nameGetter_methodMirrorType)
    println(nameSetter_methodMirror)
    println(nameSetter_methodMirrorType)
    println(ageGetter_methodMirror)
    println(ageGetter_methodMirrorType)
    println(ageSetter_methodMirror)
    println(ageSetter_methodMirrorType)
    println(genderGetter_methodMirror)
    println(genderGetter_methodMirrorType)
    println(genderSetter_methodMirror)
    println(genderSetter_methodMirrorType)
    println(toString_methodMirror)
    println(toString_methodMirrorType)
    
    println("\nField injection through mirror:")
    id_fieldMirror.set(UUID.randomUUID().toString())
    name_fieldMirror.set("Vince")
    age_fieldMirror.set(27)
    gender_fieldMirror.set('M')
    println(id_fieldMirror.get)
    println(name_fieldMirror.get)
    println(age_fieldMirror.get)
    println(gender_fieldMirror.get)
    println(person)
    
    println("\nMethod invocation through mirror:")
    idSetter_methodMirror.apply(UUID.randomUUID().toString())
    nameSetter_methodMirror.apply("Violet")   
    ageSetter_methodMirror.apply(25)
    genderSetter_methodMirror.apply('F')
    println(idGetter_methodMirror.apply())
    println(nameGetter_methodMirror.apply())
    println(ageGetter_methodMirror.apply())
    println(genderGetter_methodMirror.apply())
    println(toString_methodMirror.apply())
    
    println("\nModule mirror:")
    val moduleSymbol = personTypeSymbol.companion.asModule
    val moduleMirror = runtimeReflectionMirror.reflectModule(moduleSymbol)
    val moduleMirrorType = getRuntimeType(moduleMirror)
    println(moduleSymbol)
    println(moduleMirror)
    println(moduleMirror.isStatic)
    println(moduleMirrorType)
    
    println("\nInstantiation from module mirror:")
    val personObj = moduleMirror.instance
    val personObjType = getRuntimeType(personObj)
    println(personObj)
    println(personObjType)
  }

  /**
   * 	Here are the methods regarding reflection
   */
  private def getRuntimeType[T: TypeTag](x: T) = {
//    implicitly[TypeTag[T]].tpe    // Equivalent to "typeOf[T]"
    typeOf[T]      // Shortcut for "typeTag[T].tpe"
  }
}