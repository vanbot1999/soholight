package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.Award;
import com.soholighting.sohoTeam8.service.AwardService; // 确保引入你的AwardService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private AwardService awardService; // 自动注入AwardService

    @GetMapping("/awards")
    public String awardsPage(Model model) {
        List<Award> awards = awardService.getAllAwards(); // 从AwardService获取奖项数据
        model.addAttribute("awards", awards); // 将奖项数据添加到模型中
        return "awards";
    }

    @GetMapping("/Adminlogin")
    public String adminlogin() {
        return "AdminLogin";
    }
}
