package com.myservice.domain.article.util;

import java.util.Optional;
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
    Optional<String> titleOption = Optional.ofNullable((String) item.get("title"));
    this.title = titleOption.orElse("");

    Optional<String> linkOption = Optional.ofNullable((String) item.get("link"));
    this.link = linkOption.orElse("");

    Optional<String> descriptionOption = Optional.ofNullable((String) item.get("description"));
    this.descriptions = descriptionOption.orElse("");

    Optional<String> cafenameOption = Optional.ofNullable((String) item.get("cafename"));
    this.cafeName = cafenameOption.orElse("");

    Optional<String> cafeurlOption = Optional.ofNullable((String) item.get("cafeurl"));
    this.cafeUrl = cafeurlOption.orElse("");
  }
}
