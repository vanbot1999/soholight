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
    // This method will be called by Spring to create and manage the FeedbackRepository instance
    public FeedbackRepository feedbackRepository() {
        return new FeedbackRepository();
    }
    // It requires a DataSource and YearlyAwardCategoryRepository as dependencies
    public YearlyAwardsRepository yearlyAwardsRepository(DataSource dataSource, YearlyAwardCategoryRepository yearlyAwardCategoryRepository) {
        return new YearlyAwardsRepository(dataSource, yearlyAwardCategoryRepository);
    }
    // It requires a DataSource and AwardRepository as dependencies
    public YearlyAwardCategoryRepository yearlyAwardCategoryRepository(DataSource dataSource, AwardRepository awardRepository) {
        return new YearlyAwardCategoryRepository(dataSource, awardRepository);
    }
    // It requires a DataSource as a dependency
    // DataSource is used for database connectivity and operations related to the Award entity
    public AwardRepository awardRepository(DataSource dataSource) {
        return new AwardRepository(dataSource);
    }
}
