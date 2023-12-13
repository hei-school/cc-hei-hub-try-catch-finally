package com.example.cloud.model.exception;

import static com.example.cloud.model.exception.ApiException.ExceptionType.CLIENT_EXCEPTION;

public class BadFileTypeException extends ApiException{
  public BadFileTypeException(String message) {
    super(CLIENT_EXCEPTION, message);
  }
}
