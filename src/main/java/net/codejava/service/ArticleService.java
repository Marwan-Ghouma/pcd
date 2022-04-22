package net.codejava.service;



import net.codejava.model.Article;
import net.codejava.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    public Article getArticleById(int id){
        return repository.findById(id).orElse(null);
    }
    public Article saveArticle(Article article) {
        return repository.save(article);
    }


    public List<Article> saveArticles(List<Article> article){
        return repository.saveAll(article);
    }
    public List<Article> getArticles(){
        return repository.findAll();
    }

}
