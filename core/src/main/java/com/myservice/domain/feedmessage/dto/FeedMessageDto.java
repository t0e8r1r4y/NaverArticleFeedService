package com.myservice.domain.feedmessage.dto;

import com.myservice.domain.email.entity.Email;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeedMessageDto {
  private UUID userId;
  private String userName;
  private String address;
  private String title;
  private String body;

  private Boolean sendResult;

  public static FeedMessageDto of(final UUID userId, final String userName, final String address,
      final String title, final String body, final Boolean sendResult){
    return new FeedMessageDto(userId, userName, address, title, body, sendResult);
  }

  private FeedMessageDto(final UUID userId, final String userName, final String address,
      final String title, final String body, final Boolean sendResult) {
    this.userId = userId;
    this.userName = userName;
    this.address = address;
    this.title = title;
    this.body = body;
    this.sendResult = sendResult;
  }

  public Email toEmailEntity(){
    return Email.of(this.address, this.title, this.body, this.userId, this.sendResult);
  }

  public void setSendResult(Boolean result){
    this.sendResult = result;
  }
}
