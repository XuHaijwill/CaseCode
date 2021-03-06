package com.xhjc.aop.annotation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

	@Test
	public void test() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:aop/annotation/spring-aop-annotation.xml");

		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculatorImpl");

		System.out.println(arithmeticCalculator.getClass().getName());

		int result = arithmeticCalculator.add(1, 2);
		System.out.println("result:" + result);

//		result = arithmeticCalculator.div(1000, 10);
//		System.out.println("result:" + result);
	}
}
