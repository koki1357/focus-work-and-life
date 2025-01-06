package com.example.readtodomanager.util;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashTest {
    
    @Test
    public void generatePasswordHash() {
        String password = "password";
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        // Use System.err for better visibility in Gradle test output
        System.err.println("\n=== GENERATED HASH ===");
        System.err.println(hashedPassword);
        System.err.println("=== END HASH ===\n");
    }
}
