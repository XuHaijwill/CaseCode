package com.xhjc.rabbitmq.tx;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.xhjc.rabbitmq.utils.ConnectionUtils;

public class Recv {
	private static final String QUEUE_NAME = "Simple_QUEUE";

	public static void main(String[] args) throws Exception {
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		DefaultConsumer consumer = new DefaultConsumer(channel) {
			// 获取到达的消息
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Received '" + message + "'");
			}
		};
		// 监听队列
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}

}
