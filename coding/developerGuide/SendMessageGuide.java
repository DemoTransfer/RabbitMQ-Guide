package com.demotransfer.rabbitMQ.developerGuide;

import com.demotransfer.rabbitMQ.simpleDemo.CustomerRabbitProducerConnection;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class SendMessageGuide {

    public static void sendMessagePattern_1() throws IOException, TimeoutException {
        String message = "hello world";
        CustomerRabbitProducerConnection.createProducterChanner().basicPublish("exchangeName",
                "routingKey", null, message.getBytes());
    }

    public static void sendMessagePattern_2() throws IOException, TimeoutException {
        String message = "hello world";
        CustomerRabbitProducerConnection.createProducterChanner().basicPublish("exchangeName",
                "routingKey", true, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
    }

    /**
     * 发送一条消息：投递模式设置未2，消息会持久化到服务器中，消息的优先级为1，content-type为text/plain
     * @throws IOException
     * @throws TimeoutException
     */
    public static void sendMessagePattern_3() throws IOException, TimeoutException {
        String message = "hello world";
        CustomerRabbitProducerConnection.createProducterChanner().basicPublish("exchangerName", "routingKey",
                new AMQP.BasicProperties.Builder().contentType("text/plain").deliveryMode(2).priority(1).userId(
                        "hidden").build(), message.getBytes());
    }

    /**
     * 发送一条带有headers的消息
     * @throws IOException
     * @throws TimeoutException
     */
    public static void sendMessagePattern_4() throws IOException, TimeoutException {
        String message = "hello world";
        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put("localtion", "here");
        headers.put("time", "today");
        CustomerRabbitProducerConnection.createProducterChanner().basicPublish("exchangeName", "routingKey",
                new AMQP.BasicProperties.Builder().headers(headers).build(), message.getBytes());
    }

    /**
     * 发送一条带有过期时间的消息
     * @throws IOException
     * @throws TimeoutException
     */
    public static void sendMessagePattern_5() throws IOException, TimeoutException {
        String message = "hello world";
        CustomerRabbitProducerConnection.createProducterChanner().basicPublish("exchangeName", "routingKey",
                new AMQP.BasicProperties.Builder().expiration("60000").build(), message.getBytes());
    }

}
