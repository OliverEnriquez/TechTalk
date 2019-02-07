package com.example.techtalk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("hello", "Hello World");
        return "index";
    }
}
