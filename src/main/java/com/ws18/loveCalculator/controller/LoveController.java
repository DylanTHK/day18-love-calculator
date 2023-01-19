package com.ws18.loveCalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ws18.loveCalculator.model.LoveCouples;


@Controller
@RequestMapping(path = "/loveCalculator")
public class LoveController {

    // activated when get url with /loveCalculator
    @GetMapping
    public String getMethodName(@RequestParam String name1,
        @RequestParam String name2,
        Model model) {

        LoveCouples couple = new LoveCouples(name1, name2);
        model.addAttribute("couple", couple);
        return "result";
    }
    
    
}
