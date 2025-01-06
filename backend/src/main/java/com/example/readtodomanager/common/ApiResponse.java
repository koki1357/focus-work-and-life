package com.example.readtodomanager.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiResponse<T> {
    private int statusCode;
    private String message;
    private T data;

    // Default constructor for Jackson
    public ApiResponse() {}

    @JsonCreator
    public ApiResponse(
        @JsonProperty("statusCode") int statusCode,
        @JsonProperty("message") String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ApiResponse(
        @JsonProperty("statusCode") int statusCode,
        @JsonProperty("message") String message,
        @JsonProperty("data") T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
}
