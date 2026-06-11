package com.java.real.chatRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.real.chatEntity.ChatMessage;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    List<ChatMessage> findBySenderPhoneAndReceiverPhone(String sender, String receiver);

    List<ChatMessage> findByReceiverPhone(String receiver);
}