package com.example.cloud.model.exception;

import static com.example.cloud.model.exception.ApiException.ExceptionType.CLIENT_EXCEPTION;


public class LegalReasonException extends ApiException {
  public LegalReasonException(String message) {
    super(CLIENT_EXCEPTION, message);
  }
}
