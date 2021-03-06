package com.xhjc.rabbitmq.simple;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.ShutdownSignalException;
import com.xhjc.rabbitmq.utils.ConnectionUtils;

public class Recv {

	private static final String QUEUE_NAME = "test_simple_queue";

	public static void main(String[] args) throws IOException, TimeoutException, ShutdownSignalException,
			ConsumerCancelledException, InterruptedException {
		System.out.println("strat--->");
		// 获取连接
		Connection connection = ConnectionUtils.getConnection();

		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			System.out.println(" [x] Received '" + message + "'");
		};
		
		
		
//		channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
//		});
		
		channel.basicConsume(QUEUE_NAME, true, deliverCallback, new CancelCallback() {
			
			@Override
			public void handle(String consumerTag) throws IOException {
				System.out.println("结束-->");
			}
		});
	}

}
