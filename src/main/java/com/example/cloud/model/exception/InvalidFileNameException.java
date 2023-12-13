package com.example.cloud.model.exception;

import static com.example.cloud.model.exception.ApiException.ExceptionType.SERVER_EXCEPTION;


public class InvalidFileNameException extends ApiException {
  public InvalidFileNameException(String message) {
    super(SERVER_EXCEPTION, message);
  }
}
