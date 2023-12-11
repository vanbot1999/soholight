package com.soholighting.sohoTeam8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.soholighting.sohoTeam8.model.Feedback;
import com.soholighting.sohoTeam8.service.FeedbackService;
import java.util.List;

@Controller
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/feedback")
    public String showFeedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        List<Feedback> feedbackList = feedbackService.findAllFeedback();
        model.addAttribute("feedbackList", feedbackList);
        return "feedback";
    }

    @PostMapping("/feedback")
    public String submitFeedback(@ModelAttribute Feedback feedback) {
        feedbackService.insertFeedback(feedback);
        return "redirect:/feedback";
    }
}
