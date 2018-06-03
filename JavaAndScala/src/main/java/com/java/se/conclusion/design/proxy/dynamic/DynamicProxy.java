package com.java.se.conclusion.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.java.se.conclusion.design.proxy.dynamic.advice.AfterAdvice;
import com.java.se.conclusion.design.proxy.dynamic.advice.BeforeAdvice;

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
 *  Above steps are not necessary to follow strictly, only if can perform dynamic proxy
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
	 * 	Declare an explicit constructor to assign the target instance and advice
	 * @param target
	 * @param beforeAdvice
	 * @param afterAdvice
	 */
	public <T> DynamicProxy(T target, BeforeAdvice beforeAdvice, AfterAdvice afterAdvice) {
		this.target = target;
		this.beforeAdvice = beforeAdvice;
		this.afterAdvice = afterAdvice;
	}
	
	/**
	 * 	Declare an explicit constructor to assign the target instance to the Object-typed reference
	 * 	-- If need advice when using this constructor, then need to co-operate with below setters
	 * @param target
	 */
	public <T> DynamicProxy(T target) {
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
		
		/*	Instantiate a invocation handler	*/
		InvocationHandler invocationHandler = new InvocationHandler() {
			
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
		};
		
		/*	Return the dynamic proxy instance	*/
		return (T) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
	}
}
