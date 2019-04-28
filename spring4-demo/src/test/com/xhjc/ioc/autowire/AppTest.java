package com.xhjc.ioc.autowire;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:ioc/autowire/autowire.xml");
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
	}
}
