package com.example.cloud.integration;

import com.example.cloud.CloudApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = CloudApplication.class)
@AutoConfigureMockMvc
public class FileControllerIT {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void upload_duplicate_file_ko() throws Exception {
    this.mockMvc.perform(get("/upload")) //Set according the situation
        .andExpect(status().isBadRequest());
  }

  @Test
  void insufficient_storage() throws Exception {
    this.mockMvc.perform(get("/upload")) //Set according the situation
        .andExpect(status().isInsufficientStorage());
  }

}
