package com.myservice.service;

import com.myservice.domain.api.dto.ApiResponseSaveDto;
import com.myservice.service.ApiResponseService;
import com.myservice.service.util.UrlList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArticleRequestFacade {
  private final static int MAX_CNT = 10;
  private final static int TYPE_BLOG = 1;
  private final static int TYPE_NEWS = 2;
  private final static int TYPE_CAFE = 3;
  private final static int TYPE_DOC = 4;

  private final static boolean TYPE_SIM = true;
  private final static boolean TYPE_DATE = false;

  private final ApiResponseService apiResponseService;

  private final BlogArticleService blogArticleService;

  /**
   * 블로그 아티클 데이터 크롤링
   * @param userId
   * @param keyword
   * @param cnt
   */
  public void getBlogArticleSortBySim(UUID userId, String keyword, int cnt) {

    int articleType = TYPE_BLOG;
    boolean sortType = TYPE_SIM;
    UrlList firstCollectionUrl = new UrlList(keyword, articleType, sortType, cnt);

    List<String> urlList = firstCollectionUrl.getUrlList();
    List<ApiResponseSaveDto> dtoList = apiResponseService.getApiResponseSaveDtoList(userId, keyword, urlList);
    int saveResult = apiResponseService.saveApiResponse(dtoList);

    if(dtoList.size() != saveResult) return;

    return;
  }

}
