package com.myservice.domain.article.util;

import java.util.Optional;
import lombok.Getter;
import org.json.simple.JSONObject;

@Getter
public class BlogArticleItemParser {

  private String link;
  private String postdate;
  private String description;
  private String title;
  private String bloggerlink;
  private String bloggername;

  public static BlogArticleItemParser parser(JSONObject item){
    return new BlogArticleItemParser(item);
  }

  private BlogArticleItemParser(JSONObject item) {
    Optional<String> linkOption = Optional.ofNullable((String) item.get("link"));
    this.link = linkOption.orElse("");

    Optional<String> postdataOption = Optional.ofNullable((String) item.get("postdate"));
    this.postdate = postdataOption.orElse("");

    Optional<String> descriptionOption = Optional.ofNullable((String) item.get("description"));
    this.description = descriptionOption.orElse("");

    Optional<String> titleOption = Optional.ofNullable((String) item.get("title"));
    this.title = titleOption.orElse("");

    Optional<String> bloggerlinkOption = Optional.ofNullable((String) item.get("bloggerlink"));
    this.bloggerlink = bloggerlinkOption.orElse("");

    Optional<String> bloggernameOption = Optional.ofNullable((String) item.get("bloggername"));
    this.bloggername = bloggernameOption.orElse("");
  }
}
