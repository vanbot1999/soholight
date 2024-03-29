package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.exception.SohoLightingException;
import com.soholighting.sohoTeam8.model.User;
import com.soholighting.sohoTeam8.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Enoch Ribin 23089855
 */

@Controller
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService;

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @GetMapping("/register")
    public String registerUserForm() {
        return "registerUser";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        System.out.println(user);
        try {
            userRegistrationService.insertUser(user);
            return "redirect:/Adminlogin";
        } catch (SohoLightingException e) {
            ModelAndView registrationPage = new ModelAndView("registerUser");
            registrationPage.addObject("errorMsg", "Please try again.");
            return "redirect:/register";
        }
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("user") User user) throws SohoLightingException {
        userRegistrationService.deleteUser(user);
        return "redirect:/admin_userList";
    }

    @PutMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) throws SohoLightingException {
        userRegistrationService.updateUser(user);
        return "redirect:/admin_userList";
    }

    @GetMapping("/admin_userList")
    public ModelAndView getUserList() {
        ModelAndView userListMV = new ModelAndView("userList");
        userListMV.addObject("users", userRegistrationService.findAll());
        return userListMV;
    }

    @GetMapping("/admin_add_user")
    public String AdminAddUserForm() {
        return "adminAddUser";
    }

    @PostMapping("/admin_add_user")
    public String AdminAddUserForm(@ModelAttribute("user") User user) {
        try {
            userRegistrationService.insertUser(user);
            return "redirect:/admin_userList";
        } catch (SohoLightingException e) {
            ModelAndView registrationPage = new ModelAndView("adminAddUser");
            registrationPage.addObject("errorMsg", "Please try again.");
            return "adminAddUser";
        }
    }
}
