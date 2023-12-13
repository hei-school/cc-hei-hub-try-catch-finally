package com.example.cloud.controller.validator;

import com.example.cloud.model.exception.BadFileTypeException;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class FileValidator {
  public void checkFileType(String filename) {
    String[] fileType = filename.split(".");
    List<String> expectedType = List.of("mp4", "pdf", "jpg");
    if (!expectedType.contains(fileType[1])) {
      throw new BadFileTypeException("Bad file type");
    }
  }
}
