package com.soholighting.sohoTeam8.controller;

import  com.soholighting.sohoTeam8.model.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FeedbackController {
    private final List<Feedback> feedbackList = new ArrayList<>();

    @GetMapping("/feedback")
    public String feedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        model.addAttribute("feedbackList", feedbackList);
        return "feedback";
    }

    @PostMapping("/feedback")
    public String submitFeedback(Feedback feedback, Model model) {
        if (feedback.getUsername() == null || feedback.getUsername().isEmpty()) {
            feedback.setUsername("Anonymous User");
        }
        feedbackList.add(feedback);
        return "redirect:/feedback";
    }
}
