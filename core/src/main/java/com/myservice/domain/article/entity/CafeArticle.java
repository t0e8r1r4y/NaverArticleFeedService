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
@Entity(name = "CAFEARTICLE")
public class CafeArticle extends BaseEntity {
  @EmbeddedId
  private ApiComposedKey id;
  @Column(length = 256, nullable = false)
  private String title;
  @Column(length = 256, nullable = false)
  private String link;
  @Column(length = 1024, nullable = false)
  private String description;
  @Column(length = 256, nullable = false)
  private String cafeName;
  @Column(length = 256, nullable = false)
  private String cafeUrl;

  public static CafeArticle of(final String title, final String link, final String description,
      final String cafeName, final String cafeUrl, final UUID userId, final String keyword,
      final String url) {
    return new CafeArticle(title, link, description, cafeName, cafeUrl, userId, keyword, url);
  }

  private CafeArticle(final String title, final String link, final String description,
      final String cafeName, final String cafeUrl, final UUID userId, final String keyword,
      final String url) {
    this.id = new ApiComposedKey(userId, keyword, url);
    this.title = title;
    this.link = link;
    this.description = description;
    this.cafeName = cafeName;
    this.cafeUrl = cafeUrl;

    this.createdBy = userId;
    this.updatedBy = userId;
  }
}
