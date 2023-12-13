package com.example.cloud.model.exception;

import static com.example.cloud.model.exception.ApiException.ExceptionType.SERVER_EXCEPTION;


public class InsufficientCloudStorageException extends ApiException {
  public InsufficientCloudStorageException(String message) {
    super(SERVER_EXCEPTION, message);
  }
}
