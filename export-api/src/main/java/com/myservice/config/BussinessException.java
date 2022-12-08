package com.myservice.config;

import lombok.Getter;

@Getter
public class BussinessException extends RuntimeException{

  private String errorMessage;

  public BussinessException(String message) {
    super(message);
    this.errorMessage = message;
  }
}
