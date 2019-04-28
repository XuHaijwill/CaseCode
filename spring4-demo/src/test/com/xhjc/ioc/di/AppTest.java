package com.xhjc.ioc.di;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:ioc/di/di.xml");

		UserService userService = (UserService) ctx.getBean("userService");
		userService.add();
		ctx.close();
	}
}
