package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.SpecialThanks;
import com.soholighting.sohoTeam8.model.Sponsors;
import com.soholighting.sohoTeam8.repository.SponsorRepository;
import com.soholighting.sohoTeam8.service.SpecialThanksService;
import com.soholighting.sohoTeam8.service.SponsorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;



@Controller
public class SponsorController {
    @Autowired
    private SponsorsService sponsorsService;
    @Autowired
    private SpecialThanksService specialThanksService;
    @GetMapping("/sponsors")
    public String showSponsors(Model model) {
        //get from database later
        // example data
        List<Sponsors> sponsors = sponsorsService.getAllSponsors();
        List<SpecialThanks> specialThanks= specialThanksService.getAllSpecialThanks();
        // data to model
        model.addAttribute("sponsors", sponsors);
        model.addAttribute("specialThanks", specialThanks);
        // return
        return "sponsors";
    }
    @GetMapping("/fetch-sponsorship-amounts")
    @ResponseBody
    public int[] fetchSponsorshipAmounts() {
        // 返回一个整型数组，或者将你的数据转换成 int[] 类型
        return new int[]{62000, 43000, 60000};
    }
    static class SponsorshipAmountResponse {
        private int[] amounts;

        public SponsorshipAmountResponse(int[] amounts) {
            this.amounts = amounts;
        }

        public int[] getAmounts() {
            return amounts;
        }

        public void setAmounts(int[] amounts) {
            this.amounts = amounts;
        }
    }
    private final SponsorRepository sponsorRepository;
    private static final Logger logger = LoggerFactory.getLogger(SponsorController.class);

    public SponsorController(SponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }

    @GetMapping("/insertSponsor")
    public String showInsertSponsorForm(Model model) {
        logger.info("Fetching all sponsors...");
        List<Sponsors> allSponsors = sponsorRepository.findAllSponsors();
        logger.info("Fetched {} sponsors", allSponsors.size());
        model.addAttribute("newSponsor", new Sponsors());
        model.addAttribute("allSponsors", allSponsors);
        return "insertSponsor";
    }

    @PostMapping("/insertSponsor")
    public String insertSponsor(@ModelAttribute Sponsors newSponsor) {
        sponsorRepository.insertSponsor(newSponsor);
        return "redirect:/sponsors";
    }
    @PostMapping("/removeSponsor")
    public String removeSponsorByName(@RequestParam String name) {
        // Add logic to remove sponsor by name
        sponsorRepository.removeSponsorByName(name);
        return "redirect:/insertSponsor";
    }
}
