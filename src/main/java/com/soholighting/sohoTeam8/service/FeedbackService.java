package com.soholighting.sohoTeam8.service;
import org.springframework.stereotype.Service;
import com.soholighting.sohoTeam8.model.Feedback;
import com.soholighting.sohoTeam8.repository.FeedbackRepository;
import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void insertFeedback(Feedback feedback) {
        if (feedback.getUsername() == null || feedback.getUsername().trim().isEmpty()) {
            feedback.setUsername("Anonymous");
        }
        feedbackRepository.save(feedback);
    }

    public List<Feedback> findAllFeedback() {
        return feedbackRepository.findAll();
    }
}
