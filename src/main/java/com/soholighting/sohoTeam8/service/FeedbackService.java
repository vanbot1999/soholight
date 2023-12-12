package com.soholighting.sohoTeam8.service;

import org.springframework.stereotype.Service;
import com.soholighting.sohoTeam8.model.Feedback;
import com.soholighting.sohoTeam8.repository.FeedbackRepository;

import java.util.List;

// Service class for feedback
@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    // Constructor to autowire the FeedbackRepository
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
    // Method to insert new feedback, setting the username to 'Anonymous' if it's not provided
    public void insertFeedback(Feedback feedback) {
        if (feedback.getUsername() == null || feedback.getUsername().trim().isEmpty()) {
            feedback.setUsername("Anonymous");
        }
        feedbackRepository.save(feedback);
    }
    // Method to retrieve all feedbacks from the repository
    public List<Feedback> findAllFeedback() {
        return feedbackRepository.findAll();
    }
}
