package com.myservice.domain.article.entity;

import com.myservice.domain.base.entity.BaseEntity;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "BLOGARTICLE")
public class BlogArticle extends BaseEntity {
  @EmbeddedId
  private ApiComposedKey id;
  @Column(length = 256, nullable = false)
  private String title;
  @Column(length = 256, nullable = false)
  private String postdate;
  @Column(length = 1024, nullable = false)
  private String description;
  @Column(length = 256, nullable = false)
  private String link;
  @Column(length = 256, nullable = false)
  private String bloggerLink;
  @Column(length = 256, nullable = false)
  private String bloggerName;

  public static BlogArticle of (final String title, final String postdate, final String description,
      final String link, final String bloggerLink, final String bloggerName,
      final UUID userId, final String keyword, final String url) {
    return new BlogArticle(title, postdate, description, link,
                           bloggerLink, bloggerName, userId, keyword, url);
  }

  private BlogArticle(final String title, final String postdate, final String description,
      final String link, final String bloggerLink, final String bloggerName,
      final UUID userId, final String keyword, final String url) {
    this.id = new ApiComposedKey(userId, keyword, url);
    this.title = title;
    this.postdate = postdate;
    this.description = description;
    this.link = link;
    this.bloggerLink = bloggerLink;
    this.bloggerName = bloggerName;

    this.createdBy = userId;
    this.updatedBy = userId;
  }
}
