package com.be10.ms_news.repository;

import com.be10.ms_news.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}