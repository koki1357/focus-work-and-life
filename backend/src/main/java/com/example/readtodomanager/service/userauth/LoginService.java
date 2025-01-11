package com.example.readtodomanager.service.userauth;

import org.springframework.http.ResponseEntity;

import com.example.readtodomanager.common.ApiResponse;
import com.example.readtodomanager.model.LoginResponse;
import com.example.readtodomanager.service.userauth.dto.LoginServiceInDto;

public interface LoginService {
    public ResponseEntity<ApiResponse<LoginResponse>> login(LoginServiceInDto loginServiceInDto);

}
