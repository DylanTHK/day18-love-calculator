package com.ws18.loveCalculator.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ws18.loveCalculator.model.LoveCouple;

// class to interact with redis database (add, update, read)
@Service
public class LoveRedis {
    
    private static final String CONTACT_ENTITY = "loveKey";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    // list to store couple objects
    Integer currIndex = 0;
    List<String> indexOfCouples = new ArrayList<String>();
    List<LoveCouple> listOfCouples = new ArrayList<LoveCouple>();

    public List<LoveCouple> getListOfCouples() {
        return listOfCouples;
    }

    // updates data (java)
    public void addCouple(LoveCouple couple) {
        listOfCouples.add(couple);
        indexOfCouples.add(currIndex + "");
        
    }
    
    // adds entries (redis)
    public void save(String json) {
        redisTemplate.opsForValue().set(currIndex + "", json);
        currIndex++;
    }

    // retrieve all values in redis
    public List<LoveCouple> getAllResults() throws IOException {
        // extract all keys from redis
        Set<String> redisKeys = redisTemplate.keys("*");
        System.out.println(redisKeys);
        // temp list to extract all values
        List<LoveCouple> coupleList = new ArrayList<LoveCouple>();

        // extract string from redis
        for (String key : redisKeys) {
            LoveCouple couple = new LoveCouple(redisTemplate.opsForValue().get(key).toString());
            coupleList.add(couple);
        }
        System.out.println("Print CL: " + coupleList);
        return coupleList;
    }
}
