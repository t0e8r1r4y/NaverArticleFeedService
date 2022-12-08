package com.myservice.component;

import com.myservice.domain.email.dto.EmailSendingDto;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MailSenderByGoogle {
  private final JavaMailSender javaMailSender;

  public String sendMailFormattingHtml(EmailSendingDto sendingDto){
    MimeMessage message = javaMailSender.createMimeMessage();

    try {
      MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, false, "UTF-8");
      mimeMessageHelper.setTo( sendingDto.getAddress() );
      mimeMessageHelper.setSubject(sendingDto.getTitle() );
      mimeMessageHelper.setText( sendingDto.getMessage(), true);
      javaMailSender.send(message);
    } catch (MessagingException e) {
      log.info(e.getMessage());
      return e.getMessage();
    }

    return "success";
  }
}
