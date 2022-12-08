package com.myservice.domain.article.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BlogResultDto {
  private String title;
  private String postdate;
  private String description;
  private String link;
  private String bloggerLink;
  private String bloggerName;
  private String keyword;

  public BlogResultDto of( final String title,final String postdate,final String description,
      final String link, final String bloggerLink, final String bloggerName, final String keyword){
    return new BlogResultDto(title, postdate, description, link,bloggerLink,bloggerName,keyword);
  }

  private BlogResultDto(String title, String postdate, String description, String link,
      String bloggerLink, String bloggerName, String keyword) {
    this.title = title;
    this.postdate = postdate;
    this.description = description;
    this.link = link;
    this.bloggerLink = bloggerLink;
    this.bloggerName = bloggerName;
    this.keyword = keyword;
  }
}
