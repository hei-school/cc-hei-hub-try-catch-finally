package com.example.cloud.service.utils;

import com.example.cloud.model.exception.DuplicateFileException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class FileUtils {
  public void checkDuplicatedFile(String dir, String filename) throws IOException {
    Set<String> filesDirectory = listOfFilesInDirectory(getUploadDirectory(dir));
    if(filesDirectory.contains(filename)) {
      throw new DuplicateFileException("filename with: " + filename + " already exist");
    }
  }

  public Set<String> listOfFilesInDirectory(String dir) throws IOException {
    try(Stream<Path> stream = Files.list(Paths.get(dir))) {
      return stream
          .filter(file -> !Files.isDirectory(file))
          .map(Path::getFileName)
          .map(Path::toString)
          .collect(Collectors.toSet());
    }
  }

  public String getUploadDirectory(String dynamicPath) throws IOException{
    return new ClassPathResource("static/"+dynamicPath).getFile().getAbsolutePath();
  }
}
