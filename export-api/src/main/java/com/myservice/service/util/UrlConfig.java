package com.myservice.service.util;

import com.myservice.domain.article.entity.ArticleType;
import com.myservice.domain.article.entity.SortType;
import lombok.Getter;

@Getter
public class UrlConfig {
  private String keyword;
  private ArticleType articleType;
  private SortType sortType;
  private int page;

  public static UrlConfig of(final String keyword, final ArticleType articleType, final SortType sortType, final int page) {
    return new UrlConfig(keyword, articleType, sortType, page);
  }

  private UrlConfig(final String keyword, final ArticleType articleType, final SortType sortType, final int page) {
    this.keyword = keyword;
    this.articleType = articleType;
    this.sortType = sortType;
    this.page = page;
  }
}
