package com.example.techtalk.controllers;

import com.example.techtalk.domain.Presentation;
import com.example.techtalk.domain.Review;
import com.example.techtalk.service.TechTalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import util.UserNameLdapUtil;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class IndexController implements ErrorController {

    @Autowired
    TechTalkService service;

    String userName;

    UserNameLdapUtil userNameLdapUtil = new UserNameLdapUtil();

    @RequestMapping("/")
    String index(Model model, Principal principal) {
        Long count = service.getCountPresentation();

        model.addAttribute("count", count);
        userName = userNameLdapUtil.getUserNameLdap();
        model.addAttribute("userName", userName);

        return "tthome";
    }

    @RequestMapping("/presentation")
    String getPresentations(Model model) {
        List<Presentation> presentations = service.getPresentations();
        List<Review> reviews = service.getReviews();
        Double avgRating = service.getAvgRating();

        model.addAttribute("presentations", presentations);
        model.addAttribute("reviews", reviews);
        model.addAttribute("rating", avgRating);
        return "infoSection/techTalk";
    }

    @RequestMapping("/comments/{id}")
    ResponseEntity getComments(@PathVariable("id") Long id) {
        List<Review> reviews = service.getReviewByPresentationId(id);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/presentation")
    String addPresentation(Presentation presentation, Model model) {
        presentation.setPresenter(userName);
        try {
            service.addPresentation(presentation);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "redirect:/";
    }



    @PostMapping("/review")
    String addReview(Review review, Model model) {
        review.setUser(userName);
        try {
            service.addReview(review);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "redirect:/";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
