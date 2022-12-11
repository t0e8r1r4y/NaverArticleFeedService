package com.myservice.service;

import com.myservice.component.NaverSearchApi;
import com.myservice.domain.api.dto.ApiResponseSaveDto;
import com.myservice.domain.api.entity.ComposedKey;
import com.myservice.domain.api.repository.ApiResponseRepository;
import com.myservice.domain.api.util.ApiResponseParser;
import com.myservice.domain.article.dto.BlogResultSaveDto;
import com.myservice.domain.article.entity.ApiComposedKey;
import com.myservice.domain.article.repository.BlogArticleRepository;
import com.myservice.domain.article.util.BlogArticleItemParser;
import com.myservice.service.util.UrlList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApiRequestService {
  private final static int MAX_CNT = 10;
  private final static int TYPE_BLOG = 1;
  private final static int TYPE_NEWS = 2;
  private final static int TYPE_CAFE = 3;
  private final static int TYPE_DOC = 4;

  private final static boolean TYPE_SIM = true;
  private final static boolean TYPE_DATE = false;

  private final NaverSearchApi naverSearchApi;

  private final ApiResponseRepository apiResponseRepository;

  private final BlogArticleRepository blogArticleRepository;

  @Transactional
  public int getBlogArticleSortBySim( UUID userId, String keyword, int cnt){
    int articleType = TYPE_BLOG;
    boolean sortType = TYPE_SIM;

    UrlList firstCollectionUrl = new UrlList(keyword, articleType, sortType, cnt);
    List<String> urlList = firstCollectionUrl.getUrlList();

    List<ApiResponseSaveDto> apiResponseSaveDtoList
        = getApiResponseSaveDtoList(new ComposedKey(userId, keyword), urlList);

    for(ApiResponseSaveDto dto : apiResponseSaveDtoList){
      getBlogResultList(userId, keyword, dto.getRequestUrl(), dto.getItem());
      apiResponseRepository.save( dto.toEntity() );
      log.info(dto.getUserId() + " " + dto.getKeyword() + " " + dto.getRequestUrl());
    }

    return apiResponseSaveDtoList.size();
  }

  @Transactional
  public int getBlogResultList( UUID userId, String keyword, String url, JSONArray item ){
    List<BlogResultSaveDto> blogList = new ArrayList<>();

    Iterator<JSONObject> iter = item.iterator();
    while(iter.hasNext()) {
      JSONObject itemEach = (JSONObject) iter.next();

      BlogResultSaveDto dto = BlogResultSaveDto.of( new ApiComposedKey(userId, keyword, url),
          BlogArticleItemParser.parser(itemEach));

      blogArticleRepository.save(dto.toEntity());
      blogList.add(dto);
      log.info(dto.getBloggerName() + " " +dto.getTitle());
    }
    return blogList.size();
  }


  private List<ApiResponseSaveDto> getApiResponseSaveDtoList(ComposedKey composedKey, List<String> urlList) {
    List<ApiResponseSaveDto> responseList = new ArrayList<>();

    for(String url : urlList) {
      String response = naverSearchApi.search(url);
      responseList.add(ApiResponseSaveDto.of(composedKey, url, ApiResponseParser.parser(response)));
    }

    return responseList;
  }

}
