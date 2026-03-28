package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RooterController {
    @GetMapping("/")
    public String home() {
        return "home"; // correspond à home.jsp
    }
}
