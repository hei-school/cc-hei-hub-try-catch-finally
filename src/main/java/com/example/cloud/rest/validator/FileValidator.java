package com.example.cloud.rest.validator;

import com.example.cloud.model.FileModel;
import com.example.cloud.model.exception.BadFileTypeException;
import com.example.cloud.model.exception.FileTooLargeException;
import com.example.cloud.model.exception.InvalidFileNameException;
import com.example.cloud.model.exception.SensitiveFileException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileValidator {
  private static final String FILE_NAME_PREFIX = "Document_";

  public void accept(FileModel fileModel) {
    checkFileName(fileModel.getFilename());
    checkFileSize(fileModel.getFile());
    checkFileType(fileModel.getFile());
    checkFileSensibility(fileModel.getFile());
  }

  public void checkFileSize(MultipartFile file) {
    long fileSizeInBytes = file.getSize();
    long fileSizeInMB = fileSizeInBytes / (1024 * 1024);

    if (fileSizeInMB > 10) {
      throw new FileTooLargeException("File size must be less than or equal to 10MB");
    }
  }

  public void checkFileType(MultipartFile multipartFile) {
    List<String> expectedFileType = List.of(
        "video/mp4", "video/quicktime", "video/x-msvideo", "video/x-matroska",
        "application/pdf", "image/png", "image/jpeg",
        "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "text/csv");
    if (!expectedFileType.contains(multipartFile.getContentType())) {
      throw new BadFileTypeException("Unsupported file type: " + multipartFile.getContentType());
    }
  }

  public void checkFileSensibility(MultipartFile multipartFile) {
    String content = "";
    try {
      content = new String(multipartFile.getBytes(), StandardCharsets.UTF_8);
    } catch (IOException e) {

    }
    List<String> expectedOriginalFilename = List.of("password", "psswd",
        "bank", "ar", "ariary",
        "franc", "frc");
    if (expectedOriginalFilename.contains(multipartFile.getOriginalFilename().toLowerCase())) {
      throw new SensitiveFileException("Sensitive file");
    }
    if (content.contains("password") || content.contains("bank")) {
      throw new SensitiveFileException("Sensitive file");
    }
  }

  public void checkFileName(String filename) {
    if (!filename.startsWith(FILE_NAME_PREFIX)) {
      throw new InvalidFileNameException("Filename should start with \"" + FILE_NAME_PREFIX + "\"");
    }
  }
}
