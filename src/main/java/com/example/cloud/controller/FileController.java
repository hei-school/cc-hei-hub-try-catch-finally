package com.example.cloud.controller;

import com.example.cloud.controller.validator.FileValidator;
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
  private final FileValidator validator;

  @PostMapping(
      value = "/file/pdf}",
      consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public String uploadPdf(
      @RequestParam(name = "file")MultipartFile file,
      @RequestParam(name = "file_name")String filename) throws Exception {
    validator.checkFileType(filename);
    return service.uploadFile(file, "pdf", filename);
  }

  @PostMapping(
      value = "/file/img}",
      consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public String uploadImg(
      @RequestParam(name = "file")MultipartFile file,
      @RequestParam(name = "file_name")String filename) throws Exception {
    validator.checkFileType(filename);
    return service.uploadFile(file, "img", filename);
  }

  @PostMapping(
      value = "/file/video}",
      consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public String uploadVideo(
      @RequestParam(name = "file")MultipartFile file,
      @RequestParam(name = "file_name")String filename) throws Exception {
    validator.checkFileType(filename);
    return service.uploadFile(file, "video", filename);
  }

  @GetMapping(
      value = "/file/pdf",
      produces = {MediaType.APPLICATION_PDF_VALUE})
  public byte[] downloadPdf(@RequestParam(name = "file_name")String fileName) {
    return service.downloadFile(fileName, ".pdf", "pdf");
  }

  @GetMapping(
      value = "/file/img",
      produces = {MediaType.IMAGE_JPEG_VALUE})
  public byte[] downloadImg(@RequestParam(name = "file_name")String fileName) {
    return service.downloadFile(fileName, ".jpg", "img");
  }

  @GetMapping(
      value = "/file/video",
      produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
  public byte[] downloadVideo(@RequestParam(name = "file_name")String fileName) {
    return service.downloadFile(fileName, ".mp4", "video");
  }
}
