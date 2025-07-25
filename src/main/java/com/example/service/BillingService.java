package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class BillingService {
    
    public void processBillingForUser(Long userId) {
        System.out.println("Processing billing for user ID: " + userId);
    }
}