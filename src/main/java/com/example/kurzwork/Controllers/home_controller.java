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
        //karyselRepository.save(new Karysel("https://avatars.mds.yandex.net/i?id=329a652c9e349faef992e77a18534d0bd8471613-8210080-images-thumbs&n=13"));
        //karyselRepository.save(new Karysel("https://avatars.mds.yandex.net/i?id=6b0bdad1c0d1bb319cf5b01716cd3b17b8300b1a-7552332-images-thumbs&n=13"));

        return "home";
    }
}
