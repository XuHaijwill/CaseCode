package com.xhjc.ioc.scope;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xhjc.ioc.autowire.Car;

public class AppTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ioc/scop/scop.xml");

		Car car = (Car) ctx.getBean("car");
		Car car2 = (Car) ctx.getBean("car");

		System.out.println(car == car2);
		ctx.close();
	}
}
