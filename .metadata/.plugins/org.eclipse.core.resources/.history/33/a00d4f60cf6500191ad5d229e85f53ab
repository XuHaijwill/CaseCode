package com.xhjc.rabbitmq.utils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtils {

	/**
	 * 获取rabbitmq连接
	 * 
	 * @return
	 * @throws IOException
	 * @throws TimeoutException
	 */
	public static Connection getConnection() throws IOException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();

		factory.setHost("127.0.0.1");
		factory.setPort(5672);
		factory.setVirtualHost("/vhost_mmr");
		factory.setUsername("xuhj");
		factory.setPassword("11111");

		return factory.newConnection();
	}

}
