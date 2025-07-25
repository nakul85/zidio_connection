package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Enum.UserPaymentStatus;

@RestController
@RequestMapping("/api/payments/status")
public class UserPaymentStatusController {

    @GetMapping
    public ResponseEntity<UserPaymentStatus[]> getAllPaymentStatuses() {
        return ResponseEntity.ok(UserPaymentStatus.values());
    }
}