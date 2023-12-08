package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.SpecialThanks;
import com.soholighting.sohoTeam8.model.Sponsors;
import com.soholighting.sohoTeam8.service.SponsorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class SponsorController {
    @Autowired
    private SponsorsService sponsorsService;
    @GetMapping("/sponsors")
    public String showSponsors(Model model) {
        //get from database later
        // example data
        List<Sponsors> sponsors = sponsorsService.getAllSponsors();
       // List<SpecialThanks> specialThanksList = getSpecialThanks();
        // data to model
        model.addAttribute("sponsors", sponsors);
       // model.addAttribute("specialThanksList", specialThanksList);
        // return
        return "sponsors";
    }


}
