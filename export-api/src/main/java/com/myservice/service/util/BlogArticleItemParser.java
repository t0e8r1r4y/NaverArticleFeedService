package com.myservice.service.util;

import java.util.HashMap;
import java.util.Map;
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
    this.link = (String) item.get("link");
    this.postdate = (String) item.get("postdate");
    this.description = (String) item.get("description");
    this.title = (String) item.get("title");
    this.bloggerlink = (String) item.get("bloggerlink");
    this.bloggername = (String) item.get("bloggername");
  }
}
