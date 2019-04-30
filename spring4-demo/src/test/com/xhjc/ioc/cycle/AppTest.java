package com.xhjc.ioc.cycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:ioc/cycle/cycle.xml");
		
		Car car = (Car) context.getBean("car");
		System.out.println(car);
		context.close();
	}
}
