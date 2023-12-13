package com.example.cloud.model.exception;

import static com.example.cloud.model.exception.ApiException.ExceptionType.SERVER_EXCEPTION;

public class NotImplementedException extends ApiException{
  public NotImplementedException(String message) {
    super(SERVER_EXCEPTION, message);
  }
}
