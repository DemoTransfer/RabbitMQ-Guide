RabbitMQGuide
=====

* 知识点来源：来源于<a href="https://blog.csdn.net/u013256816/category_9268265.html">朱小厮的博客：消息中间件博客专栏</a>
* RabbitMQ部署信息：基于腾讯云服务器安装RabbitMQ服务
    * <a href="https://blog.csdn.net/weixin_44146379/article/details/103742720">腾讯云服务器安装RabbitMQ</a>
* 推荐文章链接
    * <a href="https://github.com/doocs/advanced-java">高并发架构：消息队列</a>
* <a href="https://github.com/rabbitmq">rabbitmq-github传送门</a>
    
目录
====

工具准备
------

* <a href="https://blog.csdn.net/weixin_44146379/article/details/103742720">安装ErLang和RabbitMQ</a>
* idea编译器

知识点扫盲
------

* <a href="https://github.com/DemoTransfer/RabbitMQGuide/blob/master/document/basic/what-mq.md">什么是消息队列</a>
* <a href="https://github.com/DemoTransfer/RabbitMQGuide/blob/master/document/basic/why-mq.md">为什么使用消息队列？消息队列有什么优点和缺点？Kafka、ActiveMQ、RabbitMQ、RocketMQ 都有什么优点和缺点？</a>
* <a href="https://github.com/DemoTransfer/RabbitMQ-Guide/blob/master/document/basic/%E6%B5%85%E8%B0%88%E6%B6%88%E6%81%AF%E9%98%9F%E5%88%97%E5%8F%8A%E5%B8%B8%E8%A7%81%E7%9A%84%E6%B6%88%E6%81%AF%E4%B8%AD%E9%97%B4%E4%BB%B6.md">浅谈消息队列及常见的消息中间件</a>
* <a href="https://github.com/DemoTransfer/RabbitMQGuide/blob/master/document/basic/how-to-ensure-high-availability-of-message-queues.md">如何保证消息队列的高可用？</a>
* <a href="https://github.com/DemoTransfer/RabbitMQGuide/blob/master/document/basic/how-to-ensure-that-messages-are-not-repeatedly-consumed.md">如何保证消息不被重复消费？（如何保证消息消费的幂等性）</a>
* <a href="https://github.com/DemoTransfer/RabbitMQGuide/blob/master/document/basic/how-to-ensure-the-reliable-transmission-of-messages.md">如何保证消息的可靠性传输？（如何处理消息丢失的问题）</a>
* <a href="https://github.com/DemoTransfer/RabbitMQGuide/blob/master/document/basic/how-to-ensure-the-order-of-messages.md">如何保证消息的顺序性？</a>
* <a href="https://github.com/DemoTransfer/RabbitMQGuide/blob/master/document/basic/mq-time-delay-and-expired-failure.md">如何解决消息队列的延时以及过期失效问题？消息队列满了以后该怎么处理？有几百万消息持续积压几小时，说说怎么解决？</a>
* <a href="https://github.com/DemoTransfer/RabbitMQGuide/blob/master/document/basic/mq-design.md">如果让你写一个消息队列，该如何进行架构设计啊？说一下你的思路。</a>

* 事务消息
   * <a href="https://github.com/DemoTransfer/RabbitMQ-Guide/blob/master/document/tran-msg/%E8%BF%98%E4%B8%8D%E7%9F%A5%E9%81%93%E4%BA%8B%E5%8A%A1%E6%B6%88%E6%81%AF%E5%90%97%EF%BC%9F%E8%BF%99%E7%AF%87%E6%96%87%E7%AB%A0%E5%B8%A6%E4%BD%A0%E5%85%A8%E9%9D%A2%E6%89%AB%E7%9B%B2%EF%BC%81.md">还不知道事务消息吗？这篇文章带你全面扫盲！</a>

示例代码
------

* <a href="https://github.com/DemoTransfer/RabbitMQGuide/tree/master/coding/simpleDemo">生产者、消费者客户端代码demo</a>



