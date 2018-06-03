package com.java.se.conclusion.reflection.common.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.java.se.conclusion.reflection.common.advice.AfterAdvice;
import com.java.se.conclusion.reflection.common.advice.BeforeAdvice;

/**
 * 	This is a class to implement dynamic proxy pattern
 *  -- Declare necessary interfaces that serve as advice
 *  -- Maintain the references of Object type and declared advice interfaces
 *  -- Declare an explicit constructor to assign the target instance to the Object-typed reference
 *     -- Declare a setter instead to assign the target instance is also feasible
 *        -- Only the target instance needs to be set after dynamic proxy instantiation, which brings one more step and hence not as convenient as using a constructor
 *  -- Declare setters to assign the objects to the advice references
 *  -- Declare and implement a method to create and return the target instance enhanced by advice (*****)
 *  
 * @author VinceYuan
 *
 */
public class DynamicProxy {

	/**
	 * 	Maintain the references of Object type and declared advice interfaces
	 */
	private Object target;
	private BeforeAdvice beforeAdvice;
	private AfterAdvice afterAdvice;
	
	/**
	 * 	Declare an explicit constructor to assign the target instance to the Object-typed reference
	 * @param target
	 */
	public <T> DynamicProxy (T target) {
		this.target = target;
	}

	/**
	 * 	Declare setters to assign the objects to the advice references
	 * @param beforeAdvice
	 */
	public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
		this.beforeAdvice = beforeAdvice;
	}
	public void setAfterAdvice(AfterAdvice afterAdvice) {
		this.afterAdvice = afterAdvice;
	}

	/**
	 * 	Declare and implement a method to create and return the target instance enhanced by advice
	 * 	-- Usually used with reflection
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T createProxy () {
		
		/*	Get the class loader	 */
		ClassLoader classLoader = this.getClass().getClassLoader();
		
		/*	Get the interfaces implemented by the target class	*/
		Class<?>[] interfaces = target.getClass().getInterfaces();
		
		/*	Return the instance created by proxy	*/
		return (T) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				/*	Invoke the before advice if there is any  */
				if (beforeAdvice != null) {
					beforeAdvice.firstBeforeAdvice();
					beforeAdvice.secondBeforeAdvice();
				}
				
				/*	Invoke the target class' method itself	 */
				Object returnResult = method.invoke(target, args);
				
				/*	Invoke the after advice if there is any   */
				if (afterAdvice != null) {
					afterAdvice.firstAfterAdvice();
					afterAdvice.secondAfterAdvice();
				}
				
				/*	Return the return result of target class' method  */
				return returnResult;
			}
		});
	}
}
