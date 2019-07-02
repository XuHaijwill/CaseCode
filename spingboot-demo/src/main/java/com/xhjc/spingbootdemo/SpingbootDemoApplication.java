package com.xhjc.spingbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:bean.xml")
@MapperScan("com.xhjc.spingbootdemo.mapper")
public class SpingbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingbootDemoApplication.class, args);
	}

}
