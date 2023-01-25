package com.ws18.loveCalculator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ws18.loveCalculator.model.LoveCouple;

// class to interact with redis database
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

    // updates data on java side
    public void addCouple(LoveCouple couple) {
        listOfCouples.add(couple);
        indexOfCouples.add(currIndex + "");
        
    }
    
    public void save(String json) {
        redisTemplate.opsForValue().set(currIndex + "", json);
        currIndex++;
    }

}
