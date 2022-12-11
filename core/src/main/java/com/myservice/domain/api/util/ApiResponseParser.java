package com.myservice.domain.api.util;

import lombok.Getter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Getter
public class ApiResponseParser {
  private String lastBuildDateChanel;
  private Long totalChanel;
  private JSONArray item;

  public static ApiResponseParser parser(String apiResponse){
    JSONParser parser = new JSONParser();
    JSONObject object = null;
    try {
      object = (JSONObject) parser.parse( apiResponse );
      return new ApiResponseParser(object);
    } catch (ParseException e) {
      return null;
    }
  }
  private ApiResponseParser(JSONObject object) {
    this.lastBuildDateChanel = (String) object.get( "lastBuildDate" );
    this.totalChanel = (Long) object.get( "total" );
    this.item = (JSONArray) object.get( "items" );
  }
}
