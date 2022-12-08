package com.myservice.domain.article.dto;

import com.myservice.domain.article.entity.ApiComposedKey;
import com.myservice.domain.article.entity.BlogArticle;
import com.myservice.domain.article.util.BlogArticleItemParser;
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

  public static BlogResultSaveDto of(final ApiComposedKey apiComposedKey,
      final BlogArticleItemParser blogArticleItemParser) {
    return new BlogResultSaveDto(apiComposedKey, blogArticleItemParser);
  }

  private BlogResultSaveDto(final ApiComposedKey apiComposedKey,
    final BlogArticleItemParser blogArticleItemParser) {
    this.userId = apiComposedKey.getUserId();
    this.keyword = apiComposedKey.getKeyword();
    this.url = apiComposedKey.getUrl();
    this.title = blogArticleItemParser.getTitle();
    this.postdate = blogArticleItemParser.getPostdate();
    this.description = blogArticleItemParser.getDescription();
    this.link = blogArticleItemParser.getLink();
    this.bloggerLink = blogArticleItemParser.getBloggerlink();
    this.bloggerName = blogArticleItemParser.getBloggername();
  }

  public BlogArticle toEntity(){
    return BlogArticle.of(this.title, this.postdate, this.description, this.link, this.bloggerLink,
        this.bloggerName,this.userId, this.keyword, this.url);
  }
}
