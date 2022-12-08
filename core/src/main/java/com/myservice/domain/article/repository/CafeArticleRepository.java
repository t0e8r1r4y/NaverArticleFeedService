package com.myservice.domain.article.repository;

import com.myservice.domain.article.entity.ApiComposedKey;
import com.myservice.domain.article.entity.CafeArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeArticleRepository extends JpaRepository<CafeArticle, ApiComposedKey> {

}
