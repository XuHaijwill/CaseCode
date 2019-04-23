package com.xhjc.rabbitmq.simple;

import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xhjc.rabbitmq.utils.ConnectionUtils;

public class Send {
	
	//队列名称 
    private final static String QUEUE_NAME = "test_simple_queue"; 
 
    public static void main(String[] argv) throws java.io.IOException, TimeoutException 
    { 
        /**
         * 创建连接连接到MabbitMQ
         */ 
        Connection connection = ConnectionUtils.getConnection();
       
        //创建一个频道 
        Channel channel = connection.createChannel(); 
        //指定一个队列 
        channel.queueDeclare(QUEUE_NAME, false, false, false, null); 
        //发送的消息 
        String message = "hello world simple!"; 
        //往队列中发出一条消息 
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes()); 
        System.out.println("Sent '" + message + "'"); 
        //关闭频道和连接 
        channel.close(); 
        connection.close(); 
     } 
}
