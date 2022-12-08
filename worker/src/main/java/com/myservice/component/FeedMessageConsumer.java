package com.myservice.component;

import com.myservice.config.exception.SmtpSendFailException;
import com.myservice.domain.feedmessage.dto.FeedMessageDto;
import com.myservice.service.ArticleFeedService;
import com.myservice.service.EmailService;
import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FeedMessageConsumer implements AcknowledgingMessageListener<String, Object> {

  @Value(value = "${spring.kafka.bootstrap-servers}")
  private String bootstrapAddress;

  @Value(value = "${spring.kafka.my.push.topic.group}")
  private String myGroupId;
  private ArticleFeedService articleFeedService;

  private EmailService emailService;

  public FeedMessageConsumer(ArticleFeedService articleFeedService, EmailService emailService) {
    this.articleFeedService = articleFeedService;
    this.emailService = emailService;
  }

  @Override
  @KafkaListener(groupId = "test-push-group", topics = "test", containerFactory = "kafkaListenerContainerFactory")
  public void onMessage(ConsumerRecord<String, Object> data, Acknowledgment acknowledgment) {
    procComsumingData(data, acknowledgment);
  }

  private void procComsumingData(ConsumerRecord<String, Object> data, Acknowledgment acknowledgment) {
    try {
      FeedMessageDto messageDto = (FeedMessageDto) data.value();
      log.info(messageDto.getUserId() + " " + messageDto.getUserName());

      CompletableFuture<String> futureResult = articleFeedService.sendFeedByEmail(messageDto);
      futureResult.join();

      String result = futureResult.get();

      if(!result.equals("success")) {
        emailService.saveEmail(messageDto.toEmailEntity()); // 실패 결과 저장
        throw new SmtpSendFailException(result);
      }

      messageDto.setSendResult(true);
      emailService.saveEmail(messageDto.toEmailEntity()); // 성공 결과 저장

      acknowledgment.acknowledge();
    } catch (InterruptedException e){
      Thread.currentThread().interrupt();
    } catch (Exception e){
      log.info(e.getMessage());
    }
  }
}
