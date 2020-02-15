package com.demotransfer.rabbitMQ.developerGuide;

import com.demotransfer.rabbitMQ.simpleDemo.CustomerRabbitConsumerConnection;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerMessageGuide {

    /**
     * 基于推(push)模式消费消息
     * @throws IOException
     * @throws TimeoutException
     */
    public static void consumerMessagePattern_1() throws IOException, TimeoutException {
        final Channel channel = CustomerRabbitConsumerConnection.createChannel();
        boolean autoAck = false;
        channel.basicQos(64);
        channel.basicConsume("QUEUE_NAME", autoAck, "myConsumerTag", new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String routingKey = envelope.getRoutingKey();
                String contentType = properties.getContentType();
                long deliveryTag = envelope.getDeliveryTag();

                // process the message components here...

                channel.basicAck(deliveryTag, false);
             }
        });
    }

    /**
     * 基于拉(get)模式消息消息
     * @throws IOException
     * @throws TimeoutException
     */
    public static void consumerMessagePattern_2() throws IOException, TimeoutException {
        final Channel channel = CustomerRabbitConsumerConnection.createChannel();
        GetResponse response = channel.basicGet("QUEUE_NAME", false);
        System.out.println(new String(response.getBody()));
        channel.basicAck(response.getEnvelope().getDeliveryTag(), false);
    }

}
