package com.soholighting.sohoTeam8.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/SohoXmasKidsLights")
    public String home(Model model) {
        model.addAttribute("message", "Welcome!");
        return "home";
    }
}

