package com.example.cloud.model.exception;

import static com.example.cloud.model.exception.ApiException.ExceptionType.CLIENT_EXCEPTION;


public class DuplicateFileException extends ApiException {
  public DuplicateFileException(String message) {
    super(CLIENT_EXCEPTION, message);
  }
}
