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
@Entity(name = "NEWARTICLE")
public class NewsArticle extends BaseEntity {
  @EmbeddedId
  private ApiComposedKey id;
  @Column(length = 256, nullable = false)
  private String title;
  @Column(length = 256, nullable = false)
  private String originalLink;
  @Column(length = 256, nullable = false)
  private String link;
  @Column(length = 2048, nullable = false)
  private String description;
  @Column(length = 4096, nullable = false)
  private String pubDate;

  public static NewsArticle of(final String title,final  String originalLink,final  String link,
      final String description, final String pubDate,
      final UUID userId, final String keyword, final String url) {
    return new NewsArticle(title, originalLink, link, description, pubDate, userId, keyword, url);
  }

  private NewsArticle(final String title,final  String originalLink,final  String link,
      final String description, final String pubDate,
      final UUID userId, final String keyword, final String url) {
    this.id = new ApiComposedKey(userId,keyword, url);
    this.title = title;
    this.originalLink = originalLink;
    this.link = link;
    this.description = description;
    this.pubDate = pubDate;
  }
}
