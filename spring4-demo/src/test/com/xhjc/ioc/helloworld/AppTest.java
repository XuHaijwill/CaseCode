package com.xhjc.ioc.helloworld;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

	@Test
	public void testHello1() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:ioc/helloword/hello.xml");

		HelloWorld bean = (HelloWorld) context.getBean("helloWord");

		System.out.println(bean.toString());

		HelloWorld bean2 = (HelloWorld) context.getBean("helloWord2");

		System.out.println(bean2.getUser());
		
		
		HelloWorld bean3 = (HelloWorld) context.getBean("helloWord3");

		System.out.println(bean3.getUser());
		
		Car car = (Car)context.getBean("car");
		System.out.println(car);
		
		Car car2 = (Car)context.getBean("car2");
		System.out.println(car2);
		context.close();
		
		
		User user = (User)context.getBean("user");
		System.out.println(user);
		
		User user2 = (User)context.getBean("user2");
		System.out.println(user2);
		
		User user3 = (User)context.getBean("user3");
		System.out.println(user3);
		
		User user4 = (User)context.getBean("user4");
		System.out.println(user4);
		
		User user6 = (User)context.getBean("user6");
		System.out.println(user6);
	}
}
