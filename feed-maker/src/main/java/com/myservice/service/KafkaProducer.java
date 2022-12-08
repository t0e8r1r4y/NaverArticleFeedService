package com.myservice.service;

import com.myservice.domain.feedmessage.dto.FeedMessageDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
  private final KafkaTemplate<String,Object> kafkaTemplate;

  private long count = 0;

  @Scheduled(fixedDelay = 5000)
  public void counting(){

    FeedMessageDto feedMessageDto = FeedMessageDto.of(UUID.randomUUID(), "terry", "04canae81@gmail.com", "test", "what", false);
    kafkaTemplate.send("test",feedMessageDto);
    log.info(feedMessageDto.getUserId().toString());
  }
}
