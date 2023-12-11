package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.YearlyAwards;
import com.soholighting.sohoTeam8.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private AwardService awardService;

    @GetMapping("/awards")
    public String awardsPage(Model model) {
        List<YearlyAwards> allYearlyAwards = awardService.getAllYearlyAwards();
        model.addAttribute("allYearlyAwards", allYearlyAwards);
        return "awards";
    }

    @GetMapping("/Adminlogin")
    public String adminlogin() {
        return "AdminLogin";
    }

    @GetMapping("/legacy")
    public String gotoLegacy() {
        return "legacy";
    }
}
