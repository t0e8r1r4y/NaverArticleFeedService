package com.myservice.domain.article.util;

import lombok.Getter;
import org.json.simple.JSONObject;

@Getter
public class CafeArticleItemParser {
  private String title;
  private String link;
  private String descriptions;
  private String cafeName;
  private String cafeUrl;

  public static CafeArticleItemParser parser(JSONObject item){
    return new CafeArticleItemParser(item);
  }

  private CafeArticleItemParser(JSONObject item) {
    this.title = (String) item.get("title");
    this.link = (String) item.get("link");
    this.descriptions = (String) item.get("description");
    this.cafeName = (String) item.get("cafename");
    this.cafeUrl = (String) item.get("cafeurl");
  }
}
