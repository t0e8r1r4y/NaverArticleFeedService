package com.myservice.domain.api.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class ComposedKey implements Serializable {

  @Column(columnDefinition = "BINARY(16)", nullable = false, name = "USER_ID")
  private UUID userId;

  @Column(name = "USER_KEYWORD", nullable = false)
  private String keyword;

  @Column(name = "USER_REQUEST_URL", nullable = false)
  private String requestUrl;


  @Builder
  public ComposedKey(UUID userId ,String keyword, String requestUrl) {
    this.keyword = keyword;
    this.userId = userId;
    this.requestUrl = requestUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ComposedKey)) {
      return false;
    }

    ComposedKey that = (ComposedKey) o;

    if (!userId.equals(that.userId)) {
      return false;
    }
    if (!keyword.equals(that.keyword)) {
      return false;
    }
    return requestUrl.equals(that.requestUrl);
  }

  @Override
  public int hashCode() {
    int result = userId.hashCode();
    result = 31 * result + keyword.hashCode();
    result = 31 * result + requestUrl.hashCode();
    return result;
  }
}
