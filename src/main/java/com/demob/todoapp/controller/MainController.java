package com.demob.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
   

    @RequestMapping("/hello")
    public String Hello() {
        return "hello";
    }
}
