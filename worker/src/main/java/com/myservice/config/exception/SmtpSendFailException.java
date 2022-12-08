package com.myservice.config.exception;

import lombok.Getter;

@Getter
public class SmtpSendFailException extends RuntimeException{

  private final String errorMessage;

  public SmtpSendFailException(String message) {
    super(message);
    this.errorMessage = message;
  }
}
