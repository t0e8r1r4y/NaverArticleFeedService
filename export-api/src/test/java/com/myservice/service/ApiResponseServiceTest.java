package com.myservice.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.myservice.domain.api.entity.ApiResponse;
import com.myservice.domain.api.repository.ApiResponseRepository;
import com.myservice.service.api.sub.ApiResponseService;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiResponseServiceTest {

  @Autowired
  private ApiResponseService apiResponseService;

  @Autowired
  private ApiResponseRepository apiResponseRepository;

  @Test
  void getBlogArticleSortBySim() {
    UUID given = UUID.randomUUID();
    String givenKeyword = "슈룹";
    int givenCnt = 10;

//    int expectCnt = apiRequestService.getBlogArticleSortBySim(given, givenKeyword, givenCnt);
    List<ApiResponse> list = apiResponseRepository.findAll();

    assertThat(list.size()).isEqualTo(givenCnt);

  }
}