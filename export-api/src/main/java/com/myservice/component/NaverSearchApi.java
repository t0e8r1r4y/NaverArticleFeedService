package com.myservice.component;

import com.myservice.config.BussinessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NaverSearchApi {
  @Value("${naver.api.clientId}")
  private String clientId;

  @Value("${naver.api.clientKey}")
  private String clientKey;

  public String search( String url ) {
    StringBuilder responseBody = new StringBuilder();
    // Key Setting
    Map<String, String> requestHeaders = new HashMap<>();
    requestHeaders.put("X-Naver-Client-Id", clientId);
    requestHeaders.put("X-Naver-Client-Secret", clientKey);
    // 요청
    responseBody.append(get(url,requestHeaders));
    return responseBody.toString();
  }

  private String get(String apiUrl, Map<String, String> reqHeaders){
    HttpURLConnection urlConnection = null;
    try {
      // connection setting
      urlConnection = connect(apiUrl);
      urlConnection.setReadTimeout(50000);
      urlConnection.setConnectTimeout(30000);
      // setting method
      urlConnection.setRequestMethod("GET");
      for(Map.Entry<String, String> header : reqHeaders.entrySet()) {
        urlConnection.setRequestProperty(header.getKey(), header.getValue());
      }
      // response
      int responsCode = urlConnection.getResponseCode();
      if( responsCode == HttpURLConnection.HTTP_OK ) {
        return readBody(urlConnection.getInputStream());
      }
      return readBody( urlConnection.getErrorStream() );

    } catch (MalformedURLException e) {
      throw new BussinessException(e.getMessage());
    } catch (IOException e) {
      urlConnection.disconnect();
      throw new BussinessException(e.getMessage());
    }

  }

  private static HttpURLConnection connect(String apiUrl){
    try {
      URL url = new URL(apiUrl);
      return (HttpURLConnection)url.openConnection();
    } catch (MalformedURLException e) {
      throw new BussinessException("API URL이 잘못되었습니다. : " + apiUrl + " " + e.getMessage());
    } catch (IOException e) {
      throw new BussinessException("연결이 실패했습니다. : " + apiUrl + " " + e.getMessage());
    }
  }


  private static String readBody(InputStream body){
    InputStreamReader streamReader = new InputStreamReader(body);


    try (BufferedReader lineReader = new BufferedReader(streamReader)) {
      StringBuilder responseBody = new StringBuilder();


      String line;
      while ((line = lineReader.readLine()) != null) {
        responseBody.append(line);
      }


      return responseBody.toString();
    } catch (IOException e) {
      throw new BussinessException("API 응답을 읽는 데 실패했습니다." + e.getMessage());
    }
  }
}
