package com.xhjc.rabbitmq.workfair;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xhjc.rabbitmq.utils.ConnectionUtils;

public class Send {

	public static final String QUEUE_NAME= "test_workfair";
	
	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		
		Connection connection = ConnectionUtils.getConnection();
		
		Channel channel = connection.createChannel();
		
		// @param durable true if we are declaring a durable queue (the queue will survive a server restart)
		channel.queueDeclare(QUEUE_NAME, true, false, false, null);
		
		/**
		 * 每个消费者 发送确认消息之前,消息队列不发送下一个消息到消费者,一次只处理一个消息
		 * 
		 * 限制发送给同一个消费者 不得超过一条消息
		 */
		int prefetchCount = 1;
		channel.basicQos(prefetchCount);
		
		for(int i=0;i < 50;i++){
			String msg = "hello work" + i;
			System.out.println("[WQ] send:" + msg);
			channel.basicPublish("", QUEUE_NAME, null, msg.getBytes("UTF-8"));
			Thread.sleep(20);
		}
		
		channel.close();
		connection.close();		
	}
}
