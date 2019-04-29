package com.xhjc.rabbitmq.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	//5.7.0已经调整 请参考官方说明
	public static void main(String[] args) throws InterruptedException {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:rabbitmq/context.xml");
		//RabbitMQ模板
		RabbitTemplate template = context.getBean(RabbitTemplate.class);
		
		template.convertAndSend("Hello Word!");
		Thread.sleep(1000);// 休眠1秒
		context.destroy();; //容器销毁
	
	}
}
