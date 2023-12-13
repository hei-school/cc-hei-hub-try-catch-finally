package com.example.cloud.service;

import com.example.cloud.model.exception.ApiException;
import com.example.cloud.model.exception.FileNotFoundException;
import com.example.cloud.service.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static com.example.cloud.model.exception.ApiException.ExceptionType.SERVER_EXCEPTION;

@Service
@AllArgsConstructor
public class FileService {
  private final FileUtils utils;

  public String uploadFile(MultipartFile multipartFile, String dir, String filename)
      throws Exception {

    boolean response = false;
    try {
      utils.checkDuplicatedFile(dir, filename);

      Files.copy(
          multipartFile.getInputStream(),
          Paths.get(utils.getUploadDirectory(dir) + File.separator + filename),
          StandardCopyOption.REPLACE_EXISTING);
      response = true;
    }
    catch (IOException e) {
      throw new ApiException(SERVER_EXCEPTION, e.getMessage());
    }
    if (response) {
      return filename;
    }
    return null;
  }

  public byte[] downloadFile(String fileName, String dir) {
    Path FILE;
    try{
      FILE = Paths.get(utils.getUploadDirectory(dir) + File.separator + fileName);
    }
    catch (IOException e) {
      throw new FileNotFoundException("file with name " + fileName + " not found");
    }
    try {
      return Files.readAllBytes(FILE);
    }
    catch (IOException e) {
      throw new ApiException(SERVER_EXCEPTION, e.getMessage());
    }
  }
}
