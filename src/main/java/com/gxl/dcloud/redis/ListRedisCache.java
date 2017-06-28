package com.gxl.dcloud.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by XiaoLei Guo on 2017/6/27.
 */
@Component("listRedisCache")
public class ListRedisCache {
    /**
     * 日志记录
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    public long lpush(String key, Object value){
        try {
            ListOperations<String, Object> listOperations = redisTemplate.opsForList();
            return listOperations.leftPush(key,value);
        } catch (Throwable t) {
            logger.error("缓存[" + key + "]失败, value[" + value.toString() + "]", t);
            t.printStackTrace();
        }
        return 0;
    }

    public boolean lpush(String key, Object value, long time){
        long result = lpush(key,value);
        if(result>0){
            return expire(key,time);
        }else{
            return false;
        }

    }

    public boolean expire(String key, long time){
        try {
            return redisTemplate.expire(key, time, TimeUnit.SECONDS);
        }catch (Throwable t){
            logger.error("设置[" + key + "]缓存失效时间失败！", t);
            t.printStackTrace();
        }
        return false;
    }
}
