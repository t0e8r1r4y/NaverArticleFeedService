package com.myservice.domain.article.dto;

import com.myservice.domain.article.entity.CafeArticle;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CafeResultSaveDto {

  private UUID userId;
  private String keyword;
  private String url;
  private String title;
  private String link;
  private String description;
  private String cafeName;
  private String cafeUrl;

  public static CafeResultSaveDto of(final UUID userId, final String keyword, final String url,
      final String title, final String link, final String description, final String cafeName,
      final String cafeUrl) {
    return new CafeResultSaveDto(userId, keyword, url, title, link, description, cafeName, cafeUrl);
  }

  private CafeResultSaveDto(final UUID userId, final String keyword, final String url,
      final String title, final String link, final String description, final String cafeName,
      final String cafeUrl) {
    this.userId = userId;
    this.keyword = keyword;
    this.url = url;
    this.title = title;
    this.link = link;
    this.description = description;
    this.cafeName = cafeName;
    this.cafeUrl = cafeUrl;
  }

  public CafeArticle toEntity(){
    return CafeArticle.of(this.title, this.link, this.description, this.cafeName
    , this.cafeUrl, this.userId, this.keyword, this.url);
  }
}
