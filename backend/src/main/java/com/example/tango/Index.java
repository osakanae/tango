package com.example.tango;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
    @RequestMapping("/")
    public String exec() {
        return "index";
    }
}
