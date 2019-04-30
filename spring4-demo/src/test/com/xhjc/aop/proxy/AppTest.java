package com.xhjc.aop.proxy;

import org.junit.Test;

import com.xhjc.aop.prox.ArithmeticCalculator;
import com.xhjc.aop.prox.ArithmeticCalculatorImpl;
import com.xhjc.aop.prox.ArithmeticCalculatorLoggingProxy;

public class AppTest {

	@Test
	public void test(){
		ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();
		
		arithmeticCalculator = new ArithmeticCalculatorLoggingProxy(arithmeticCalculator).getLoggingProxy();
		
		int result = arithmeticCalculator.add(11, 12);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.div(21, 3);
		System.out.println("result:" + result);
	}
}
