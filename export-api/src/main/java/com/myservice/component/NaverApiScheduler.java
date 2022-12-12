package com.myservice.component;

import static com.myservice.domain.article.entity.ArticleType.BLOG;
import static com.myservice.domain.article.entity.ArticleType.CAFE;
import static com.myservice.domain.article.entity.SortType.SIM;

import com.myservice.domain.article.entity.ArticleType;
import com.myservice.domain.article.entity.SortType;
import com.myservice.service.ArticleRequestFacade;
import com.myservice.service.util.UrlConfig;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NaverApiScheduler {

  private final ArticleRequestFacade articleRequestFacade;
  @Scheduled(fixedRate = 5000)
  public void blogScheduler() {
    UUID userId = UUID.randomUUID();
    String keyword = "슈룹";
    articleRequestFacade.getArticle(userId, UrlConfig.of(keyword, BLOG, SIM, 10));
  }

  @Scheduled(fixedRate = 7000)
  public void cafeScheduler() {
    UUID userId = UUID.randomUUID();
    String keyword = "부동산";
    articleRequestFacade.getArticle(userId, UrlConfig.of(keyword, CAFE, SIM, 10));
  }

}

// 사용가능한 옵션들
// @Scheduled( cron = "0 */1 * * * *")
// @Scheduled( cron = "0 */59 * * * *")
