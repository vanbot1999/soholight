package com.soholighting.sohoTeam8.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soholighting.sohoTeam8.model.KidsImage;
import com.soholighting.sohoTeam8.model.User;
import com.soholighting.sohoTeam8.service.AdminAddImageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<String> addImageDetails(@RequestBody String jsonBody) {
        try {
            KidsImage kidsImage = new ObjectMapper().readValue(jsonBody,KidsImage.class);
            System.out.println(kidsImage);
            adminAddImageService.addImageDetails(kidsImage);
            return ResponseEntity.ok("success");
        } catch (JsonProcessingException e) {
            return ResponseEntity.ok("error");
        }

    }
}
