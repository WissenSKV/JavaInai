package com.example.kurzwork.Controllers;

import com.example.kurzwork.model.User;
import com.example.kurzwork.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register/page")
    public String registerPage() {
        return "register";
    }


    @PostMapping("/register")
    public String register(Model model, @RequestParam String username, @RequestParam String email, @RequestParam String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            model.addAttribute("error", "such username is busy!");
            return "register";
        }
        userRepository.save(new User(username, email, passwordEncoder.encode(password)));
        model.addAttribute("msg", "register success");
        return "register";
    }
}
