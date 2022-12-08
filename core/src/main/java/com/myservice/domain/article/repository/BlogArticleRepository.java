package com.myservice.domain.article.repository;

import com.myservice.domain.article.entity.ApiComposedKey;
import com.myservice.domain.article.entity.BlogArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogArticleRepository extends JpaRepository<BlogArticle, ApiComposedKey> {

}
