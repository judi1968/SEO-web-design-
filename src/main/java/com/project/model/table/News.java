package com.project.model.table;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.project.model.pja.databases.generalisation.annotation.ShowTable;

public class News {
    Integer id;
    String title;
    Date dateSortie;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getDateSortie() {
        return dateSortie;
    }
    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }
    
    @ShowTable(name = "Titre", numero = 1)
    public String getTitleInfo() {
        return title;
    }

    @ShowTable(name = "Date Sortie", numero = 2)
    public String getDateInfo(){ 
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("d MMM yyyy");
        return formatter.format(dateSortie);
    }

    @ShowTable(name = "Action", numero = 3)
    public String getActionTab(){
        return "<td>" + //
                        "<div class=\"dropdown\">" + //
                        "<button type=\"button\" class=\"btn btn-primary light sharp\" data-bs-toggle=\"dropdown\">" + //
                        "<svg width=\"20px\" height=\"20px\" viewBox=\"0 0 24 24\" version=\"1.1\"><g stroke=\"none\" stroke-width=\"1\" fill=\"none\" fill-rule=\"evenodd\"><rect x=\"0\" y=\"0\" width=\"24\" height=\"24\"/><circle fill=\"#000000\" cx=\"5\" cy=\"12\" r=\"2\"/><circle fill=\"#000000\" cx=\"12\" cy=\"12\" r=\"2\"/><circle fill=\"#000000\" cx=\"19\" cy=\"12\" r=\"2\"/></g></svg>" + //
                        "</button>" + //
                        "<div class=\"dropdown-menu\">" + //
                        "<a class=\"dropdown-item\" href=\"vehicule-form?id="+this.getId()+"\">Modifier</a>" + //
                        "<a class=\"dropdown-item\" href=\"vehicule-delete?id="+this.getId()+"\">Supprimer</a>" + //
                        "</div>" + //
                        "</div>" + //
                        "</td>";
    }

    public static List<News> getSampleNews() {
        List<News> newsList = new ArrayList<>();
        News news1 = new News();
        news1.setTitle("New Product Launch");
        news1.setDateSortie(new Date());
        newsList.add(news1);

        News news2 = new News();
        news2.setTitle("Company Milestone Achieved");
        news2.setDateSortie(new Date());
        newsList.add(news2);

        return newsList;
    }
}
