package net.codejava.controller;



import net.codejava.model.Article;
import net.codejava.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService service;

    @PostMapping("/profile/articles")
    public Article addCheque(@RequestBody Article article){
        return service.saveArticle(article);
    }
    @PostMapping("/addArticles")
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
