package com.xhjc.rabbitmq.ps;

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

public class Recv1 {

	private final static String QUEUE_NAME = "test_queue_fanout_email";
	private final static String EXCHANGE_NAME = "test_exchange_fanout";

	public static void main(String[] args) throws IOException, TimeoutException {
		// 获取到连接以及mq通道
		Connection connection = ConnectionUtils.getConnection();
		final Channel channel = connection.createChannel();

		// 声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		// 绑定队列到交换机
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

		// 同一时刻服务器只会发一条消息给消费者
		channel.basicQos(1);

		// 定义一个消费者
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
		boolean autoAck = false;
		channel.basicConsume(QUEUE_NAME, autoAck, consumer);

	}
}
