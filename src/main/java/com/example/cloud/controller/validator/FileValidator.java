package com.example.cloud.controller.validator;

import com.example.cloud.controller.model.FileModel;
import com.example.cloud.model.exception.BadFileTypeException;
import com.example.cloud.model.exception.FileTooLargeException;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileValidator {
  public void accept(FileModel fileModel) {
    checkFileSize(fileModel.getFile());
    checkFileType(fileModel.getFilename());
  }

  public void checkFileSize(MultipartFile file) {
    long fileSizeInBytes = file.getSize();
    double fileSizeInMB = fileSizeInBytes * 0.00000095367432;

    if (fileSizeInMB > 10) {
      throw new FileTooLargeException("File size must be less than or equal to 10MB");
    }
  }
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
