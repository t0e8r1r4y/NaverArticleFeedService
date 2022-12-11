package com.myservice.domain.article.util;

import java.util.Optional;
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
    Optional<String> titleOption = Optional.ofNullable((String) item.get("title"));
    this.title = titleOption.orElse("");

    Optional<String> originallinkOption = Optional.ofNullable((String) item.get("originallink"));
    this.originallink = originallinkOption.orElse("");

    Optional<String> linkOption = Optional.ofNullable((String) item.get("link"));
    this.link = linkOption.orElse("");

    Optional<String> descriptionOption = Optional.ofNullable((String) item.get("description"));
    this.description = descriptionOption.orElse("");

    Optional<String> pubDateOption = Optional.ofNullable((String) item.get("pubDate"));
    this.pubDate = pubDateOption.orElse("");
  }
}
