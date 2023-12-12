package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.model.YearlyAwards;
import com.soholighting.sohoTeam8.repository.AwardRepository;
import com.soholighting.sohoTeam8.repository.YearlyAwardCategoryRepository;
import com.soholighting.sohoTeam8.repository.YearlyAwardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardService {

    private final YearlyAwardsRepository yearlyAwardsRepository;
    private final YearlyAwardCategoryRepository yearlyAwardCategoryRepository;
    private final AwardRepository awardRepository;

    @Autowired
    public AwardService(YearlyAwardsRepository yearlyAwardsRepository,
                        YearlyAwardCategoryRepository yearlyAwardCategoryRepository,
                        AwardRepository awardRepository) {
        this.yearlyAwardsRepository = yearlyAwardsRepository;
        this.yearlyAwardCategoryRepository = yearlyAwardCategoryRepository;
        this.awardRepository = awardRepository;
    }

    public List<YearlyAwards> getAllYearlyAwards() {
        List<YearlyAwards> yearlyAwardsList = yearlyAwardsRepository.findAll();
        return yearlyAwardsList;
    }

}
