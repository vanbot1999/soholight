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
        ModelAndView modelAndView = new ModelAndView("redirect:/Adminlogin");
        return modelAndView;
    }

    @PostMapping("/home")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
        AdminAccount adminAccount = adminAccountService.login(username, password);
        System.out.println("fpx");
        if (adminAccount != null) {
            Cookie cookie = new Cookie("user", username);
            cookie.setMaxAge(7 * 24 * 60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);

            ModelAndView modelAndView = new ModelAndView("home");
            modelAndView.addObject("username", username);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("AdminLogin");
            modelAndView.addObject("error", "Invalid username or password");
            return modelAndView;
        }
    }
}
