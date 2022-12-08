package com.myservice.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NaverApiScheduler {

  // @Scheduled( cron = "0 */1 * * * *")
  // @Scheduled( cron = "0 */59 * * * *")
  @Scheduled(fixedRate = 100)
  public void scheduler() {

  }

}
