package com.myservice.service;

import com.myservice.component.MailSenderByGoogle;
import com.myservice.domain.email.dto.EmailSendingDto;
import com.myservice.domain.feedmessage.dto.FeedMessageDto;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArticleFeedService {
  private static final String EXAMPLE_LINK_TEMPLATE = "mail/mail";
  private final TemplateEngine templateEngine;
  private final MailSenderByGoogle mailSenderByGoogle;

  public CompletableFuture<String> sendFeedByEmail(FeedMessageDto feedMessageDto) {
    Context context = getContext( feedMessageDto );
    String message = templateEngine.process(EXAMPLE_LINK_TEMPLATE, context);
    EmailSendingDto emailSendingDto = EmailSendingDto.of(feedMessageDto.getAddress(),
        feedMessageDto.getTitle(), message);
    String sendResult = mailSenderByGoogle.sendMailFormattingHtml(emailSendingDto);
    return CompletableFuture.completedFuture(sendResult);
  }

  private Context getContext( FeedMessageDto feedMessageDto ) {
    Context context = new Context();
    context.setVariable("name", feedMessageDto.getUserName() );
    context.setVariable("message", "블로그 추천 콘텐츠입니다.");
//    context.setVariable("blogList", mailContent.getBList());
    context.setVariable("message2", "카페 추천 콘텐츠입니다.");
//    context.setVariable("CafeList", mailContent.getCList());
    context.setVariable("message3", "뉴스 추천 콘텐츠입니다.");
//    context.setVariable("NewsList", mailContent.getNList());
    return context;
  }
}
