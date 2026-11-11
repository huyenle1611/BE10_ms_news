package com.be10.ms_news.controller;

import com.be10.ms_news.entity.Article;
import com.be10.ms_news.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {

        Optional<Article> articleOptional = articleService.getArticleById(id);

        if (articleOptional.isPresent()) {
            Article article = articleOptional.get();
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}