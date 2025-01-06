package com.example.readtodomanager.login;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.example.readtodomanager.common.StatusCode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class LoginControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    @Sql(scripts = {"/login/schema.sql", "/login/data.sql"})
    void 正常系_ユーザとパスワードが正しい場合_ログインに成功すること() throws Exception {
        // Arrange
        String requestJson = "{\"userId\":\"testuser\",\"password\":\"testpass\"}";
        
        // Act & Assert
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(StatusCode.OK))
            .andExpect(jsonPath("$.message").value("OK"))
            .andExpect(jsonPath("$.data.token").exists())
            .andExpect(jsonPath("$.data.userId").value("testuser"));
    }
    
    @Test
    @Sql(scripts = {"/login/schema.sql", "/login/data.sql"})
    void 異常系_パスワードが間違っている場合_エラーが返ること() throws Exception {
        // Arrange
        String requestJson = "{\"userId\":\"testuser\",\"password\":\"wrongpass\"}";
        
        // Act & Assert
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.status").value(StatusCode.BAD_REQUEST))
            .andExpect(jsonPath("$.message").value("ユーザIDもしくはパスワードが間違っています"))
            .andExpect(jsonPath("$.data").doesNotExist());
    }
    
    @Test
    @Sql(scripts = {"/login/schema.sql", "/login/data.sql"})
    void 異常系_存在しないユーザの場合_エラーが返ること() throws Exception {
        // Arrange
        String requestJson = "{\"userId\":\"nonexistentuser\",\"password\":\"anypass\"}";
        
        // Act & Assert
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.status").value(StatusCode.BAD_REQUEST))
            .andExpect(jsonPath("$.message").value("ユーザIDもしくはパスワードが間違っています"))
            .andExpect(jsonPath("$.data").doesNotExist());
    }
}
