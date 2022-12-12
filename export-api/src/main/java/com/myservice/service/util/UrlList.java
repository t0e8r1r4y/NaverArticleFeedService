package com.myservice.service.util;

import static com.myservice.domain.article.entity.ArticleType.*;
import static com.myservice.domain.article.entity.ArticleType.BLOG;
import static com.myservice.domain.article.entity.SortType.SIM;

import com.myservice.config.BussinessException;
import com.myservice.domain.article.entity.ArticleType;
import com.myservice.domain.article.entity.SortType;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;


@Getter
public class UrlList {

  private static final int MIN_CNT = 1;
  private static final int MAX_CNT = 10;
  private List<String> urlList;
  public UrlList(UrlConfig urlConfig){
    if(!isValideArticleType(urlConfig.getArticleType())) {
      throw new IllegalArgumentException("아티클 타입은 블로그(1), 뉴스(2), 카페(3), 도큐먼트(4)만 가능합니다.");
    }

    if(!isValidCnt(urlConfig.getPage())) {
      throw new IllegalArgumentException("생성 가능한 갯수는 1개 이상 10개 이하입니다.");
    }

    this.urlList = getUrlList(urlConfig);
  }

  private boolean isValideArticleType(ArticleType articleType){
    return (articleType == BLOG || articleType == CAFE || articleType == NEWS);
  }

  private boolean isValidCnt(int cnt){
    return (cnt >= MIN_CNT && cnt <= MAX_CNT);
  }

  private List<String> getUrlList(UrlConfig urlConfig){
    List<String> urlList = new ArrayList<>();
    for(int i = 0; i < urlConfig.getPage(); i++)
      urlList.add(makeUrl( urlConfig , (1 + (100*i)) ));
    return urlList;
  }

  private String makeUrl( UrlConfig urlConfig, int start ) {
    StringBuilder queryBuilder = new StringBuilder();
    String query = "";
    switch (urlConfig.getArticleType()) { // url 세팅
      case BLOG: {
        queryBuilder.append("https://openapi.naver.com/v1/search/blog.json?query=");
        break;
      }
      case NEWS: {
        queryBuilder.append("https://openapi.naver.com/v1/search/news.json?query=");
        break;
      }
      case CAFE: {
        queryBuilder.append("https://openapi.naver.com/v1/search/cafearticle.json?query=");
        break;
      }
      default:
        break;
    } // end switch

    try { // 쿼리 조합
      query = URLEncoder.encode(urlConfig.getKeyword(), "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new BussinessException("Query incoding fail " +  e.getMessage());
    }

    queryBuilder.append(query);
    queryBuilder.append("&display=100"); // 한번에 가져올 페이지
    queryBuilder.append("&start=" + String.valueOf(start)); // 시작 페이지
    if (urlConfig.getSortType() == SIM) { // 정확도순 최신순
      queryBuilder.append("&sort=sim");
    } else {
      queryBuilder.append("&sort=date");
    }
    return queryBuilder.toString();
  }
}
