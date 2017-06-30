package com.gxl.dcloud.queue.bean;

import com.alibaba.fastjson.JSONObject;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Map;

/**
 * 创建日志消息队列
 * @return
 * @throws JMSException
 */
public class LogMessageCreator implements MessageCreator{

    private Map<String,String> map;

    public LogMessageCreator(Map<String,String> map) {
        this.map = map;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        session.createQueue("log-message-queue");
        JSONObject jsonObject = new JSONObject();
        for (String key : map.keySet()){
            jsonObject.put(key,map.get(key));
        }
        return session.createTextMessage(jsonObject.toString());
    }

}
