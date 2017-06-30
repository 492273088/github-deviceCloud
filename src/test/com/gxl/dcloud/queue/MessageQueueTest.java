package com.gxl.dcloud.queue;

import com.gxl.dcloud.mapper.LogInfoMapper;
import com.gxl.dcloud.queue.bean.LogMessageCreator;
import com.gxl.dcloud.redis.ListRedisCache;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by XiaoLei Guo on 2017/6/30.
 */
public class MessageQueueTest  extends TestCase {

    MSenderService mSenderService;
    MReceiveService mReceiveService;

    public void setUp() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-mvc.xml");
        mSenderService = (MSenderService)ac.getBean("mSenderService");
        mReceiveService = (MReceiveService)ac.getBean("mReceiveService");

    }

    public void testMessageSender() throws Exception {
        String[] levelArray = {"紧急","普通","较高","最低"};
        mReceiveService.start();
        mSenderService.init();
        for (int i = 0; i<1000;i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("time",new Date().toString());
            map.put("level", levelArray[new Random().nextInt(4)]);
            map.put("content","这是一个日志内容日志内容为:"+new Date().toString());
            map.put("timestamp",String.valueOf(System.currentTimeMillis()));
            LogMessageCreator logMessageCreator = new LogMessageCreator(map);
            mSenderService.messageSender("log-message-queue",logMessageCreator);
        }
        Thread.sleep(10*60*1000);
    }



}
