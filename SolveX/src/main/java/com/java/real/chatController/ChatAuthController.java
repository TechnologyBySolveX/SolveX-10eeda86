package com.java.real.chatController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.real.chatService.AuthService;
import com.java.real.chatService.OtpService;

@RestController
@RequestMapping("/auth")
public class ChatAuthController {

    @Autowired
    private OtpService otpService;

    @Autowired
    private AuthService authService;

    @PostMapping("/send-otp")
    public String sendOtp(@RequestParam String phone) {
        otpService.generateOtp(phone);
        return "OTP Sent!";
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam String phone,
                            @RequestParam String otp) {

        if (authService.verifyOtp(phone, otp)) {
            return "Login Success";
        }
        return "Invalid OTP";
    }
}