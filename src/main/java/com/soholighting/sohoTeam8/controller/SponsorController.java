package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.SpecialThanks;
import com.soholighting.sohoTeam8.model.Sponsors;
import com.soholighting.sohoTeam8.service.SpecialThanksService;
import com.soholighting.sohoTeam8.service.SponsorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
