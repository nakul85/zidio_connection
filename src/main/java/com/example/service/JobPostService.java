package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.JobPost;
import com.example.repository.JobPostRepository;

@Service
public class JobPostService {

    @Autowired
    private JobPostRepository jobPostRepository;

    public List<JobPost> findAll() {
        return jobPostRepository.findAll();
    }

    public JobPost save(JobPost jobPost) {
        return jobPostRepository.save(jobPost);
    }
}