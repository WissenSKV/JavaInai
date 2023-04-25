package com.example.kurzwork.Controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
@Controller
public class car_controller {

    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    @GetMapping("/car/{id}")
    public String carDetails(@PathVariable Long id, Model model) {
        Catalog catalog = catalogRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        List<Comments> comments = commentsRepository.findByCatalogId(id);
        Collections.reverse(comments);
        model.addAttribute("car", catalog);
        model.addAttribute("comments", comments);
        return "car";
    }


    @PostMapping("/car/{id}/comment")
    public RedirectView addComment(@PathVariable Long id, @RequestParam String comment_text, Model model) {
        Catalog catalog = catalogRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        Comments comment = new Comments();
        comment.setCatalogId(catalog.getId());
        comment.setUsername("Anonymous");
        comment.setCommentText(comment_text);
        comment.setDateTime(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM. d, yyyy, h:mm a", Locale.ENGLISH);
        String formattedDate = comment.getDateTime().format(formatter);
        comment.setDateTimeFormatted(formattedDate);
        commentsRepository.save(comment);
        return new RedirectView("/car/" + id);
    }


}