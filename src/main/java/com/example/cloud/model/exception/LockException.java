package com.example.cloud.model.exception;

import static com.example.cloud.model.exception.ApiException.ExceptionType.CLIENT_EXCEPTION;

public class LockException extends ApiException{
  public LockException(String message) {
    super(CLIENT_EXCEPTION, message);
  }
}
