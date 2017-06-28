package com.gxl.dcloud.redis;

import com.gxl.dcloud.mapper.LogInfoMapper;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by XiaoLei Guo on 2017/6/26.
 */
public class RedisCacheTest extends TestCase {
    LogInfoMapper logInfoMapper;
    RedisCache redisCache;

    public void setUp() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-mvc.xml");
        logInfoMapper = (LogInfoMapper)ac.getBean("logInfoMapper");
        redisCache = (RedisCache)ac.getBean("redisCache");
    }

    public void testCacheValue() throws Exception {

    }

    public void testContainsValueKey() throws Exception {

    }

    public void testContainsSetKey() throws Exception {

    }

    public void testContainsListKey() throws Exception {

    }

    public void testContainsKey() throws Exception {

    }

    public void testGetValue() throws Exception {

    }

    public void testRemoveValue() throws Exception {

    }

    public void testRemoveSet() throws Exception {

    }

    public void testRemoveList() throws Exception {
        redisCache.removeList("guoxiaolei");
    }

    public void testRemove() throws Exception {

    }

    public void testCacheSet() throws Exception {

    }

    public void testCacheSet1() throws Exception {

    }

    public void testCacheSet2() throws Exception {

    }

    public void testCacheSet3() throws Exception {

    }

    public void testGetSet() throws Exception {

    }

    public void testCacheList() throws Exception {



        redisCache.cacheList("guoxiaolei",60*1000,"test123");
    }

    public void testCacheList1() throws Exception {

    }

    public void testCacheList2() throws Exception {

    }

    public void testCacheList3() throws Exception {

    }

    public void testGetList() throws Exception {
        List<String> list = redisCache.getList("guoxiaolei",0,redisCache.getListSize("guoxiaolei"));
        for (String str : list){
            System.out.println(str);
        }
    }

    public void testGetListSize() throws Exception {

    }

    public void testGetListSize1() throws Exception {

    }

    public void testRemoveOneOfList() throws Exception {

    }

}