package com.project.controller;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.model.pja.databases.MyConnection;
import com.project.model.table.News;

import pja.databases.generalisation.DB;

@Controller
public class NewsController {

    @GetMapping("/news")
    public String list(Model model) throws Exception{
        Connection connection = null;
        connection = MyConnection.connect();
        List<News> news = (List<News>) DB.getAll(new News(), connection);
        connection.close();
        String newsList = (String) DB.getTableau(news, new News(), "Liste des nouvelles", "");
        model.addAttribute("newsList", newsList);
        return "back-office/news-list";
    } 

   @PostMapping("/news")
    public String saveOrUpdateNews(News news, RedirectAttributes redirectAttributes) throws Exception {
        Connection connection = null;
        try {
            connection = MyConnection.connect();
            connection.setAutoCommit(false);
            
            String message = "";
            if (news.getId() == null) {
                message = "Actualité créée avec succès !";
            } else {
                message = "Actualité modifiée avec succès !";
            }
            
            // Sauvegarde avec votre DB.save
            DB.save(news, connection);
            connection.commit();
            
            redirectAttributes.addFlashAttribute("success", message);
            
        } catch (Exception e) {
            e.printStackTrace();
            if (connection != null) {
                connection.rollback();
            }
            redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        
        return "redirect:/news-form";
    }

    @GetMapping("/news-form")
    public String showNewsForm(Model model) {
        // Vérifier et initialiser chaque attribut
        if (model.asMap().get("success") == null) {
            model.addAttribute("success", null);
        }
        if (model.asMap().get("error") == null) {
            model.addAttribute("error", null);
        }
        if (model.asMap().get("news") == null) {
            model.addAttribute("news", null);
        }
        return "back-office/news-form";
    }
}
