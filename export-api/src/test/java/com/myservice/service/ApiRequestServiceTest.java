package com.myservice.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.myservice.domain.api.entity.ApiResponse;
import com.myservice.domain.api.repository.ApiResponseRepository;
import com.myservice.domain.article.entity.BlogArticle;
import com.myservice.domain.article.repository.BlogArticleRepository;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiRequestServiceTest {

  @Autowired
  private ApiRequestService apiRequestService;

  @Autowired
  private ApiResponseRepository apiResponseRepository;

  @Autowired
  private BlogArticleRepository blogArticleRepository;

  @Test
  void getBlogArticleSortBySim() {
    UUID userId = UUID.randomUUID();
    String keyword = "슈룹";
    apiRequestService.getBlogArticleSortBySim(userId,keyword,10);
    List<ApiResponse> apiResponseList = apiResponseRepository.findAll();
    List<BlogArticle> blogArticleList = blogArticleRepository.findAll();

//    assertThat(apiResponseList.size()).isEqualTo(10);
//    assertThat(blogArticleList.size()).isEqualTo(1000);
  }
}