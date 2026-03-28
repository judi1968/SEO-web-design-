package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewsController {

    @GetMapping("/news")
    public String listOrDeleteNews() {
        return "back-office/news-list";
    }

    @PostMapping("/news") 
    public String saveOrUpdateNews() {
        return "redirect:/news";
    }

    @GetMapping("/news-form")
    public String showNewsForm() {
        return "back-office/news-form";
    }
}
