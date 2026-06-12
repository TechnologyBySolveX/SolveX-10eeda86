package com.java.real.chatRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.real.chatEntity.Otp;

public interface ChatOtpRepository extends JpaRepository<Otp, Long> {
    Optional<Otp> findByPhoneNumberAndOtp(String phoneNumber, String otp);

    void deleteByPhoneNumber(String phoneNumber);
}