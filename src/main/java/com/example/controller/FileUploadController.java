package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Student;
import com.example.service.FileUploadService;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/upload/resume")
    public ResponseEntity<String> uploadResume(@RequestParam("studentId") Long studentId, @RequestParam("file") MultipartFile file) {
        try {
            Student student = studentService.findById(studentId)
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            byte[] resumeBytes = fileUploadService.processFile(file);
            student.setResume(resumeBytes);
            studentService.save(student);
            return ResponseEntity.ok("Resume uploaded successfully for student: " + studentId);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
        }
    }
}