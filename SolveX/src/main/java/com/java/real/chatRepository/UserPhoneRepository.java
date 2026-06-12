package com.java.real.chatRepository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.real.chatEntity.UserPhone;

public interface UserPhoneRepository extends JpaRepository<UserPhone, Long> {

	Optional<UserPhone> findByPhoneNumber(String phoneNumber);
}