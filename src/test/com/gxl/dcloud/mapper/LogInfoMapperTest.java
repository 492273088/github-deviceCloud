package com.gxl.dcloud.mapper;

import com.gxl.dcloud.pojo.LogEnty;
import com.gxl.dcloud.redis.RedisCache;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by XiaoLei Guo on 2017/6/26.
 */
public class LogInfoMapperTest extends TestCase {
    LogInfoMapper logInfoMapper;
    RedisCache redisCache;
    public void setUp() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-mvc.xml");
        logInfoMapper = (LogInfoMapper)ac.getBean("logInfoMapper");
        redisCache = (RedisCache)ac.getBean("redisCache");
    }

    public void tearDown() throws Exception {

    }

    public void testDeleteByPrimaryKey() throws Exception {
        logInfoMapper.deleteByPrimaryKey(3);
    }

    public void testInsert() throws Exception {
        LogEnty logEnty = new LogEnty();
        logEnty.setCommite("测试");
        logEnty.setData(System.currentTimeMillis());
        logEnty.setIp("127.0.0.1");
        logEnty.setMethod("插入");
        logEnty.setModule("系统模块");
        logEnty.setResponseData(System.currentTimeMillis());
        logEnty.setUserId(103580);
        logInfoMapper.insert(logEnty);
    }

    public void testInsertSelective() throws Exception {

    }

    public void testSelectByPrimaryKey() throws Exception {

    }

    public void testUpdateByPrimaryKeySelective() throws Exception {

    }

    public void testUpdateByPrimaryKey() throws Exception {

    }

}