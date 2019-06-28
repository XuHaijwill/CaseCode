package com.xhjc.spingbootdemo;

import com.xhjc.spingbootdemo.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpingbootDemoApplicationTests {

	@Autowired
	Person person;

	@Autowired
	ApplicationContext ioc;

	@Test
	public void testHelloService(){
		boolean b = ioc.containsBean("HelloService");
		boolean c = ioc.containsBean("helloService01");

		System.out.println(b);
		System.out.println(c);
	}
	@Test
	public void contextLoads() {
		System.out.println(person);
	}

	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void loggerTest(){
		//日志的级别
		//从低到高
		//可以调整输出的日志级别；日志就只会在这个级别以后的高级别生效
		logger.trace("这是trace日志");
		logger.debug("这是debug信息");
		//SpringBoot默认给的是info级别，如果没指定就是默认的root级别
		logger.info("这是info日志");
		logger.warn("这是warn信息");
		logger.error("这是Error信息");
	}

}
