package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.SpecialThanks;
import com.soholighting.sohoTeam8.model.Sponsors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class SponsorController {

    @GetMapping("/sponsors")
    public String showSponsors(Model model) {
        // 在这里添加你的业务逻辑，从数据库或其他来源获取数据
        // 示例数据
        List<Sponsors> sponsors = getSponsors();
        List<SpecialThanks> specialThanksList = getSpecialThanks();
        // 将数据传递到模板中
        model.addAttribute("sponsors", sponsors);
        model.addAttribute("specialThanksList", specialThanksList);
        // 返回Thymeleaf模板名称
        return "sponsors";
    }
    // 示例数据
    private List<Sponsors> getSponsors() {
        // 从数据库或其他来源获取赞助商数据
        // 这里使用一个简单的例子
        return Arrays.asList(
                new Sponsors("Sponsor1", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor2", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor3", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor4", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor5", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor6", "https://www.google.com", "logo.png"),
                new Sponsors("Sponsor7", "https://www.google.com", "logo.png")
                // 添加更多赞助商
        );
    }

    private List<SpecialThanks> getSpecialThanks() {
        // 从数据库或其他来源获取特别鸣谢数据
        // 这里使用一个简单的例子
        return Arrays.asList(
                new SpecialThanks("Special Thanks 1", "https://www.google.com", "logo1.png")
                // 添加更多特别鸣谢
        );
    }
}
