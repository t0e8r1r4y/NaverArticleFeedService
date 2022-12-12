package com.myservice.component;

import static com.myservice.domain.article.entity.ArticleType.BLOG;
import static com.myservice.domain.article.entity.ArticleType.CAFE;
import static com.myservice.domain.article.entity.SortType.SIM;

import com.myservice.domain.keyword.dto.KeyWordDto;
import com.myservice.service.api.facade.ArticleRequestFacade;
import com.myservice.service.keyword.KeywordService;
import com.myservice.service.util.UrlConfig;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NaverApiScheduler {

  private final ArticleRequestFacade articleRequestFacade;
  private final KeywordService keywordService;
  @Scheduled(cron = "0 */5 * * * *")
  public void blogScheduler() {
    List<KeyWordDto> keyWordDtoList = keywordService.findKeyWordAll();
    for(KeyWordDto dto : keyWordDtoList) {
      articleRequestFacade.getArticle(dto.getUserId(), UrlConfig.of(dto.getKeyword(), BLOG, SIM, 10));
    }
  }

  @Scheduled(cron = "0 */8 * * * *")
  public void cafeScheduler() {
    List<KeyWordDto> keyWordDtoList = keywordService.findKeyWordAll();
    for(KeyWordDto dto : keyWordDtoList) {
      articleRequestFacade.getArticle(dto.getUserId(), UrlConfig.of(dto.getKeyword(), CAFE, SIM, 10));
    }
  }

}

// 사용가능한 옵션들
// @Scheduled( cron = "0 */1 * * * *")
// @Scheduled( cron = "0 */59 * * * *")
