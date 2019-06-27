package com.xhjc.spingbootdemo;

import com.xhjc.spingbootdemo.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
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

}
