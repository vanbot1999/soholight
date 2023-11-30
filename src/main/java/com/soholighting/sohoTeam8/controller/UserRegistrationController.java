package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.User;
import com.soholighting.sohoTeam8.service.UserRegistrationService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Enoch Ribin 23089855
 */

@RestController
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @GetMapping("/register")
    public ModelAndView registerUserForm() {
        return new ModelAndView("registerUser");
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user){
        System.out.println(user);
        userRegistrationService.registerUser(user);
        return "redirect:/login";
    }
}
