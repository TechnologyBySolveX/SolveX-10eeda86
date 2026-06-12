package com.java.real.chatService;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.real.chatEntity.Otp;
import com.java.real.chatRepository.ChatOtpRepository;

@Service
public class OtpService {

    @Autowired
    private ChatOtpRepository otpRepository;

    public void generateOtp(String phoneNumber) {

        String otp = String.valueOf((int)(Math.random() * 900000) + 100000);

        otpRepository.deleteByPhoneNumber(phoneNumber);

        Otp otpEntity = new Otp();
        otpEntity.setPhoneNumber(phoneNumber);
        otpEntity.setOtp(otp);
        otpEntity.setExpiryTime(LocalDateTime.now().plusMinutes(2));

        otpRepository.save(otpEntity);

        System.out.println("OTP: " + otp); // simulate SMS
    }
}