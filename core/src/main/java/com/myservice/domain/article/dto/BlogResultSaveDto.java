package com.myservice.domain.article.dto;

import com.myservice.domain.article.entity.BlogArticle;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BlogResultSaveDto {

  private UUID userId;
  private String keyword;
  private String url;
  private String title;
  private String postdate;
  private String description;
  private String link;
  private String bloggerLink;
  private String bloggerName;

  public static BlogResultSaveDto of(final UUID userId, final String keyword, final String url,
      final String title, final String postdate, final String description, final String link,
      final String bloggerLink, final String bloggerName) {
    return new BlogResultSaveDto(userId, keyword, url, title, postdate, description, link, bloggerLink, bloggerName);
  }

  private BlogResultSaveDto(final UUID userId,final String keyword, final String url,
      final String title, final String postdate, final String description, final String link,
      final String bloggerLink, final String bloggerName) {
    this.userId = userId;
    this.keyword = keyword;
    this.url = url;
    this.title = title;
    this.postdate = postdate;
    this.description = description;
    this.link = link;
    this.bloggerLink = bloggerLink;
    this.bloggerName = bloggerName;
  }

  public BlogArticle toEntity(){
    return BlogArticle.of(this.title, this.postdate, this.description, this.link, this.bloggerLink,
        this.bloggerName,this.userId, this.keyword, this.url);
  }
}
