package com.example.cloud.model.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class ApiException extends RuntimeException{
  private ExceptionType type;

  public ApiException(ExceptionType type, String message){
    super(message);
    this.type = type;
  }

  public enum ExceptionType{
    CLIENT_EXCEPTION, SERVER_EXCEPTION
  }
}
