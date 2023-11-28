package com.soholighting.sohoTeam8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SponsorController {
    @GetMapping
    public String sponsorPage() {
        return "sponsors";
    }

}
