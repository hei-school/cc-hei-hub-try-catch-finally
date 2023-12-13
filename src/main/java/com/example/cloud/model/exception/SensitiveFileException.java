package com.example.cloud.model.exception;

import static com.example.cloud.model.exception.ApiException.ExceptionType.CLIENT_EXCEPTION;

public class SensitiveFileException extends ApiException{
  public SensitiveFileException(String message) {
    super(CLIENT_EXCEPTION,message);
  };
}
