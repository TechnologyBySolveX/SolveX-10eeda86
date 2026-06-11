package com.java.real.chatController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.real.chatEntity.UserPhone;
import com.java.real.chatRepository.UserPhoneRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ChatPageController {

    private final UserPhoneRepository repo;

    public ChatPageController(UserPhoneRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/chat")
    public String chatPage() {
        return "chat";
    }

    @GetMapping("/startChat")
    public String startChat(@RequestParam String phone,
                            HttpSession session,
                            Model model) {
    	System.out.println("Receiver phone Number is : "+phone);
        UserPhone receiver = repo.findByPhoneNumber(phone);

        if (receiver == null) {
            model.addAttribute("error", "User not found");
            return "chat";
        }

        String sender = (String) session.getAttribute("phone");

        model.addAttribute("sender", sender);
        model.addAttribute("receiver", phone);

        return "chatBox";
    }
}