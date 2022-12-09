package com.myservice.service.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("UrlList 일급 컬렉션 테스트")
class UrlListTest {

  @Test
  @DisplayName("UrlList를 정상 생성하는 테스트입니다.")
  void 일급컬렉션_생성_성공() {
    int givenCnt = 10;
    UrlList urlList = new UrlList("슈룹", 1, false, givenCnt);
    assertThat(urlList.getUrlList().size()).isEqualTo(givenCnt);

    // 생성 예시
    /*https://openapi.naver.com/v1/search/blog.json?query=%EC%8A%88%EB%A3%B9&display=100&start=1&sort=date
    https://openapi.naver.com/v1/search/blog.json?query=%EC%8A%88%EB%A3%B9&display=100&start=101&sort=date
    https://openapi.naver.com/v1/search/blog.json?query=%EC%8A%88%EB%A3%B9&display=100&start=201&sort=date
    https://openapi.naver.com/v1/search/blog.json?query=%EC%8A%88%EB%A3%B9&display=100&start=301&sort=date
    https://openapi.naver.com/v1/search/blog.json?query=%EC%8A%88%EB%A3%B9&display=100&start=401&sort=date
    https://openapi.naver.com/v1/search/blog.json?query=%EC%8A%88%EB%A3%B9&display=100&start=501&sort=date
    https://openapi.naver.com/v1/search/blog.json?query=%EC%8A%88%EB%A3%B9&display=100&start=601&sort=date
    https://openapi.naver.com/v1/search/blog.json?query=%EC%8A%88%EB%A3%B9&display=100&start=701&sort=date
    https://openapi.naver.com/v1/search/blog.json?query=%EC%8A%88%EB%A3%B9&display=100&start=801&sort=date
    https://openapi.naver.com/v1/search/blog.json?query=%EC%8A%88%EB%A3%B9&display=100&start=901&sort=date*/
  }

  @Test
  @DisplayName("UrlList를 생성 시 cnt 검증에 걸려 예외처리 되는 부분입니다.")
  void 일급컬렉션_생성_실패_유효성검증1() {
    int givenCnt = 0;
    IllegalArgumentException illegalArgumentException = assertThrows(
        IllegalArgumentException.class,
        () -> new UrlList("슈룹", 1, true, givenCnt)
    );

    String errorMessage = illegalArgumentException.getMessage();
    assertEquals("생성 가능한 갯수는 1개 이상 10개 이하입니다.", errorMessage);
  }

  @Test
  @DisplayName("UrlList를 생성 시 article 타입 검증에 걸려 예외처리 되는 부분입니다.")
  void 일급컬렉션_생성_실패_유효성검증2() {
    int givenCnt = 10;
    IllegalArgumentException illegalArgumentException = assertThrows(
        IllegalArgumentException.class,
        () -> new UrlList("슈룹", 0, true, givenCnt)
    );

    String errorMessage = illegalArgumentException.getMessage();
    assertEquals("아티클 타입은 블로그(1), 뉴스(2), 카페(3), 도큐먼트(4)만 가능합니다.", errorMessage);
  }
}