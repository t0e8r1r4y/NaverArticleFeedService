package com.myservice.service.util;

import com.myservice.config.BussinessException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UrlMaker {
  private final static int TYPE_BLOG = 1;
  private final static int TYPE_NEWS = 2;
  private final static int TYPE_CAFE = 3;
  private final static int TYPE_DOC = 4;

  public List<String> getUrlList(String keyword, int articleType, boolean sortType, int cnt){
    List<String> urlList = new ArrayList<>();
    for(int i = 0; i < cnt; i++)
      urlList.add(makeUrl(articleType, keyword, (1 + (100*i)) , sortType ));
    return urlList;
  }

  private String makeUrl( int type, String query, int start, boolean sort ) {
    StringBuilder queryBuilder = new StringBuilder();
    switch (type) { // url 세팅
      case TYPE_BLOG: {
        queryBuilder.append("https://openapi.naver.com/v1/search/blog.json?query=");
        break;
      }
      case TYPE_NEWS: {
        queryBuilder.append("https://openapi.naver.com/v1/search/news.json?query=");
        break;
      }
      case TYPE_CAFE: {
        queryBuilder.append("https://openapi.naver.com/v1/search/cafearticle.json?query=");
        break;
      }
      case TYPE_DOC: {
        queryBuilder.append("https://openapi.naver.com/v1/search/webkr.json?query=");
        break;
      }
      default:
        break;
    } // end switch

    try { // 쿼리 조합
      query = URLEncoder.encode(query, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new BussinessException("Query incoding fail " +  e.getMessage());
    }

    queryBuilder.append(query);
    queryBuilder.append("&display=100"); // 한번에 가져올 페이지
    queryBuilder.append("&start=" + String.valueOf(start)); // 시작 페이지
    if (sort) { // 정확도순 최신순
      queryBuilder.append("&sort=sim");
    } else {
      queryBuilder.append("&sort=date");
    }
    return queryBuilder.toString();
  }
}
