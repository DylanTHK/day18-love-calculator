package com.ws18.loveCalculator.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ws18.loveCalculator.model.LoveCouple;
import com.ws18.loveCalculator.service.LoveService;


@Controller
@RequestMapping(path = "/loveCalculator")
public class LoveController {

    @Autowired
    LoveService loveSvc;

    // activated when get url with /loveCalculator
    @GetMapping
    public String getMethodName(@RequestParam String name1,
        @RequestParam String name2,
        Model model) throws IOException, InterruptedException {

        // send in 2 names, returns an object
        LoveCouple lc = loveSvc.getRequestEntity(name1, name2);

        // add lc to array in loveSvc
        loveSvc.addCouple(lc);

        // add couple object to model
        model.addAttribute("couple", lc);

        // model.addAttribute("couple", couple);
        return "result";
    }
    
    
}
