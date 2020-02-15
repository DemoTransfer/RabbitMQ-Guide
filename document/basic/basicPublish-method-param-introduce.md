看在前面
====

* 基于rabbit的amqp-client源码

```java
void basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body) throws IOException;

void basicPublish(String exchange, String routingKey, boolean mandatory, BasicProperties props, byte[] body) throws IOException;

void basicPublish(String exchange, String routingKey, boolean mandatory, boolean immediate, BasicProperties props, byte[] body) throws IOException;
```

mandatory和immediate
====

mandatory和immediate是AMQP协议中basic.publish方法中的两个标识位，它们都有当消息传递过程中不可达目的地时将消息返回给生产者的功能。对于刚开始接触RabbitMQ的朋友特别容易被这两个参数搞混，这里博主整理了写资料，简单讲解下这两个标识位。

mandatory
当mandatory标志位设置为true时，如果exchange根据自身类型和消息routeKey无法找到一个符合条件的queue，那么会调用basic.return方法将消息返回给生产者（Basic.Return + Content-Header + Content-Body）；当mandatory设置为false时，出现上述情形broker会直接将消息扔掉。

immediate
当immediate标志位设置为true时，如果exchange在将消息路由到queue(s)时发现对于的queue上么有消费者，那么这条消息不会放入队列中。当与消息routeKey关联的所有queue（一个或者多个）都没有消费者时，该消息会通过basic.return方法返还给生产者。

概括来说，mandatory标志告诉服务器至少将该消息route到一个队列中，否则将消息返还给生产者；immediate标志告诉服务器如果该消息关联的queue上有消费者，则马上将消息投递给它，如果所有queue都没有消费者，直接把消息返还给生产者，不用将消息入队列等待消费者了。

其余参数
====

exchange:交换机名称

routingkey:路由键

props:消息属性字段，比如消息头部信息等等

body:消息主体部分
