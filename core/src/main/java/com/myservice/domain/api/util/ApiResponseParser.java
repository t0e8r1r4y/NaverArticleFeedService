package com.myservice.domain.api.util;

import lombok.Getter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@Getter
public class ApiResponseParser {
  private String lastBuildDateChanel;
  private Long totalChanel;
  private JSONArray item;

  public static ApiResponseParser parser(JSONObject object){
    return new ApiResponseParser(object);
  }

  private ApiResponseParser(JSONObject object) {
    this.lastBuildDateChanel = (String) object.get( "lastBuildDate" );;
    this.totalChanel = (Long) object.get( "total" );
    this.item = (JSONArray) object.get( "items" );
  }
}
