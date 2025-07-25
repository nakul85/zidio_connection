package com.example.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Enum.UserPaymentStatus;
import com.example.entity.Payment;
import com.example.entity.User;
import com.example.repository.PaymentRepository;
import com.example.repository.UserRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RazorPayService razorPayService;

    public Payment createPayment(Long userId, Double amount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String orderId = razorPayService.createOrder(amount, "INR");

        Payment payment = new Payment();
        payment.setUser(user);
        payment.setAmount(amount);
        payment.setRazorpayOrderId(orderId);
        payment.setStatus(UserPaymentStatus.PENDING);
        payment.setPaymentDate(LocalDateTime.now());

        return paymentRepository.save(payment);
    }
}
