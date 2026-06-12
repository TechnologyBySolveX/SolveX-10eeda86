package com.java.real.chatRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.real.chatEntity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySenderAndReceiverOrSenderAndReceiver(
        String sender1, String receiver1,
        String sender2, String receiver2
    );
}