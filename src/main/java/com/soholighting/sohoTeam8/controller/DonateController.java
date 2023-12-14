package com.soholighting.sohoTeam8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Enoch Ribin 23089855
 */

@RestController
public class DonateController {

    @GetMapping("/donate")
    public ModelAndView getDonatePage(){
        return new ModelAndView("donate");
    }


}
