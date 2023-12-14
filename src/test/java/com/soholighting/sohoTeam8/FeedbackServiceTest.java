package com.soholighting.sohoTeam8;

import com.soholighting.sohoTeam8.model.Feedback;
import com.soholighting.sohoTeam8.service.FeedbackService;
import com.soholighting.sohoTeam8.repository.FeedbackRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FeedbackServiceTest {

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private FeedbackService feedbackService;

    @Test
    void testInsertFeedback() {
        Feedback feedback = new Feedback("testuser", "test@email.com", "message");
        feedbackService.insertFeedback(feedback);

        verify(feedbackRepository).save(feedback);
    }
}
