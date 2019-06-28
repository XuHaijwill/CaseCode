package com.xhjc.spingbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

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

	@RequestMapping("/success")
	public String success(Map<String,Object> map){
		map.put("hello","<h1>Hello</h1>");
		map.put("users", Arrays.asList("zhang3","li4","wang5"));
		return "success";
	}
}
