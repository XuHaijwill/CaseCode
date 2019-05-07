package com.xhjc.aop.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

	@Test
	public void test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:aop/xml/applicationContext-xml.xml");
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		
		System.out.println(arithmeticCalculator.getClass().getName());
		
		int result = arithmeticCalculator.add(1, 2);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.div(1000, 1);
		System.out.println("result:" + result);
	}
}
