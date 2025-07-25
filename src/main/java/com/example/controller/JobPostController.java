package com.example.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.JobPost;
import com.example.entity.Recruiter;
import com.example.repository.RecruiterRepository;
import com.example.service.JobPostService;

@RestController
@RequestMapping("/api/jobposts")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    @Autowired
    private RecruiterRepository recruiterRepository;

    @PostMapping("/create")
    public ResponseEntity<JobPost> createJobPost(@RequestBody JobPost jobPost, @RequestParam Long recruiterId) {
        Recruiter recruiter = recruiterRepository.findById(recruiterId)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));
        jobPost.setRecruiter(recruiter);
        jobPost.setPostDate(LocalDate.now());
        JobPost savedJobPost = jobPostService.save(jobPost);
        return ResponseEntity.ok(savedJobPost);
    }

    @GetMapping
    public ResponseEntity<List<JobPost>> getAllJobPosts() {
        List<JobPost> jobPosts = jobPostService.findAll();
        return ResponseEntity.ok(jobPosts);
    }
}