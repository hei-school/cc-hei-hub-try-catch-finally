package com.example.cloud.service;

import com.example.cloud.service.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class FileService {
  private final FileUtils utils;
  public void uploadFile(MultipartFile multipartFile, String path) {
    boolean response = false;
    try {
      Files.copy(
          multipartFile.getInputStream(),
          Paths.get(utils.getUploadDirectory(path) + File.separator + multipartFile.getOriginalFilename()));
      response = true;
    }
    catch (IOException e) {

    }
  }

  @SneakyThrows
  public byte[] downloadFile(String fileName, String fileType, String path) {
    Path FILE = Paths.get(utils.getUploadDirectory(path) + File.separator + fileName + fileType);
    return Files.readAllBytes(FILE);
  }
}
