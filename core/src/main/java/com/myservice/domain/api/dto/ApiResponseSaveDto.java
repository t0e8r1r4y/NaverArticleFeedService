package com.myservice.domain.api.dto;

import com.myservice.domain.api.entity.ApiResponse;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.simple.JSONArray;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponseSaveDto {
  private UUID userId;
  private String keyword;
  private String lastBuildDate;
  private Long total;
  private String requestUrl;
  private JSONArray item;

  public static ApiResponseSaveDto of(final UUID userId ,final String keyword, final String lastBuildDate, final Long total, final String requestUrl,
      final JSONArray item) {
    return new ApiResponseSaveDto( userId ,keyword, lastBuildDate, total, requestUrl, item);
  }
  private ApiResponseSaveDto(final UUID userId, final String keyword, final String lastBuildDate, final Long total, final String requestUrl,
      final JSONArray item) {
    this.userId = userId;
    this.keyword = keyword;
    this.lastBuildDate = lastBuildDate;
    this.total = total;
    this.requestUrl = requestUrl;
    this.item = item;
  }

  public ApiResponse toEntity(){
    return ApiResponse.of(this.keyword, this.userId, this.lastBuildDate, this.total, this.requestUrl);
  }
}
