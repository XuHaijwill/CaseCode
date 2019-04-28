package com.xhjc.ioc.spel;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:ioc/spel/spel.xml");

		Address address = (Address) ctx.getBean("address");
		System.out.println(address);

		Car car = (Car) ctx.getBean("car");
		System.out.println(car);

		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
		ctx.close();
	}
}
