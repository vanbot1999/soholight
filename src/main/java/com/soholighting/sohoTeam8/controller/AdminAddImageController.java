package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.exception.SohoLightingException;
import com.soholighting.sohoTeam8.model.KidsImage;
import com.soholighting.sohoTeam8.service.AdminAddImageService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author Enoch Ribin 23089855
 */
@RestController
public class AdminAddImageController {

    @Autowired
    private AdminAddImageService adminAddImageService;

    @GetMapping("/admin_addMotif")
    public ModelAndView addImageDetailsForm() {
        return new ModelAndView("addImage");
    }

    @SneakyThrows
    @PostMapping("addImage")
    public ResponseEntity<String> addImageDetails(@RequestParam Map<String, String> formData) {
        KidsImage kidsImage = new KidsImage(
                Integer.parseInt(formData.get("img_id")),
                formData.get("name"),
                Integer.parseInt(formData.get("age")),
                formData.get("description"),
                formData.get("url"),
                formData.get("sourceUrl"),
                formData.get("issueDate"));
        System.out.println(kidsImage);
        try {
            adminAddImageService.addImageDetails(kidsImage);
            return ResponseEntity.ok("success");
        } catch (SohoLightingException e) {
            return ResponseEntity.status(500).body("Database error");
        }

    }
}
