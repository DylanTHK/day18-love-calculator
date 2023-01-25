package com.ws18.loveCalculator.service;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ws18.loveCalculator.model.LoveCouple;

// helper class to generate request / response entities
@Service
public class LoveService {

    @Autowired
    LoveRedis loveRedis;

    // method to take in json, create entity and
    public String getRequestEntity(String sname, String fname) throws IOException, InterruptedException {
        
        // GOAL: to get "https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John"
        // base URL
        String url = "https://love-calculator.p.rapidapi.com/getPercentage?";
        System.out.println("Printing from LoveService.java");
        System.out.println("URL old: " + url);

        // build the url
        url = UriComponentsBuilder
            .fromUriString(url)
            .queryParam("fname", fname)
            .queryParam("sname", sname)
            .toUriString();

        System.out.println("URL new: " + url);

    
        // Set the headers required for API request
        final HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "431350f947msh1d9b2c145f95c1cp115117jsneee91761942a");
        headers.set("X-RapidAPI-Host", "love-calculator.p.rapidapi.com");

        // add headers to Http Entity
        final HttpEntity<String> entity = new HttpEntity<String>(headers);

        RestTemplate restTemplate = new RestTemplate();
        
        //Execute the method writing your HttpEntity to the request
        ResponseEntity<String> response = restTemplate.exchange(url, 
            HttpMethod.GET, entity, 
            String.class);

        System.out.println("Response Body: " + response.getBody().getClass());

        // convert response body(String) to Couple object
        String coupleJson = response.getBody();

        return coupleJson;
    }

}
