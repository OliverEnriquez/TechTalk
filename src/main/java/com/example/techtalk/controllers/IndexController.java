package com.example.techtalk.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController implements ErrorController {

    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("hello", "Hello World");
        return "index";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
