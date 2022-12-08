package com.myservice.service;

import com.myservice.component.NaverSearchApi;
import com.myservice.config.BussinessException;
import com.myservice.domain.api.dto.ApiResponseSaveDto;
import com.myservice.domain.api.repository.ApiResponseRepository;
import com.myservice.domain.article.dto.BlogResultSaveDto;
import com.myservice.domain.article.repository.BlogArticleRepository;
import com.myservice.service.util.UrlMaker;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

  private final UrlMaker urlMaker;

  @Transactional
  public int getBlogArticleSortBySim( UUID userId, String keyword,  int cnt){
    int articleType = TYPE_BLOG;
    boolean sortType = TYPE_SIM;

    List<String> urlList = urlMaker.getUrlList(keyword, articleType, sortType, cnt);


    List<ApiResponseSaveDto> apiResponseSaveDtoList = getApiResponseSaveDtoList(userId, keyword, urlList);

    for(ApiResponseSaveDto dto : apiResponseSaveDtoList){
      getBlogResultList(userId, keyword, dto.getRequestUrl(), dto.getItem());
      apiResponseRepository.save( dto.toEntity() );
    }

    return apiResponseSaveDtoList.size();
  }

  @Transactional
  public int getBlogResultList( UUID userId, String keyword, String url, JSONArray item ){
    List<BlogResultSaveDto> blogList = new ArrayList<>();

    Iterator<JSONObject> iter = item.iterator();
    while(iter.hasNext()) {
      JSONObject itemEach = (JSONObject) iter.next();
      Map<String, String> map = parseBlogArticleItem(itemEach);

      BlogResultSaveDto dto = BlogResultSaveDto.of(userId, keyword, url, map.get("title"), map.get("postdata"),
          map.get("descrption"), map.get("link"), map.get("bloggerlink"), map.get("bloggername"));

      blogArticleRepository.save(dto.toEntity());
      blogList.add(dto);
    }
    return blogList.size();
  }

  private Map<String, String> parseBlogArticleItem( JSONObject item ) {
    Map<String, String> map = new HashMap<>();
    map.put("link", (String) item.get("link"));
    map.put("postdate", (String) item.get("postdate"));
    map.put("description", (String) item.get("description"));
    map.put("title", (String) item.get("title"));
    map.put("bloggerlink", (String) item.get("bloggerlink"));
    map.put("bloggername", (String) item.get("bloggername"));
    return map;
  }

  private List<ApiResponseSaveDto> getApiResponseSaveDtoList(UUID userId, String keyword, List<String> urlList) {
    List<ApiResponseSaveDto> responseList = new ArrayList<>();
    JSONParser parser = new JSONParser();

    for(String url : urlList) {
      try {
        String response = naverSearchApi.search(url);
        JSONObject object = (JSONObject) parser.parse( response );
        String lastBuildDateChanel = (String) object.get( "lastBuildDate" );
        Long totalChanel = (Long) object.get( "total" );
        JSONArray item = (JSONArray) object.get( "items" );
        responseList.add(ApiResponseSaveDto.of(userId, keyword ,lastBuildDateChanel, totalChanel, url, item));
      } catch (ParseException e) {
        log.info(e.getMessage());
      }
    }

    return responseList;
  }

}
