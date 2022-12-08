package com.myservice.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.myservice.domain.email.repository.EmailRepository;
import com.myservice.domain.feedmessage.dto.FeedMessageDto;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmailServiceTest {

  @Autowired
  private EmailRepository emailRepository;

  @Autowired
  private EmailService emailService;

  @Test
  void saveEmail() {
    FeedMessageDto feedMessageDto = FeedMessageDto.of(UUID.randomUUID(), "terry", "04canae81@gmail.com", "test", "what", false);

//    Long given = emailService.saveEmail(feedMessageDto.toEmailEntity());
    Long given = emailRepository.save(feedMessageDto.toEmailEntity()).getId();

    assertThat(given).isEqualTo(1L);
  }
}