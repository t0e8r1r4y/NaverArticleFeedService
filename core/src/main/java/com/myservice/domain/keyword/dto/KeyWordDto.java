package com.myservice.domain.keyword.dto;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KeyWordDto {
  private Long id;
  private String keyword;
  private UUID userId;

  @Builder
  public KeyWordDto(Long id, String keyword, UUID userId) {
    this.id = id;
    this.keyword = keyword;
    this.userId = userId;
  }
}
