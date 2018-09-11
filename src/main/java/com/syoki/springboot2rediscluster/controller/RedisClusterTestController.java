package com.syoki.springboot2rediscluster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisClusterTestController {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/redisTest")
    public void redisTest() {
        String key = "redisTestKey";
        String value = "I am test value";

        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();

        //数据插入测试：
        opsForValue.set(key, value);

        String valueFromRedis = opsForValue.get(key);
        System.out.println(valueFromRedis);

        //数据删除测试：
        //redisTemplate.delete(key);
    }

}
