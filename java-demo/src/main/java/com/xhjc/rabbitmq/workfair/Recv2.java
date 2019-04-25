package com.xhjc.rabbitmq.workfair;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.xhjc.rabbitmq.utils.ConnectionUtils;

public class Recv2 {

	public static final String QUEUE_NAME = "test_workfair";

	public static void main(String[] args) throws IOException, TimeoutException {
		// 获取连接
		Connection connection = ConnectionUtils.getConnection();
		// 获取channel
		Channel channel = connection.createChannel();
		// 声明队列
		channel.queueDeclare(QUEUE_NAME, true, false, false, null);

		// 保证一次只分发一个
		channel.basicQos(1);

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");

				System.out.println(" [x] Received '" + message + "'");
				System.out.println(" [x] Proccessing... at " + new Date().toLocaleString());
				try {

					Thread.sleep(1000);
				} catch (InterruptedException e) {
				} finally {
					System.out.println(" [x] Done! at " + new Date().toLocaleString());
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			}
		};

		boolean autoAck = false; // 关闭自动 确认
		channel.basicConsume(QUEUE_NAME, autoAck, consumer);

		/*
		 * DeliverCallback deliverCallback = (consumerTag, delivery) -> {
		 * 
		 * String msg = new String(delivery.getBody(), "UTF-8");
		 * System.out.println(" [x] Received '" + msg + "'");
		 * 
		 * try { Thread.sleep(1000);
		 * 
		 * } catch (InterruptedException e) { e.printStackTrace(); } finally {
		 * System.out.println("[1] done ");
		 * channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false); }
		 * };
		 */
		// 公平分发，必须关闭自动应答
		// boolean autoAck = false;
		// channel.basicConsume(QUEUE_NAME, autoAck, deliverCallback,
		// cancelCallback -> {
		// });
	}

}
