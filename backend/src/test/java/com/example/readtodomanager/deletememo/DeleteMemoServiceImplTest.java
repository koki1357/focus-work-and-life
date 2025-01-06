package com.example.readtodomanager.deletememo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.example.readtodomanager.common.StatusCode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.example.readtodomanager.common.ApiResponse;
import com.example.readtodomanager.model.Memo;
import com.example.readtodomanager.repository.MemoRepository;
import com.example.readtodomanager.service.DeleteMemoService;
import com.example.readtodomanager.service.dto.DeleteMemoServiceInDto;

// 時間の都合上、一部のテストのみ実装
@SpringBootTest
@ActiveProfiles("test")
public class DeleteMemoServiceImplTest {
    // All test methods have been removed as they are not in the allowed list
}
