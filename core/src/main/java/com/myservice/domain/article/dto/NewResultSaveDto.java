package com.myservice.domain.article.dto;

import com.myservice.domain.article.entity.ApiComposedKey;
import com.myservice.domain.article.entity.NewsArticle;
import com.myservice.domain.article.util.NewsArticleItemParser;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NewResultSaveDto {

  private UUID userId;
  private String keyword;
  private String url;
  private String title;
  private String originalLink;
  private String link;
  private String description;
  private String pubDate;

  public NewResultSaveDto of(final ApiComposedKey apiComposedKey,
      final NewsArticleItemParser newsArticleItemParser) {
    return new NewResultSaveDto(apiComposedKey, newsArticleItemParser);
  }

  private NewResultSaveDto(final ApiComposedKey apiComposedKey,
      final NewsArticleItemParser newsArticleItemParser) {
    this.userId = apiComposedKey.getUserId();
    this.keyword = apiComposedKey.getKeyword();
    this.url = apiComposedKey.getUrl();
    this.title = newsArticleItemParser.getTitle();
    this.originalLink = newsArticleItemParser.getOriginallink();
    this.link = newsArticleItemParser.getLink();
    this.description = newsArticleItemParser.getDescription();
    this.pubDate = newsArticleItemParser.getPubDate();
  }

  public NewsArticle toEntity(){
    return NewsArticle.of(this.title, this.originalLink, this.link, this.description, this.pubDate,
        this.userId, this.keyword, this.url);
  }

}
