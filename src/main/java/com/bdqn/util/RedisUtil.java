package com.bdqn.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
@Component
public class RedisUtil {


        @Resource
        RedisTemplate<String,Object> redisTemplate;


        public boolean SetValue(String key,String value) {
            try {
                //redis 是二进制安全的，可以直接通过0,1 代码来完成各种操作
                //序列化是把Java 对象转成0,1 代码
                redisTemplate.setKeySerializer(new StringRedisSerializer());
                redisTemplate.setValueSerializer(new StringRedisSerializer());
                ValueOperations<String, Object> vo = redisTemplate.opsForValue();
                vo.set(key, value);
                redisTemplate.expire(key, 60*60*2, TimeUnit.SECONDS);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }

        public Object get(String key) {
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            //设置序列化Value的实例化对象
            redisTemplate.setValueSerializer(new StringRedisSerializer());
            ValueOperations<String,Object> vo = redisTemplate.opsForValue();
            return vo.get(key);
        }
}
