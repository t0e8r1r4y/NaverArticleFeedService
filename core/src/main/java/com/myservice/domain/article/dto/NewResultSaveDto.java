package com.myservice.domain.article.dto;

import com.myservice.domain.article.entity.NewsArticle;
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

  public NewResultSaveDto of(final UUID userId, final String keyword, final String url,
      final String title, final String originalLink,
      final String link, final String description, final String pubDate) {
    return new NewResultSaveDto(userId, keyword, url,title, originalLink, link, description, pubDate);
  }

  private NewResultSaveDto(final UUID userId, final String keyword, final String url,
      final String title, final String originalLink,
      final String link, final String description, final String pubDate) {
    this.userId = userId;
    this.keyword = keyword;
    this.url = url;
    this.title = title;
    this.originalLink = originalLink;
    this.link = link;
    this.description = description;
    this.pubDate = pubDate;
  }

  public NewsArticle toEntity(){
    return NewsArticle.of(this.title, this.originalLink, this.link, this.description, this.pubDate,
        this.userId, this.keyword, this.url);
  }

}
