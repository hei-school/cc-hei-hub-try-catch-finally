package com.example.cloud.service.utils;

import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class FileUtils {
  public String getUploadDirectory(String dynamicPath) throws IOException{
    return new ClassPathResource("static/"+dynamicPath).getFile().getAbsolutePath();
  }
}
