package com.example.kurzwork.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home_controller {

    private final KaryselRepository karyselRepository;

    public home_controller(KaryselRepository karyselRepository) {
        this.karyselRepository = karyselRepository;
    }

    @GetMapping("/")
    public String getKarysel(Model model) {
        Iterable<Karysel> karysel = karyselRepository.findAll();
        model.addAttribute("karysel", karysel);
        //karyselRepository.save(new Karysel("1.jpg"));
        //karyselRepository.save(new Karysel("2.jpg"));
        //karyselRepository.save(new Karysel("3.jpg"));
        return "home";
    }
}
