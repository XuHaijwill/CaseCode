package com.xhjc.rabbitmq.routing;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xhjc.rabbitmq.utils.ConnectionUtils;

public class Send {

	private static final String EXCHANGE_NAME = "test_exchange_direct";

	public static void main(String[] args) throws IOException, TimeoutException {

		Connection connection = ConnectionUtils.getConnection();

		Channel channel = connection.createChannel();

		String routingKey = "info";
		String msg = "Hello rounting Test";

		channel.basicPublish(EXCHANGE_NAME, routingKey, null, msg.getBytes());
		System.out.println("send " + msg);
		channel.close();
		connection.close();

	}
}
