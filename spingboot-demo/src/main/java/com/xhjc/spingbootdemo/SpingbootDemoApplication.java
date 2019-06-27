package com.xhjc.spingbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:bean.xml")
public class SpingbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingbootDemoApplication.class, args);
	}

}
