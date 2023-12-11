package com.soholighting.sohoTeam8.config;

import com.soholighting.sohoTeam8.repository.FeedbackRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FeedbackRepository feedbackRepository() {
        return new FeedbackRepository();
    }

}
