package com.java.real.chatController;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.real.chatEntity.UserPhone;
import com.java.real.chatRepository.UserPhoneRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginChatController {

    private final UserPhoneRepository repo;

    public LoginChatController(UserPhoneRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/loginChat")
    public String login(@RequestParam String phone,
                        HttpSession session,
                        Model model) {

        System.out.println("Login phone: " + phone);

        Optional<UserPhone> user = repo.findByPhoneNumber(phone);

        if (user == null) {
            model.addAttribute("error", "Phone number not registered");
            return "loginChat";
        }

        // ✅ store in session
        session.setAttribute("phone", phone);

        return "redirect:/chat";
    }
}