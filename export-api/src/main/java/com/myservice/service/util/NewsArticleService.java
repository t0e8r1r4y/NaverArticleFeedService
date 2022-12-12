package com.myservice.service.util;

import com.myservice.domain.article.entity.ApiComposedKey;
import com.myservice.domain.article.repository.NewsArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewsArticleService {

  private final NewsArticleRepository newsArticleRepository;

  @Transactional
  public int saveNewsItemList(ApiComposedKey apiComposedKey, JSONArray newsItem){
    return 1;
  }

}
