package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {


    public boolean authenticateUser(String username, String password) {
        // Placeholder authentication logic
        System.out.println("Attempting to authenticate user: " + username);
        
        return true; 
    }
}