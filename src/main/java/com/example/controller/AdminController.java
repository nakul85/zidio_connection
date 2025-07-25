package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AdminUser;
import com.example.entity.User;
import com.example.service.AdminUserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/create")
    public ResponseEntity<User> createAdminUser(@RequestBody AdminUser adminUser) {
        User createdUser = adminUserService.createAdmin(adminUser);
        return ResponseEntity.ok(createdUser);
    }
}
