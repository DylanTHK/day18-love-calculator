package com.ws18.loveCalculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

// class to interact with redis database
@Service
public class LoveRedis {
    @Autowired
    RedisTemplate redisTemplate;


}
