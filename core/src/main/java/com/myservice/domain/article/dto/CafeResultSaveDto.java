package com.myservice.domain.article.dto;

import com.myservice.domain.article.entity.ApiComposedKey;
import com.myservice.domain.article.entity.CafeArticle;
import com.myservice.domain.article.util.CafeArticleItemParser;
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

  public static CafeResultSaveDto of (final ApiComposedKey apiComposedKey,
      final CafeArticleItemParser cafeArticleItemParser) {
    return new CafeResultSaveDto(apiComposedKey, cafeArticleItemParser);
  }

  private CafeResultSaveDto(final ApiComposedKey apiComposedKey,
      final CafeArticleItemParser cafeArticleItemParser) {
    this.userId = apiComposedKey.getUserId();
    this.keyword = apiComposedKey.getKeyword();
    this.url = apiComposedKey.getUrl();
    this.title = cafeArticleItemParser.getTitle();
    this.link = cafeArticleItemParser.getLink();
    this.description = cafeArticleItemParser.getDescriptions();
    this.cafeName = cafeArticleItemParser.getCafeName();
    this.cafeUrl = cafeArticleItemParser.getCafeUrl();
  }

  public CafeArticle toEntity(){
    return CafeArticle.of(this.title, this.link, this.description, this.cafeName
    , this.cafeUrl, this.userId, this.keyword, this.url);
  }
}
