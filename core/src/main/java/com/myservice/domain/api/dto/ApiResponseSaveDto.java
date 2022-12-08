package com.myservice.domain.api.dto;

import com.myservice.domain.api.entity.ApiResponse;
import com.myservice.domain.api.entity.ComposedKey;
import com.myservice.domain.api.util.ApiResponseParser;
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

  public static ApiResponseSaveDto of(final ComposedKey composedKey , final String url,
      final ApiResponseParser apiResponseParser) {
    return new ApiResponseSaveDto( composedKey, url, apiResponseParser );
  }
  private ApiResponseSaveDto(final ComposedKey composedKey , final String url,
      final ApiResponseParser apiResponseParser) {

    this.userId = composedKey.getUserId();
    this.keyword = composedKey.getKeyword();

    this.lastBuildDate = apiResponseParser.getLastBuildDateChanel();
    this.total = apiResponseParser.getTotalChanel();
    this.item = apiResponseParser.getItem();

    this.requestUrl = url;
  }

  public ApiResponse toEntity(){
    return ApiResponse.of(this.keyword, this.userId, this.lastBuildDate, this.total, this.requestUrl);
  }
}
