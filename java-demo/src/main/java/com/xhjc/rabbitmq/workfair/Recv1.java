package com.xhjc.rabbitmq.workfair;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import com.xhjc.rabbitmq.utils.ConnectionUtils;

public class Recv1 {

	public static final String QUEUE_NAME= "test_workfair";

	public static void main(String[] args) throws IOException, TimeoutException {
		// 获取连接
		Connection connection = ConnectionUtils.getConnection();
		// 获取channel
		Channel channel = connection.createChannel();
		// 声明队列
		channel.queueDeclare(QUEUE_NAME, true, false, false, null);

		// 保证一次只分发一个
		channel.basicQos(1);

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {

			String msg = new String(delivery.getBody(), "UTF-8");
			System.out.println(" [x] Received '" + msg + "'");

			try {
				doWork(msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("[1] done ");
				channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
			}
		};
		//公平分发，必须关闭自动应答
		boolean autoAck = false;
		channel.basicConsume(QUEUE_NAME, autoAck, deliverCallback,cancelCallback -> { });
	}
	
	private static void doWork(String msg) throws InterruptedException{
		Thread.sleep(2000);
	}
}
