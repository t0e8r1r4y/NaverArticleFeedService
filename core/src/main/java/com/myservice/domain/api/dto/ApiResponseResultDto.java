package com.myservice.domain.api.dto;

import com.myservice.domain.api.entity.ApiResponse;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponseResultDto {
  private UUID userId;
  private String keyword;
  private String lastBuildDate;
  private Long total;
  private String requestUrl;

  @Builder
  public ApiResponseResultDto(ApiResponse apiResponse){
    this.userId = apiResponse.getId().getUserId();
    this.keyword = apiResponse.getId().getKeyword();
    this.lastBuildDate = apiResponse.getLastBuildDate();
    this.total = apiResponse.getTotal();
    this.requestUrl = apiResponse.getId().getRequestUrl();
  }
}
