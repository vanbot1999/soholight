package com.soholighting.sohoTeam8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.soholighting.sohoTeam8.model.Feedback;
import com.soholighting.sohoTeam8.service.FeedbackService;
import java.util.List;
// Controller class to manage feedback-related web requests
@Controller
public class FeedbackController {

    private final FeedbackService feedbackService;
    // Constructor to autowire the FeedbackService

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }
    // Method to display the feedback form and list of feedbacks
    @GetMapping("/feedback")
    public String showFeedbackForm(Model model) {
        // Add a new Feedback object to the model for form binding
        model.addAttribute("feedback", new Feedback());
        // Retrieve all feedbacks and add them to the model
        List<Feedback> feedbackList = feedbackService.findAllFeedback();
        model.addAttribute("feedbackList", feedbackList);
        // Return the feedback view name
        return "feedback";
    }
    // Method to handle the submission of feedback form
    @PostMapping("/feedback")
    public String submitFeedback(@ModelAttribute Feedback feedback) {
        // Insert the submitted feedback into the database
        feedbackService.insertFeedback(feedback);
        // Redirect to the feedback page
        return "redirect:/feedback";
    }
}
