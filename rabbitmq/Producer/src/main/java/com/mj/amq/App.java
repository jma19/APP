package com.mj.amq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare("myExchange", "direct", true);

        String queueName = channel.queueDeclare().getQueue();

        channel.queueBind(queueName, "myExchange", "hello");
        byte[] messageBodyBytes = "Hello, world!".getBytes();
        channel.basicPublish("myExchange", "hello", null, messageBodyBytes);
        channel.close();
    }
}
