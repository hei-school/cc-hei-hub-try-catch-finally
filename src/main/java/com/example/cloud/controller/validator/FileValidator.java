package com.example.cloud.controller.validator;

import com.example.cloud.model.exception.BadFileTypeException;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class FileValidator {
  public void checkFileType(String filename) {
    int lastIndexOfDot = filename.lastIndexOf(".");
    if (lastIndexOfDot == -1) {
      throw new BadFileTypeException("Filename does not have an extension");
    }
    String fileType = filename.substring(lastIndexOfDot + 1);
    List<String> expectedType = List.of("mp4", "pdf", "jpg");
    if (!expectedType.contains(fileType)) {
      throw new BadFileTypeException("Bad file type");
    }
  }
}
