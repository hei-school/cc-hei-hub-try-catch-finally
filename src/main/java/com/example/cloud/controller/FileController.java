package com.example.cloud.controller;

import com.example.cloud.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
public class FileController {
  private final FileService service;

  @PostMapping(
      value = "/file/{dynamic_path}",
      consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public void upload(
      @PathVariable(name = "dynamic_path")String dynamicPath,
      @RequestParam(name = "file")MultipartFile file) {
    service.uploadFile(file, dynamicPath);
  }

  @GetMapping(
      value = "/file/pdf",
      produces = {MediaType.APPLICATION_PDF_VALUE})
  public byte[] downloadPdf(@RequestParam(name = "file_name")String fileName) {
    return service.downloadFile(fileName, ".pdf", "pdf");
  }
}
