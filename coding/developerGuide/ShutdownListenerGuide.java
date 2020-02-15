package com.demotransfer.rabbitMQ.developerGuide;

import com.demotransfer.rabbitMQ.simpleDemo.CustomerRabbitConsumerConnection;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ShutdownListenerGuide {

    public static void addShutdownListenerPattern() throws IOException, TimeoutException {
        CustomerRabbitConsumerConnection.createConsumerConnection().addShutdownListener(new ShutdownListener() {
            @Override
            public void shutdownCompleted(ShutdownSignalException e) {
                // do something

                // 当触发ShutdownListener的时候，就可以获取到ShutdownSignalException
                // 就可以获取到ShutdownSignalException包含了关闭的原因
                ShutdownListenerGuide.shutdownCompleted(e);
            }
        });
    }
    
    public static void shutdownCompleted(ShutdownSignalException cause) {
        if (cause.isHardError()) {
            Connection connection = (Connection) cause.getReference();
            if (!cause.isInitiatedByApplication()) {
                Method reason = cause.getReason();
                // do something
            }
        } else {
            Channel channel = (Channel) cause.getReference();
            // do something
        }

    }

}
