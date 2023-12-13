package com.example.cloud.model.exception;

import static com.example.cloud.model.exception.ApiException.ExceptionType.SERVER_EXCEPTION;


public class CorruptedFileException extends ApiException {
  public CorruptedFileException(String message) {
    super(SERVER_EXCEPTION, message);
  }
}
