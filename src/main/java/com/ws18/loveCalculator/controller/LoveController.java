package com.ws18.loveCalculator.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ws18.loveCalculator.model.LoveCouple;
import com.ws18.loveCalculator.service.LoveRedis;
import com.ws18.loveCalculator.service.LoveService;


@Controller
@RequestMapping(path = "/lovecalc")
public class LoveController {

    @Autowired
    LoveService loveSvc;

    @Autowired
    LoveRedis loveRedis;

    // activated when get url with /loveCalculator
    @GetMapping
    public String getMethodName(@RequestParam String name1,
                                @RequestParam String name2, 
                                Model model) 
                                throws IOException, InterruptedException {

        // method generates request entity and returns json string
        String coupleJson = loveSvc.getRequestEntity(name1, name2);
        loveRedis.save(coupleJson);
        
        // add couple object to model
        LoveCouple coupleObj = new LoveCouple(coupleJson);
        model.addAttribute("couple", coupleObj);
        // model.addAttribute("couple", couple);
        return "result";
    }

    // GET Mapping for listing all contacts (in table)
    @GetMapping(path="/list")
    public String getAllResults(Model model) throws IOException {
        // call method to extract data and return ARRAY of objects
        List<LoveCouple> coupleList = loveRedis.getAllResults();

        // add objects to model
        model.addAttribute("coupleList", coupleList);

        return "allResults";
    }

}
