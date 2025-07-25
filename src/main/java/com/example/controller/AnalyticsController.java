package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @GetMapping("/dashboard")
    public ResponseEntity<String> getDashboardAnalytics() {
        String analyticsData = "{\"users\": 150, \"jobsPosted\": 25, \"applications\": 300}";
        return ResponseEntity.ok(analyticsData);
    }
}