package com.myservice.domain.article.repository;

import com.myservice.domain.article.entity.ApiComposedKey;
import com.myservice.domain.article.entity.NewsArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsArticleRepository extends JpaRepository<NewsArticle, ApiComposedKey> {

}
