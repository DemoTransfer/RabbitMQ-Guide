package com.demotransfer.rabbitMQ.simpleDemo;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class CustomerRabbitConsumerConnection {

    private static final String IP_ADDRESS = "xx.xx.xx.xx";

    private static final int PORT = 5672;

    public static Connection createConsumerConnection() throws IOException, TimeoutException {
        Address[] addresses = new Address[]{new Address(IP_ADDRESS, PORT)};
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        // 这里的连接方式与生产者的demo略有不同，注意辨别区别
        // 创建连接
        Connection connection = connectionFactory.newConnection(addresses);
        return connection;
    }

    public static Channel createChannel() throws IOException, TimeoutException {
        return createConsumerConnection().createChannel();
    }

}
