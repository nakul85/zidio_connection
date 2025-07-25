package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Recruiter;
import com.example.service.RecruiterService;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @PostMapping("/create")
    public ResponseEntity<Recruiter> createRecruiter(@RequestBody Recruiter recruiter) {
        Recruiter savedRecruiter = recruiterService.save(recruiter);
        return ResponseEntity.ok(savedRecruiter);
    }
}