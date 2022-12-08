package com.myservice.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiRequestServiceTest {

  @Autowired
  private ApiRequestService apiRequestService;

  @Test
  void getBlogArticleSortBySim() {
    UUID userId = UUID.randomUUID();
    String keyword = "슈룹";
    int expectation = apiRequestService.getBlogArticleSortBySim(userId,keyword,10);

    assertThat(expectation).isEqualTo(100);
  }
}