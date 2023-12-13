package com.example.cloud.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
@Builder
public class FileModel {
  private String filename;
  private MultipartFile file;
}
