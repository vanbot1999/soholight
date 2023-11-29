package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Enoch Ribin 23089855
 */

@RestController
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @GetMapping("/joinUs")
    public ModelAndView registerUser() {
        return new ModelAndView("registerUser");
    }
    
}
