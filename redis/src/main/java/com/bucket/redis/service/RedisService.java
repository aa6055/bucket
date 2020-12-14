package com.bucket.redis.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Resource
    RedisTemplate<String, String> redisTemplate;

    public String getKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public String saveKey(String key, String value) {
        redisTemplate.opsForValue().set(key, value, 3, TimeUnit.HOURS);
        return value;
    }
}
