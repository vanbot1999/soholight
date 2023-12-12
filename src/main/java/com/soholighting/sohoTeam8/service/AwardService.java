package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.model.YearlyAwards;
import com.soholighting.sohoTeam8.repository.AwardRepository;
import com.soholighting.sohoTeam8.repository.YearlyAwardCategoryRepository;
import com.soholighting.sohoTeam8.repository.YearlyAwardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// Service class for handling award-related operations
@Service
public class AwardService {

    // Repository for accessing yearly awards data
    private final YearlyAwardsRepository yearlyAwardsRepository;
    // Repository for accessing yearly award categories
    private final YearlyAwardCategoryRepository yearlyAwardCategoryRepository;
    // Repository for accessing award data
    private final AwardRepository awardRepository;
    // Constructor to autowire the repositories
    @Autowired
    public AwardService(YearlyAwardsRepository yearlyAwardsRepository,
                        YearlyAwardCategoryRepository yearlyAwardCategoryRepository,
                        AwardRepository awardRepository) {
        this.yearlyAwardsRepository = yearlyAwardsRepository;
        this.yearlyAwardCategoryRepository = yearlyAwardCategoryRepository;
        this.awardRepository = awardRepository;
    }
    // Method to retrieve all yearly awards
    public List<YearlyAwards> getAllYearlyAwards() {
        // Fetching all yearly awards from the repository
        List<YearlyAwards> yearlyAwardsList = yearlyAwardsRepository.findAll();
        return yearlyAwardsList;
    }

}
