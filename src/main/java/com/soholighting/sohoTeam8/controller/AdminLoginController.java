package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.AdminAccount;
import com.soholighting.sohoTeam8.service.AdminAccountService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
@RestController
public class AdminLoginController {

    @Autowired
    private AdminAccountService adminAccountService;
    @PostMapping("/logout")
    public ModelAndView logout(HttpServletResponse response) {
        System.out.println("ning");
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        ModelAndView modelAndView = new ModelAndView("/home");
        return modelAndView;
    }

    @PostMapping("/home")
    public ModelAndView login(@RequestParam String userId, @RequestParam String password, HttpServletResponse response) {
        try {
            List<AdminAccount> adminAccounts = adminAccountService.readUsersFromJson();
            for (AdminAccount adminAccount : adminAccounts) {
                if (adminAccount.getUserId().equals(userId) && adminAccount.getPassword().equals(password)) {

                    Cookie cookie = new Cookie("user", userId);
                    cookie.setMaxAge(7 * 24 * 60 * 60);
                    response.addCookie(cookie);


                    ModelAndView modelAndView = new ModelAndView("home");
                    modelAndView.addObject("userID", userId);
                    System.out.println("GG");
                    return modelAndView;
                }
            }

            ModelAndView modelAndView = new ModelAndView("AdminLogin");
            modelAndView.addObject("error", "Invalid username or password");
            return modelAndView;

        } catch (IOException e) {

            e.printStackTrace();


            ModelAndView errorModelAndView = new ModelAndView("error");
            errorModelAndView.addObject("error", "An error occurred while processing your request. Please try again later.");
            return errorModelAndView;
        }
    }
}
