package com.java.real.chatService;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.real.chatEntity.Otp;
import com.java.real.chatEntity.UserPhone;
import com.java.real.chatRepository.ChatOtpRepository;
import com.java.real.chatRepository.UserPhoneRepository;

@Service
public class AuthService {

    @Autowired
    private ChatOtpRepository otpRepository;

    @Autowired
    private UserPhoneRepository userRepo;

    public boolean verifyOtp(String phone, String otp) {

        Optional<Otp> record =
            otpRepository.findByPhoneNumberAndOtp(phone, otp);

        if (record.isPresent()) {

            if (record.get().getExpiryTime().isAfter(LocalDateTime.now())) {

                // create user if not exists
                userRepo.findByPhoneNumber(phone)
                        .orElseGet(() -> {
                            UserPhone u = new UserPhone();
                            u.setPhoneNumber(phone);
                            u.setName("User-" + phone);
                            return userRepo.save(u);
                        });

                otpRepository.deleteByPhoneNumber(phone);

                return true;
            }
        }
        return false;
    }
}