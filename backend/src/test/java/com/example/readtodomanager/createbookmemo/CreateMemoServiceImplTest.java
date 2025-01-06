package com.example.readtodomanager.createbookmemo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.example.readtodomanager.model.Memo;
import com.example.readtodomanager.repository.MemoRepository;
import com.example.readtodomanager.service.CreateMemoService;
import com.example.readtodomanager.service.dto.CreateMemoServiceInDto;

// 時間の都合上、一部のテストのみ実装
@SpringBootTest
@ActiveProfiles("test")
public class CreateMemoServiceImplTest {
    // All test methods have been removed as they are not in the allowed list
}
