package com.gxl.dcloud.queue;

import com.gxl.dcloud.queue.bean.LogMessageCreator;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.util.Map;

/**
 * Created by XiaoLei Guo on 2017/6/30.
 */
@Service("mSenderService")
public class MSenderService {

    @Autowired
    ActiveMQConnectionFactory activeMQConnectionFactory;

    private Destination destination;
    //从工厂中获取一个连接
    Connection connection;
    //创建一个session
    private Session session;

    public void init() throws JMSException {
        //从工厂中获取一个连接
        connection = activeMQConnectionFactory.createConnection();
        //测试过这个步骤不写也是可以的，但是网上的各个文档都写了
        connection.start();
        //创建一个session
        //第一个参数:是否支持事务，如果为true，则会忽略第二个参数，被jms服务器设置为SESSION_TRANSACTED
        //第二个参数为false时，paramB的值可为Session.AUTO_ACKNOWLEDGE，Session.CLIENT_ACKNOWLEDGE，DUPS_OK_ACKNOWLEDGE其中一个。
        //Session.AUTO_ACKNOWLEDGE为自动确认，客户端发送和接收消息不需要做额外的工作。哪怕是接收端发生异常，也会被当作正常发送成功。
        //Session.CLIENT_ACKNOWLEDGE为客户端确认。客户端接收到消息后，必须调用javax.jms.Message的acknowledge方法。jms服务器才会当作发送成功，并删除消息。
        //DUPS_OK_ACKNOWLEDGE允许副本的确认模式。一旦接收方应用程序的方法调用从处理消息处返回，会话对象就会确认消息的接收；而且允许重复确认。
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    public void messageSender(String queueName,LogMessageCreator messageCreator) throws JMSException {
        //创建一个到达的目的地，其实想一下就知道了，activemq不可能同时只能跑一个队列吧，这里就是连接了一个名为"text-msg"的队列，这个会话将会到这个队列，当然，如果这个队列不存在，将会被创建
//        destination = session.createQueue("log-message-queue");
        Destination destination = session.createQueue(queueName);

        //目的地，其实就是连接到哪个队列，如果是点对点，那么它的实现是Queue，如果是订阅模式，那它的实现是Topic
        MessageProducer producer = session.createProducer(destination);
        //设置生产者的模式，有两种可选
        //DeliveryMode.PERSISTENT 当activemq关闭的时候，队列数据将会被保存
        //DeliveryMode.NON_PERSISTENT 当activemq关闭的时候，队列里面的数据将会被清空
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        producer.send(messageCreator.createMessage(session));
        producer.setTimeToLive(60*1000L);
        //即便生产者的对象关闭了，程序还在运行哦
        producer.close();

    }

}
