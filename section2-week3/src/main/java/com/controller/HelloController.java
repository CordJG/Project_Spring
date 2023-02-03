package com.controller;

import org.springframework.ui.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("CordJg")
    public String CordJg(Model model){
        model.addAttribute("data","CordJg!!");
        return "CordJg";
    }
}
