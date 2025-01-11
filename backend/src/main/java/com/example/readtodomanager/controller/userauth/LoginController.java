package com.example.readtodomanager.controller.userauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.readtodomanager.common.ApiResponse;
import com.example.readtodomanager.controller.userauth.dto.LoginControllerInDto;
import com.example.readtodomanager.model.LoginResponse;
import com.example.readtodomanager.service.userauth.LoginService;
import com.example.readtodomanager.service.userauth.dto.LoginServiceInDto;


@RestController
@RequestMapping("/api/auth")
public class LoginController {
    
    @Autowired
    private LoginService loginService;
    
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginControllerInDto authRequest) {

        LoginServiceInDto loginServiceInDto = new LoginServiceInDto();
        loginServiceInDto.setUserId(authRequest.getUserId());
        loginServiceInDto.setPassword(authRequest.getPassword());
        return loginService.login(loginServiceInDto);
    }
}