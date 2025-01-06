package com.example.readtodomanager.login;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.example.readtodomanager.common.ApiResponse;
import com.example.readtodomanager.common.StatusCode;
import com.example.readtodomanager.controller.dto.RegisterUserControllerInDto;
import com.example.readtodomanager.model.User;
import com.example.readtodomanager.repository.UserRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = {"/login/schema.sql", "/login/data.sql"})
public class RegisterUserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testRegisterUser_Success() {
        // given
        RegisterUserControllerInDto request = new RegisterUserControllerInDto();
        request.setUserId("newuser");
        request.setPassword("testpass");

        // when
        ResponseEntity<ApiResponse<?>> response = restTemplate.postForEntity(
            "/api/auth/user", request, (Class<ApiResponse<?>>)(Object)ApiResponse.class);

        // Debug output
        System.out.println("Response status: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody());

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        
        // verify user was created in DB
        User createdUser = userRepository.getUser("newuser");
        assertThat(createdUser).isNotNull();
        assertThat(createdUser.getUserId()).isEqualTo("newuser");
        // verify password was hashed with BCrypt
        assertThat(BCrypt.checkpw("testpass", createdUser.getPassword())).isTrue();
    }

    @Test
    public void testRegisterUser_DuplicateUser() {
        // given - use existing user from data.sql
        RegisterUserControllerInDto request = new RegisterUserControllerInDto();
        request.setUserId("testuser");
        request.setPassword("newpass");

        // when
        ResponseEntity<ApiResponse<?>> response = restTemplate.postForEntity(
            "/api/auth/user", request, (Class<ApiResponse<?>>)(Object)ApiResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        ApiResponse<?> body = response.getBody();
        assertThat(body).isNotNull();
        assertThat(body.getStatusCode()).isEqualTo(400);
        assertThat(body.getMessage()).isEqualTo("すでに登録されているユーザです");
    }

    @Test
    public void testRegisterUser_InvalidRequest() {
        // given - missing required userId
        RegisterUserControllerInDto request = new RegisterUserControllerInDto();
        request.setPassword("testpass");

        // when
        ResponseEntity<ApiResponse<?>> response = restTemplate.postForEntity(
            "/api/auth/user", request, (Class<ApiResponse<?>>)(Object)ApiResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        ApiResponse<?> body = response.getBody();
        assertThat(body).isNotNull();
        assertThat(body.getStatusCode()).isEqualTo(400);
        assertThat(body.getMessage()).isEqualTo("不正なリクエストです");
    }
}
