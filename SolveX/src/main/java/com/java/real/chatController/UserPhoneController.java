package com.java.real.chatController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.real.chatEntity.UserPhone;
import com.java.real.chatRepository.UserPhoneRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserPhoneController {

    private final UserPhoneRepository repo;

    public UserPhoneController(UserPhoneRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/signupChat")
    public String signupPage() {
        return "signupChat";
    }

    @PostMapping("/signupChat")
    public String register(@RequestParam String name,
                           @RequestParam String phone,
                           HttpSession session,
                           Model model) {
    	System.out.println("Calling the Sign Up Chat API URL ---");
    	System.out.println("NAME Is :"+name);
    	System.out.println("PHONE Is :"+phone);
    	

        // check already exists
        if (repo.findByPhoneNumber(phone) != null) {
            model.addAttribute("error", "Phone already registered");
            return "signupChat";
        }
        System.out.println("Before Seeting thhe name A nd Phone Number to the databases :");
        UserPhone user = new UserPhone();
        user.setName(name);
        user.setPhoneNumber(phone);
        user.setOnline(true);
        System.out.println("Before Saving to the Database ----");
        repo.save(user);

        // store session
        session.setAttribute("phone", phone);

        return "redirect:/chat";
    }
}