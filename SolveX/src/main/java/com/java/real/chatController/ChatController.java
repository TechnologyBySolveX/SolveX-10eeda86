package com.java.real.chatController;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.java.real.chatEntity.ChatMessage;
import com.java.real.chatRepository.ChatMessageRepository;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    private final SimpMessagingTemplate template;
    private final ChatMessageRepository repo;

    public ChatController(SimpMessagingTemplate template,
                          ChatMessageRepository repo) {
        this.template = template;
        this.repo = repo;
    }

    @MessageMapping("/chat.send")
    public void send(ChatMessage msg) {

        msg.setTimestamp(LocalDateTime.now());
        repo.save(msg);

        template.convertAndSendToUser(
                msg.getReceiverPhone(),
                "/queue/messages",
                msg
        );
    }
}