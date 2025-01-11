package com.example.readtodomanager.service.userauth;

import org.springframework.http.ResponseEntity;

import com.example.readtodomanager.common.ApiResponse;
import com.example.readtodomanager.service.userauth.dto.LogoutInDto;

public interface LogoutService {
    public ResponseEntity<ApiResponse<?>> logout(LogoutInDto request);
}
