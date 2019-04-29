package com.xhjc.rabbitmq.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xhjc.rabbitmq.utils.ConnectionUtils;

public class Send {

	public static final String EXCHANGE_NAME ="test_exchange_topic";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		Connection connection = ConnectionUtils.getConnection();
		
		Channel channel = connection.createChannel();
		
		channel.exchangeDeclare(EXCHANGE_NAME, "topic");
		
		String msg = "msg topic test";
		System.out.println("send >>" + msg);
		channel.basicPublish(EXCHANGE_NAME, "item.update", null, msg.getBytes());
		channel.close();
		connection.close();
	}
}
