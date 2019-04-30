package com.xhjc.ioc.collection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xhjc.ioc.bean.DataSources;
import com.xhjc.ioc.collections.NewPerson;
import com.xhjc.ioc.collections.Person;

public class MainTest {

	@Test
	public void testConnection() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:ioc/connection/connection.xml");
		
		Person person = (Person) ctx.getBean("person");		
		System.out.println(person);
		
		NewPerson person2 = (NewPerson) ctx.getBean("newPerson");		
		System.out.println(person2);
		
		DataSources dataSource = (DataSources) ctx.getBean("dataSource");		
		System.out.println(dataSource);
	}
}
