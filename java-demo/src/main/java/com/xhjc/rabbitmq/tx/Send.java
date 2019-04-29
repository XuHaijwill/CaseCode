package com.xhjc.rabbitmq.tx;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xhjc.rabbitmq.utils.ConnectionUtils;

public class Send {

	public static final String QUEUE_NAME = "Simple_QUEUE";

	public static void main(String[] args) throws IOException, TimeoutException {
		Connection connection = ConnectionUtils.getConnection();

		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String msg = "Hello  Simple QUEUE !";

		try {
			//采用事务提交的方式
			channel.txSelect();
			channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
			int result = 1 / 0;
			channel.txCommit();
		} catch (Exception e) {
			channel.txRollback();
			System.out.println("----msg rollabck ");
		} finally {
			System.out.println("---------send msg over:" + msg);
		}
		
		channel.close();
		connection.close();

	}
}
