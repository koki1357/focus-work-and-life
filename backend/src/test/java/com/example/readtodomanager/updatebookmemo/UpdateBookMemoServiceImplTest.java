package com.example.readtodomanager.updatebookmemo;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.example.readtodomanager.common.ApiResponse;
import com.example.readtodomanager.model.Memo;
import com.example.readtodomanager.repository.MemoRepository;
import com.example.readtodomanager.service.UpdateMemoService;
import com.example.readtodomanager.service.dto.UpdateMemoServiceInDto;

@SpringBootTest
@ActiveProfiles("test")
public class UpdateBookMemoServiceImplTest {
    // All test methods have been removed as they are not in the allowed list
}
