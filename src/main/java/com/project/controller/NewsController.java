package com.project.controller;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.pja.databases.MyConnection;
import com.project.model.table.News;

import pja.databases.generalisation.DB;

@Controller
public class NewsController {

    @GetMapping("/news")
    public String listOrDeleteNews(@RequestParam(required = false) Integer id, Model model) throws Exception{
        if (id != null) {
            
        }else{

        }
        Connection connection = MyConnection.connect();
        if (connection!=null) {
            System.out.println("ok");
            connection.close();
        }else{
            System.out.println("not ok");
        } 
        List<News> news = News.getSampleNews();
        String newsList = (String) DB.getTableau(news, new News(), "Liste des nouvelles", "");
        model.addAttribute("newsList", newsList);
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
