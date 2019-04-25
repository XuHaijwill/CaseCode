package com.xhjc.rabbitmq.routing;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.xhjc.rabbitmq.utils.ConnectionUtils;

public class Recv2 {

	private static final String EXCHANGE_NAME = "test_exchange_direct";
	private static final String QUEUE_NAME = "test_queue_direct_1";

	public static void main(String[] args) throws IOException, TimeoutException {
		Connection connection = ConnectionUtils.getConnection();
		final Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "info");

		channel.basicQos(1);

		Consumer consumer = new DefaultConsumer(channel) {

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				
				String msg = new String(body,"UTF-8");
				System.out.println("[2] Recv msg" + msg);
				
				try {
					doWork();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					System.out.println("[2] done ");
					channel.basicAck(envelope.getDeliveryTag(), false);
				}

			}
		};
		
		boolean autoAck = false;
		channel.basicConsume(QUEUE_NAME, autoAck, consumer);

	}
	
	public static void doWork() throws InterruptedException{
		Thread.sleep(1000);
	}
}
