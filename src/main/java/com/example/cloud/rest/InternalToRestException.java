package com.example.cloud.rest;

import com.example.cloud.model.exception.ApiException;
import com.example.cloud.model.exception.DuplicateFileException;
import com.example.cloud.model.exception.InsufficientCloudStorageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InternalToRestException {

  @ExceptionHandler({DuplicateFileException.class})
  public ResponseEntity<?> toRest(DuplicateFileException e) {
    return mapToRest(e, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({InsufficientCloudStorageException.class})
  public ResponseEntity<?> toRest(InsufficientCloudStorageException e) {
    return mapToRest(e, HttpStatus.INSUFFICIENT_STORAGE);
  }


  private ResponseEntity<?> mapToRest(ApiException e, HttpStatus status) {
    return new ResponseEntity<>(e.getMessage(), status);
  }
}
