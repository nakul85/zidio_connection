package com.example.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Application;
import com.example.entity.JobPost;
import com.example.entity.Student;
import com.example.service.ApplicationService;
import com.example.service.JobPostService;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private JobPostService jobPostService;

    @PostMapping("/apply")
    public ResponseEntity<Application> applyForJob(@RequestParam Long studentId, @RequestParam Long jobPostId) {
        Student student = studentService.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        JobPost jobPost = jobPostService.findAll().stream().filter(j -> j.getId().equals(jobPostId)).findFirst().orElseThrow(() -> new RuntimeException("Job Post not found"));

        Application application = new Application();
        application.setStudent(student);
        application.setJobPost(jobPost);
        application.setApplicationDate(LocalDate.now());
        application.setStatus("APPLIED");

        Application savedApplication = applicationService.save(application);
        return ResponseEntity.ok(savedApplication);
    }
}