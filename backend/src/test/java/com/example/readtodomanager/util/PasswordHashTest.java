package com.example.readtodomanager.util;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashTest {
    
    @Test
    public void generatePasswordHash() {
        String password = "testpass";
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        
        // Write hash to a file for easier access
        String outputPath = "/tmp/password_hash.txt";
        try {
            java.nio.file.Files.writeString(java.nio.file.Path.of(outputPath),
                String.format("Password: %s\nHash: %s\n", password, hashedPassword));
            
            // Verify the hash works
            boolean matches = BCrypt.checkpw(password, hashedPassword);
            java.nio.file.Files.writeString(java.nio.file.Path.of(outputPath),
                String.format("Password: %s\nHash: %s\nVerification: %s\n", 
                    password, hashedPassword, matches ? "PASS" : "FAIL"));
                    
            // Also verify the hash in data.sql
            String currentHash = "$2a$10$6pGBgfXGwH.jVIaJD3yrJO3KxuRkUQ/aRrxeF1aXGsW0FZ9p8RrxO";
            boolean currentMatches = BCrypt.checkpw(password, currentHash);
            java.nio.file.Files.writeString(java.nio.file.Path.of(outputPath),
                String.format("Password: %s\nNew Hash: %s\nCurrent Hash: %s\nNew Hash Verification: %s\nCurrent Hash Verification: %s\n", 
                    password, hashedPassword, currentHash,
                    matches ? "PASS" : "FAIL",
                    currentMatches ? "PASS" : "FAIL"));
        } catch (java.io.IOException e) {
            throw new RuntimeException("Failed to write hash to file", e);
        }
    }
}
