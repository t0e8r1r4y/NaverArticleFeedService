package com.myservice.domain.article.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class ApiComposedKey implements Serializable {

  @Column(columnDefinition = "BINARY(16)", nullable = false, name = "API_ID")
  private UUID articleId;

  @Column(columnDefinition = "BINARY(16)", nullable = false, name = "USER_ID")
  private UUID userId;

  @Column(name = "USER_KEYWORD", nullable = false)
  private String keyword;

  @Column(name = "REQUEST_URL", nullable = false)
  private String url;

  public ApiComposedKey(UUID userId, String keyword, String url) {
    this.articleId = UUID.randomUUID();
    this.userId = userId;
    this.keyword = keyword;
    this.url = url;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ApiComposedKey)) {
      return false;
    }

    ApiComposedKey that = (ApiComposedKey) o;

    if (!userId.equals(that.userId)) {
      return false;
    }
    if (!keyword.equals(that.keyword)) {
      return false;
    }
    return url.equals(that.url);
  }

  @Override
  public int hashCode() {
    int result = userId.hashCode();
    result = 31 * result + keyword.hashCode();
    result = 31 * result + url.hashCode();
    return result;
  }
}
