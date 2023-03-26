package com.example.kurzwork.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class car_controller {

    @Autowired
    private CatalogRepository catalogRepository;

    @GetMapping("/car/{id}")
    public String carDetails(@PathVariable Long id, Model model) {
        Catalog catalog = catalogRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        model.addAttribute("car", catalog);
        return "car";
    }
}

