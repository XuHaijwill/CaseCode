package com.xhjc.spingbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@PropertySource(value = {"classpath:person.properties"})
public class HelloController {
	
	@Value("${person.last-name}")
	private String name;
	
	@ResponseBody
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(name);
		return name + " Spring World Hello!";
	}
}
