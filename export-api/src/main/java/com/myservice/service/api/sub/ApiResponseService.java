package com.myservice.service.api.sub;

import com.myservice.component.NaverSearchApi;
import com.myservice.domain.api.dto.ApiResponseSaveDto;
import com.myservice.domain.api.entity.ApiResponse;
import com.myservice.domain.api.entity.ComposedKey;
import com.myservice.domain.api.repository.ApiResponseRepository;
import com.myservice.domain.api.util.ApiResponseParser;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApiResponseService {

  private final NaverSearchApi naverSearchApi;

  private final ApiResponseRepository apiResponseRepository;

  @Transactional
  public int saveApiResponse(List<ApiResponseSaveDto> apiResponseSaveDtoList) {
    List<ApiResponse> saveList = apiResponseSaveDtoList
        .stream().map(ApiResponseSaveDto::toEntity)
        .collect(Collectors.toList());

    return apiResponseRepository.saveAll(saveList).size();
  }

  public List<ApiResponseSaveDto> getApiResponseSaveDtoList(UUID userId, String keyword, List<String> urlList) {
    List<ApiResponseSaveDto> responseList = new ArrayList<>();

    for(String url : urlList) {
      String response = naverSearchApi.search(url);
      ComposedKey composedKey = new ComposedKey(userId, keyword ,url);
      responseList.add(ApiResponseSaveDto.of(composedKey, ApiResponseParser.parser(response)));
    }

    return responseList;
  }

}
