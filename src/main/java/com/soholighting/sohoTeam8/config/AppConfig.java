package com.soholighting.sohoTeam8.config;

import com.soholighting.sohoTeam8.repository.AwardCategoryRepository;
import com.soholighting.sohoTeam8.repository.AwardRepository;
import com.soholighting.sohoTeam8.repository.FeedbackRepository;
import com.soholighting.sohoTeam8.repository.YearlyAwardsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FeedbackRepository feedbackRepository() {
        return new FeedbackRepository();
    }
    @Bean
    public AwardCategoryRepository awardCategoryRepository() {
        return new AwardCategoryRepository();
    }

    @Bean
    public AwardRepository awardRepository() {
        return new AwardRepository();
    }

    @Bean
    public YearlyAwardsRepository yearlyAwardsRepository() { return new YearlyAwardsRepository(); }
}
