package com.xhjc.rabbitmq.work;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import com.xhjc.rabbitmq.utils.ConnectionUtils;

public class Recv1 {

	private static final String QUEUE_NAME = "test_work_queue";

	public static void main(String[] args) throws IOException, TimeoutException {
		// 获取连接
		Connection connection = ConnectionUtils.getConnection();
		// 获取channel
		Channel channel = connection.createChannel();
		// 声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		//channel.basicQos(1);
		
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			System.out.println(" [x] Received '" + message + "'");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("[1] done ");
			}
		};
		
		channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> { });
	}
}
