package com.xhjc.ioc.helloworld;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

	@Test
	public void testHello1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ioc/helloword/hello.xml");
		
		HelloWorld bean = (HelloWorld) context.getBean("helloWord");
		
		System.out.println(bean.toString());
	}
}
