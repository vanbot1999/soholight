package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.SpecialThanks;
import com.soholighting.sohoTeam8.model.Sponsors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

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
        return asList(
                new Sponsors("Sponsor1", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor2", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor3", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor4", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor5", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor6", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor7", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor8", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor9", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor10", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor11", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor12", "https://www.google.com", "logo.png")

                // add more
        );
    }
    private List<SpecialThanks> getSpecialThanks() {
        return asList(
                new SpecialThanks("SpecialThanks1", "https://www.google.com", "logo.png"),
                new SpecialThanks("SpecialThanks2", "https://www.google.com", "logo.png"),
                new SpecialThanks("SpecialThanks3", "https://www.google.com", "logo.png"),
                new SpecialThanks("SpecialThanks4", "https://www.google.com", "logo.png"),
                new SpecialThanks("SpecialThanks5", "https://www.google.com", "logo.png"),
                new SpecialThanks("SpecialThanks6", "https://www.google.com", "logo.png"),
                new SpecialThanks("SpecialThanks7", "https://www.google.com", "logo.png"),
                new SpecialThanks("SpecialThanks8", "https://www.google.com", "logo.png"),
                new SpecialThanks("SpecialThanks9", "https://www.google.com", "logo.png"),
                new SpecialThanks("SpecialThanks10", "https://www.google.com", "logo.png"),
                new SpecialThanks("SpecialThanks11", "https://www.google.com", "logo.png"),
                new SpecialThanks("SpecialThanks12", "https://www.google.com", "logo.png")



        );
    }
}
