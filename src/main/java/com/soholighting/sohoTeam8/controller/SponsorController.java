package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.SpecialThanks;
import com.soholighting.sohoTeam8.model.Sponsors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class SponsorController {

    @GetMapping("/sponsors")
    public String showSponsors(Model model) {
        //get from database later
        // example data
        List<Sponsors> sponsors = getSponsors();
        List<SpecialThanks> specialThanksList = getSpecialThanks();
        // data to model
        model.addAttribute("sponsors", sponsors);
        model.addAttribute("specialThanksList", specialThanksList);
        // return
        return "sponsors";
    }
    // 示例数据
    private List<Sponsors> getSponsors() {
        // get from database or other sources
        // example
        return Arrays.asList(
                new Sponsors("Sponsor1", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor2", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor3", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor4", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor5", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor6", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor7", "https://www.google.com", "logo.png")
                // add more
        );
    }

    private List<SpecialThanks> getSpecialThanks() {

        return Arrays.asList(
                new SpecialThanks("Special Thanks 1", "https://www.google.com", "logo1.png")

        );
    }
}
