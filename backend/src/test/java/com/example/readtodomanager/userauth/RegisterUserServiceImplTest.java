// package com.example.readtodomanager.userauth;

// import static org.junit.jupiter.api.Assertions.assertNotEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import org.junit.jupiter.api.Test;
// import org.mindrot.jbcrypt.BCrypt;
// import org.springframework.beans.factory.annotation.Autowired;

// import com.example.readtodomanager.model.User;
// import com.example.readtodomanager.repository.UserRepository;
// import com.example.readtodomanager.service.userauth.RegisterUserService;
// import com.example.readtodomanager.service.userauth.dto.RegisterUserServiceInDto;

// public class RegisterUserServiceImplTest {

//     @Autowired
//     private RegisterUserService service;
    
//     @Autowired
//     private UserRepository userRepository;

//     @Test
//     public void testRegisterUser_パスワードがハッシュ化されて保存されること() {    
//         // Given
//         RegisterUserServiceInDto inDto = new RegisterUserServiceInDto();
//         inDto.setUserId("test_user");
//         inDto.setPassword("test_password");

//         // When
//         service.registerUser(inDto);

//         // Then
//         User savedUser = userRepository.getUser("test_user");
//         String hashedPassword = savedUser.getPassword();

//         // BCryptの形式チェック
//         assertTrue(hashedPassword.startsWith("$2a$"));
//         assertNotEquals("test_password", hashedPassword);
//     }

//     @Test
//     public void testRegisterUser_ハッシュ化されたパスワードが検証可能なこと() {
//         // Given
//         RegisterUserServiceInDto inDto = new RegisterUserServiceInDto();
//         inDto.setUserId("test_user");
//         inDto.setPassword("test_password");

//         // When
//         service.registerUser(inDto);

//         // Then
//         User savedUser = userRepository.getUser("test_user");
//         String hashedPassword = savedUser.getPassword();

//         // 元のパスワードで検証できることを確認
//         assertTrue(BCrypt.checkpw("test_password", hashedPassword));
//     }
// }
