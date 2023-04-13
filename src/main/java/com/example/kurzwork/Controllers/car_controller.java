package com.example.kurzwork.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class car_controller {

    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    @GetMapping("/car/{id}")
    public String carDetails(@PathVariable Long id, Model model) {
        Catalog catalog = catalogRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        model.addAttribute("car", catalog);
        List<Comments> comments = commentsRepository.findByCatalogId(id);
        model.addAttribute("comments", comments);
        return "car";
    }

    @PostMapping("/car/{id}/comment")
    public String addComment(@PathVariable Long id, @RequestParam String comment_text, Model model) {
        Catalog catalog = catalogRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        Comments comment = new Comments();
        comment.setCatalogId(catalog.getId());
        comment.setUsername("Anonymous");
        comment.setCommentText(comment_text);
        commentsRepository.save(comment);

        List<Comments> comments = commentsRepository.findByCatalogId(id);
        model.addAttribute("comments", comments);
        return "car :: comments-block";
    }
}