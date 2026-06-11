package com.java.real.chatRepository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.java.real.chatEntity.UserPhone;

public interface UserPhoneRepository extends JpaRepository<UserPhone, Long> {

    UserPhone findByPhoneNumber(String phoneNumber);
}