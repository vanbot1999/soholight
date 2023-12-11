package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.mapper.FeedbackMapper;
import com.soholighting.sohoTeam8.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Enoch Ribin 23089855
 */
@Service
public class FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    public List<Feedback> findAllFeedback() {
        return feedbackMapper.findAllFeedbacks();
    }

    public void insertFeedback(Feedback feedback) {
        feedbackMapper.insertFeedback(feedback);
    }
}
