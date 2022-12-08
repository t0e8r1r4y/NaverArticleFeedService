package com.myservice.domain.article.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NewsResultDto {
  private String title;
  private String originalLink;
  private String link;
  private String description;
  private String pubDate;
  private String keyword;

  public NewsResultDto of(final String title,final String originalLink,final String link,
      final String description,final String pubDate,final String keyword) {
    return new NewsResultDto(title, originalLink, link, description, pubDate, keyword);
  }

  private NewsResultDto(final String title,final String originalLink,final String link,
      final String description,final String pubDate,final String keyword) {
    this.title = title;
    this.originalLink = originalLink;
    this.link = link;
    this.description = description;
    this.pubDate = pubDate;
    this.keyword = keyword;
  }
}
