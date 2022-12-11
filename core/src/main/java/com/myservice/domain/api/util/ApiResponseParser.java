package com.myservice.domain.api.util;

import java.util.Optional;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Getter
@Slf4j
public class ApiResponseParser {

  public static final long NOTFOUNT = -1L;
  private String lastBuildDateChanel;
  private Long totalChanel;
  private JSONArray item;

  public static ApiResponseParser parser(String apiResponse){
    JSONParser parser = new JSONParser();
    JSONObject object;
    try {
      object = (JSONObject) parser.parse( apiResponse );
      return new ApiResponseParser(object);
    } catch (ParseException e) {
      log.error(e.getMessage());
      return null;
    }
  }
  private ApiResponseParser(JSONObject object) {
    Optional<String> latBuildDataChanelOption = Optional.ofNullable((String) object.get( "lastBuildDate" ));
    this.lastBuildDateChanel = latBuildDataChanelOption.orElse("");

    Optional<Long> totalChanelOption = Optional.ofNullable((Long) object.get( "total" ));
    this.totalChanel = totalChanelOption.orElse(NOTFOUNT);

    this.item = (JSONArray) object.get( "items" ); // 해당 값은 DB에 저장하지 않기 때문에 null이 아닌경우 그냥 저장함
  }
}
