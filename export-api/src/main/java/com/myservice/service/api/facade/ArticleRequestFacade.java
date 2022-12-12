package com.myservice.service.api.facade;

import com.myservice.domain.api.dto.ApiResponseSaveDto;
import com.myservice.domain.article.entity.ApiComposedKey;
import com.myservice.domain.article.entity.ArticleType;
import com.myservice.service.api.sub.ApiResponseService;
import com.myservice.service.api.sub.BlogArticleService;
import com.myservice.service.api.sub.CafeArticleService;
import com.myservice.service.api.sub.NewsArticleService;
import com.myservice.service.util.UrlConfig;
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
  private static final int MAX_CNT = 10;

  private final ApiResponseService apiResponseService;

  private final BlogArticleService blogArticleService;

  private final CafeArticleService cafeArticleService;

  private final NewsArticleService newsArticleService;

  public void getArticle( UUID userId ,UrlConfig urlConfig ) {

    if(urlConfig.getPage() > MAX_CNT) return;
    UrlList firstCollectionUrl = new UrlList( urlConfig );

    List<String> urlList = firstCollectionUrl.getUrlList();
    List<ApiResponseSaveDto> dtoList
        = apiResponseService.getApiResponseSaveDtoList(userId, urlConfig.getKeyword(), urlList);
    apiResponseService.saveApiResponse(dtoList);

    articleByType(urlConfig.getArticleType() ,dtoList);
  }

  private void articleByType(ArticleType articleType,  List<ApiResponseSaveDto> dtoList) {
    switch (articleType) {
      case BLOG: {
        getBlogArticle(dtoList);
        break;
      }
      case CAFE: {
        getCafeArticle(dtoList);
        break;
      }
      case NEWS: {
        getNewsArticle(dtoList);
        break;
      }
      default: {
        break;
      }
    }
  }

  private void getBlogArticle(List<ApiResponseSaveDto> dtoList) {
    for(ApiResponseSaveDto dto : dtoList){
      blogArticleService.saveBlogItemList(
          new ApiComposedKey(dto.getUserId(), dto.getKeyword(), dto.getRequestUrl())
          ,dto.getItem()
      );
    }
  }

  private void getCafeArticle(List<ApiResponseSaveDto> dtoList) {
    for(ApiResponseSaveDto dto : dtoList){
      cafeArticleService.saveCafeItemList(
          new ApiComposedKey(dto.getUserId(), dto.getKeyword(), dto.getRequestUrl())
          ,dto.getItem()
      );
    }
  }

  private void getNewsArticle(List<ApiResponseSaveDto> dtoList) {
    for(ApiResponseSaveDto dto : dtoList){
      newsArticleService.saveNewsItemList(
          new ApiComposedKey(dto.getUserId(), dto.getKeyword(), dto.getRequestUrl())
          ,dto.getItem()
      );
    }
  }
}
