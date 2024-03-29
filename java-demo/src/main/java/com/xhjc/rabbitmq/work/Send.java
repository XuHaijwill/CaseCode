package com.xhjc.rabbitmq.work;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xhjc.rabbitmq.utils.ConnectionUtils;

public class Send {

	private static final String QUEUE_NAME = "test_work_queue";
	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		
		Connection connection = ConnectionUtils.getConnection();
		
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		for(int i = 0;i < 50;i++){
			String msg = "hello work" + i;
			System.out.println("[WQ] send:" + msg);
			channel.basicPublish("", QUEUE_NAME, null, msg.getBytes("UTF-8"));
			Thread.sleep(i * 20);
		}
		
		channel.close();
		connection.close();
		
	}
	
}
