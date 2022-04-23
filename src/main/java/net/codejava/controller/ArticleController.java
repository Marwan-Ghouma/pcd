package net.codejava.controller;



import net.codejava.model.Article;
import net.codejava.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ArticleController {
    @Autowired
    private ArticleService service;

    @PostMapping("/cheque")
    public Article addCheque(@RequestBody Article article){
        return service.saveArticle(article);
    }
    @PostMapping("/cheques")
    public List<Article> addAccounts(@RequestBody List<Article> articles){
        return service.saveArticles(articles);
    }
    @GetMapping("/articles")
    public List<Article> findAllAccount(){
        return service.getArticles();
    }
    @GetMapping("/article/{id}")
    public Article findById(@PathVariable int id){
        return service.getArticleById(id);
    }

}
