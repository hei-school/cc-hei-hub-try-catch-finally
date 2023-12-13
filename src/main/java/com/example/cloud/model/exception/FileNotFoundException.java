package com.example.cloud.model.exception;

import static com.example.cloud.model.exception.ApiException.ExceptionType.SERVER_EXCEPTION;

public class FileNotFoundException extends ApiException{
  public FileNotFoundException(String message) {
    super(SERVER_EXCEPTION, message);
  }
}
