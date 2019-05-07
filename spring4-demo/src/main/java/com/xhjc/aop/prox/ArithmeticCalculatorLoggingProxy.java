package com.xhjc.aop.prox;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {

	// 要代理的对象
	private ArithmeticCalculator target;

	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		super();
		this.target = target;
	}

	// 返回代理对象
	public ArithmeticCalculator getLoggingProxy() {
		ArithmeticCalculator proxy = null;

		ClassLoader loder = target.getClass().getClassLoader();
		Class[] interfaces = new Class[] { ArithmeticCalculator.class };

		InvocationHandler h = new InvocationHandler() {
			/**
			 * proxy: 代理对象。 一般不使用该对象 method: 正在被调用的方法 args: 调用方法传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				// 打印日志
				System.out.println("[before] The method " + methodName + " begins with " + Arrays.asList(args));

				// 调用目标方法
				Object result = null;

				try {
					// 前置通知
					result = method.invoke(target, args);
					// 返回通知, 可以访问到方法的返回值
				} catch (NullPointerException e) {
					e.printStackTrace();
					// 异常通知, 可以访问到方法出现的异常
				}

				// 后置通知. 因为方法可以能会出异常, 所以访问不到方法的返回值

				// 打印日志
				System.out.println("[after] The method ends with " + result);

				return result;
			}
		};
		
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loder, interfaces, h);

		return proxy;
	}
}