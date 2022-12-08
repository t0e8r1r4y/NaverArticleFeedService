package com.myservice.domain.article.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CafeResultDto {
  private String title;
  private String link;
  private String description;
  private String cafeName;
  private String cafeUrl;
  private String keyword;

  public CafeResultDto of(final String title, final String link, final String description,
      final String cafeName, final String cafeUrl, final String keyword){
    return new CafeResultDto(title, link, description, cafeName, cafeUrl, keyword);
  }

  private CafeResultDto(final String title, final String link, final String description,
      final String cafeName, final String cafeUrl, final String keyword){
    this.title = title;
    this.link = link;
    this.description = description;
    this.cafeName = cafeName;
    this.cafeUrl = cafeUrl;
    this.keyword = keyword;
  }
}
