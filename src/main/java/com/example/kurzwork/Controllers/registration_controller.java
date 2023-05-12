package com.example.kurzwork.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class registration_controller {
    @GetMapping("/registration")
    public String registration(Model model) {
        return "register";
    }
}
