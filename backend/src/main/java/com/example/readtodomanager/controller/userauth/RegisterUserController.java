package com.example.readtodomanager.controller.userauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.readtodomanager.common.ApiResponse;
import com.example.readtodomanager.controller.userauth.dto.RegisterUserControllerInDto;
import com.example.readtodomanager.service.userauth.RegisterUserService;
import com.example.readtodomanager.service.userauth.dto.RegisterUserServiceInDto;

@RestController
@RequestMapping("/api/auth")
public class RegisterUserController {

    @Autowired
    private RegisterUserService registerUserService;

    @PostMapping("/user")
    public ResponseEntity<ApiResponse<?>> registerUser(@RequestBody RegisterUserControllerInDto request) {
        RegisterUserServiceInDto inDto = new RegisterUserServiceInDto();
        inDto.setUserId(request.getUserId());
        inDto.setPassword(request.getPassword());
        
        return registerUserService.registerUser(inDto);
    }
}
