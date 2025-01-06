package com.example.readtodomanager.deletebook;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.readtodomanager.common.StatusCode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.example.readtodomanager.common.ApiResponse;
import com.example.readtodomanager.model.Book;
import com.example.readtodomanager.repository.BookRepository;
import com.example.readtodomanager.service.DeleteBookService;
import com.example.readtodomanager.service.dto.DeleteBookServiceInDto;

@SpringBootTest
@ActiveProfiles("test")
public class DeleteBookServiceImplTest {
    // All test methods have been removed as they are not in the allowed list
}
