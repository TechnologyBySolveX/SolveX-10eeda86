package com.java.real.chatController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.real.chatEntity.ChatMessage;
import com.java.real.chatRepository.ChatMessageRepository;

@RestController
@RequestMapping("/chat")
public class ChatRestController {

    private final ChatMessageRepository repo;

    public ChatRestController(ChatMessageRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/history")
    public List<ChatMessage> getChatHistory(
            @RequestParam String sender,
            @RequestParam String receiver) {

        return repo.findBySenderPhoneAndReceiverPhone(sender, receiver);
    }
}