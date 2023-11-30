package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.model.Award;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AwardService {

    public List<Award> getAllAwards() {
        return Arrays.asList(
                new Award("1", "2021", "2021-01-01", "description text here", "image_url_1"),
                new Award("2", "2022", "2022-02-01", "description text here", "image_url_2"),
                new Award("3", "2023", "2023-03-01", "description text here", "image_url_3"));
    }
}
