package com.myservice.domain.article.util;

import lombok.Getter;
import org.json.simple.JSONObject;

@Getter
public class NewsArticleItemParser {
  private String title;
  private String originallink;
  private String link;
  private String description;
  private String pubDate;

  public static NewsArticleItemParser parser (JSONObject item){
    return new NewsArticleItemParser(item);
  }

  private NewsArticleItemParser(JSONObject item) {
    this.title = (String) item.get("title");
    this.originallink = (String) item.get("originallink");
    this.link = (String) item.get("link");
    this.description = (String) item.get("description");
    this.pubDate = (String) item.get("pubDate");
  }
}
