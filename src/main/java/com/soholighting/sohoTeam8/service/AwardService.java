package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.model.Award;
import com.soholighting.sohoTeam8.model.YearlyAwards;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AwardService {

    public List<YearlyAwards> getAllYearlyAwards() {
        List<Award> awards2021 = Arrays.asList(
                new Award("1", "Best Innovation 2021", "2021-01-01", "Description for Best Innovation 2021", "award.jpeg"),
                new Award("2", "Top Performer 2021", "2021-02-01", "Description for Top Performer 2021", "award.jpeg"),
                new Award("3", "Best Design 2021", "2021-03-01", "Description for Best Design 2021", "award.jpeg")
        );
        YearlyAwards yearlyAwards2021 = new YearlyAwards("2021", awards2021);

        List<Award> awards2022 = Arrays.asList(
                new Award("1", "Best Innovation 2022", "2022-01-01", "Description for Best Innovation 2022", "award.jpeg"),
                new Award("2", "Top Performer 2022", "2022-02-01", "Description for Top Performer 2022", "award.jpeg"),
                new Award("3", "Best Design 2022", "2022-03-01", "Description for Best Design 2022", "award.jpeg")
        );
        YearlyAwards yearlyAwards2022 = new YearlyAwards("2022", awards2022);

        List<Award> awards2023 = Arrays.asList(
                new Award("1", "Best Innovation 2023", "2023-01-01", "Description for Best Innovation 2023", "award.jpeg"),
                new Award("2", "Top Performer 2023", "2023-02-01", "Description for Top Performer 2023", "award.jpeg"),
                new Award("3", "Best Design 2023", "2023-03-01", "Description for Best Design 2023", "award.jpeg")
        );
        YearlyAwards yearlyAwards2023 = new YearlyAwards("2023", awards2023);

        return Arrays.asList(yearlyAwards2021, yearlyAwards2022, yearlyAwards2023);
    }
}
