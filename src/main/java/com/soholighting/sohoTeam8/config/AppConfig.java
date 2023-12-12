package com.soholighting.sohoTeam8.config;

import com.soholighting.sohoTeam8.repository.AwardRepository;
import com.soholighting.sohoTeam8.repository.FeedbackRepository;
import com.soholighting.sohoTeam8.repository.YearlyAwardCategoryRepository;
import com.soholighting.sohoTeam8.repository.YearlyAwardsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public FeedbackRepository feedbackRepository() {
        return new FeedbackRepository();
    }
    public YearlyAwardsRepository yearlyAwardsRepository(DataSource dataSource, YearlyAwardCategoryRepository yearlyAwardCategoryRepository) {
        return new YearlyAwardsRepository(dataSource, yearlyAwardCategoryRepository);
    }

    public YearlyAwardCategoryRepository yearlyAwardCategoryRepository(DataSource dataSource, AwardRepository awardRepository) {
        return new YearlyAwardCategoryRepository(dataSource, awardRepository);
    }

    public AwardRepository awardRepository(DataSource dataSource) {
        return new AwardRepository(dataSource);
    }
}
