package com.example.readtodomanager.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiResponse<T> {
    @JsonProperty("status")
    private int statusCode;
    private String message;
    private T data;

    @JsonCreator
    public ApiResponse(
        @JsonProperty("status") int statusCode,
        @JsonProperty("message") String message,
        @JsonProperty("data") T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> of(int statusCode, String message) {
        return new ApiResponse<>(statusCode, message, null);
    }

    public static <T> ApiResponse<T> of(int statusCode, String message, T data) {
        return new ApiResponse<>(statusCode, message, data);
    }
}
