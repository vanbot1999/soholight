package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.Award;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

    @GetMapping("/awards")
    public String awardsPage() {
        return "awards";
    }

    @GetMapping("/award-details/{id}")
    public String awardDetails(@PathVariable String id, Model model) {
        Award award = findAwardById(id);
        model.addAttribute("award", award);

        return "awardDetails";
    }
    @GetMapping("/Adminlogin")
    public String adminlogin() {
   

        return "AdminLogin";
    }
    private Award findAwardById(String id) {
        return new Award(id, "Award", "date", "Description of the award");
    }

}
