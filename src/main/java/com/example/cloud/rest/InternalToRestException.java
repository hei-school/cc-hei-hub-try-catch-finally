package com.example.cloud.rest;

import com.example.cloud.model.exception.ApiException;
import com.example.cloud.model.exception.BadFileTypeException;
import com.example.cloud.model.exception.CorruptedFileException;
import com.example.cloud.model.exception.DuplicateFileException;
import com.example.cloud.model.exception.FileNotFoundException;
import com.example.cloud.model.exception.FileTooLargeException;
import com.example.cloud.model.exception.InsufficientCloudStorageException;
import com.example.cloud.model.exception.InvalidFileNameException;
import com.example.cloud.model.exception.LegalReasonException;
import com.example.cloud.model.exception.LockException;
import com.example.cloud.model.exception.NotImplementedException;
import com.example.cloud.model.exception.SensitiveFileException;
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

  @ExceptionHandler({BadFileTypeException.class})
  public ResponseEntity<?> toRest(BadFileTypeException e) {
    return mapToRest(e, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({FileNotFoundException.class})
  public ResponseEntity<?> toRest(FileNotFoundException e) {
    return mapToRest(e, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({FileTooLargeException.class})
  public ResponseEntity<?> toRest(FileTooLargeException e) {
    return mapToRest(e, HttpStatus.LOCKED);
  }

  @ExceptionHandler({NotImplementedException.class})
  public ResponseEntity<?> toRest(NotImplementedException e) {
    return mapToRest(e, HttpStatus.NOT_IMPLEMENTED);
  }

  @ExceptionHandler({SensitiveFileException.class})
  public ResponseEntity<?> toRest(SensitiveFileException e) {
    return mapToRest(e, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({InvalidFileNameException.class})
  public ResponseEntity<?> toRest(InvalidFileNameException e) {
    return mapToRest(e, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({LockException.class})
  public ResponseEntity<?> toRest(LockException e) {
    return mapToRest(e, HttpStatus.LOCKED);
  }

  @ExceptionHandler({LegalReasonException.class})
  public ResponseEntity<?> toRest(LegalReasonException e) {
    return mapToRest(e, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
  }

  @ExceptionHandler({CorruptedFileException.class})
  public ResponseEntity<?> toRest(CorruptedFileException e) {
    return mapToRest(e, HttpStatus.INTERNAL_SERVER_ERROR);
  }


  private ResponseEntity<?> mapToRest(ApiException e, HttpStatus status) {
    return new ResponseEntity<>(e.getMessage(), status);
  }

}
