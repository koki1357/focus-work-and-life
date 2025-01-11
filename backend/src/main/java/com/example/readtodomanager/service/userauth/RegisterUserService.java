package com.example.readtodomanager.service.userauth;

import org.springframework.http.ResponseEntity;

import com.example.readtodomanager.common.ApiResponse;
import com.example.readtodomanager.service.userauth.dto.RegisterUserServiceInDto;

public interface RegisterUserService {
    public ResponseEntity<ApiResponse<?>> registerUser(RegisterUserServiceInDto inDto);
}
