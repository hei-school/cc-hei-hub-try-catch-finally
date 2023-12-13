package com.example.cloud.model;

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
  private FilePermission permission;

  public enum FilePermission {
    LOCKED, LEGAL_REASON
  }

}
