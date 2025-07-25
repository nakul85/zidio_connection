package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.AdminUser;
import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class AdminUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createAdmin(AdminUser adminUserDto) {
        User user = new User();
        user.setName(adminUserDto.getName());
        user.setEmail(adminUserDto.getEmail());
        user.setPassword(passwordEncoder.encode(adminUserDto.getPassword()));
        
        return userRepository.save(user);
    }
}