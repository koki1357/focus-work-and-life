package com.example.readtodomanager.util;

import org.mindrot.jbcrypt.BCrypt;

public class GeneratePasswordHash {
    public static void main(String[] args) {
        String password = "password";
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println("BCrypt hash for 'password': " + hashedPassword);
    }
}
