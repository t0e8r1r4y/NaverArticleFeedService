package com.myservice.domain.email.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailSendingDto {
  private String address;
  private String title;
  private String message;

  public static EmailSendingDto of(final String address, final String title, final String message){
    return new EmailSendingDto(address, title, message);
  }

  private EmailSendingDto(final String address, final String title, final String message){
    this.address = address;
    this.title = title;
    this.message = message;
  }
}
