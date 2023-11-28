package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.Award;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/awards")
public class AwardApiController {

    @GetMapping
    public List<Award> getAwards() {
        return Arrays.asList(
                new Award("1","Name", "Date", "Description"),
                new Award("2","2022", "2022-01-01", "Awarded for 2022."),
                new Award("3","2023", "2023-01-01", "Awarded for 2023.")
        );
    }
}
