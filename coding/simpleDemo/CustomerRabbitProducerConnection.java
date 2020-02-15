package com.demotransfer.rabbitMQ.simpleDemo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class CustomerRabbitProducerConnection {

    private static final String IP_ADDRESS = "xx.xx.xx.xx";

    /**
     * RabbitMQ服务端默认端口号为5672
     **/
    private static final int PORT = 5672;

    public static Connection createProducerConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(IP_ADDRESS);
        connectionFactory.setPort(PORT);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        // 创建连接
       return connectionFactory.newConnection();
    }

    public static Channel createProducterChanner() throws IOException, TimeoutException {
        return createProducerConnection().createChannel();
    }

}
