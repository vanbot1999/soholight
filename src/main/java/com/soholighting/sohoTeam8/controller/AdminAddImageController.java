package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.KidsImage;
import com.soholighting.sohoTeam8.model.User;
import com.soholighting.sohoTeam8.service.AdminAddImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Enoch Ribin 23089855
 */
@RestController
public class AdminAddImageController {

    @Autowired
    private AdminAddImageService adminAddImageService;

    @GetMapping("/admin/addImage")
    public ModelAndView addImageDetailsForm() {
        return new ModelAndView("addImage");
    }

    @PostMapping("/admin/addImage")
    public ResponseEntity<String> addImageDetails(@ModelAttribute("kidsImage") KidsImage kidsImage) {
        System.out.println(kidsImage);
        adminAddImageService.addImageDetails(kidsImage);
        return ResponseEntity.ok("success");
    }
}
