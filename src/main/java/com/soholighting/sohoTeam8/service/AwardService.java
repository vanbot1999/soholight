package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.model.Award;
import com.soholighting.sohoTeam8.model.YearlyAwardCategory;
import com.soholighting.sohoTeam8.model.YearlyAwards;
import com.soholighting.sohoTeam8.repository.YearlyAwardsRepository;
import com.soholighting.sohoTeam8.repository.AwardCategoryRepository;
import com.soholighting.sohoTeam8.repository.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardService {

    @Autowired
    private YearlyAwardsRepository yearlyAwardsRepository;

    @Autowired
    private AwardCategoryRepository awardCategoryRepository;

    @Autowired
    private AwardRepository awardRepository;

    public List<YearlyAwards> getAllYearlyAwards() {
        return yearlyAwardsRepository.findAll();
    }
    public List<YearlyAwardCategory> getAllAwardCategories() {
        return awardCategoryRepository.findAll();
    }
    public List<Award> getAllAwards() {
        return awardRepository.findAll();
    }
}
