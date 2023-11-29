package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.model.Award;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AwardService {

    public List<Award> getAllAwards() {
        return Arrays.asList(
                new Award("1", "Best Innovation", "2021-01-01", "Award for the best innovative product of the year.", "image_url_1"),
                new Award("2", "Top Performer", "2021-02-01", "Award for outstanding performance.", "image_url_2"),
                new Award("3", "Best Design", "2021-03-01", "Award for the best design in the industry.", "image_url_3"));
    }
}
