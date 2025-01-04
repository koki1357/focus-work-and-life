package com.example.readtodomanager.service.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UpdateMemoServiceInDto {
    @NotNull
    private Long id;
    @NotEmpty
    private String userId;
    @Size(min = 1, max = 100)
    private String content;
}
