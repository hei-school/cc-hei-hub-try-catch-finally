package com.example.cloud.model.exception;

import static com.example.cloud.model.exception.ApiException.ExceptionType.CLIENT_EXCEPTION;

public class FileTooLargeException extends ApiException{
  public FileTooLargeException(String message) {
    super(CLIENT_EXCEPTION, message);
  }
}
