package com.soholighting.sohoTeam8.controller;

import  com.soholighting.sohoTeam8.model.Feedback;
import com.soholighting.sohoTeam8.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedback")
    public String feedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        model.addAttribute("feedbackList", feedbackService.findAllFeedback());
        return "feedback";
    }

    @PostMapping("/feedback")
    public String submitFeedback(Feedback feedback) {
        System.out.println(feedback);
        feedbackService.insertFeedback(feedback);
        return "redirect:/feedback";
    }
}
