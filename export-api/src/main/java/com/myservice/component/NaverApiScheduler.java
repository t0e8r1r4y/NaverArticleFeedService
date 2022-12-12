package com.myservice.component;

import com.myservice.service.ArticleRequestFacade;
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
  // @Scheduled( cron = "0 */1 * * * *")
  // @Scheduled( cron = "0 */59 * * * *")
  @Scheduled(fixedRate = 5000)
  public void scheduler() {
    UUID userId = UUID.randomUUID();
    String keyword = "슈룹";
    articleRequestFacade.getBlogArticleSortBySim(userId,keyword,10);
  }

}
