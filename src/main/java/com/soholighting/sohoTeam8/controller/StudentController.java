package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.service.KidsImageService;
import com.soholighting.sohoTeam8.model.KidsImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class StudentController {
    @Autowired
    private KidsImageService kidsImageService;
    @RequestMapping("/kids")
    public List<KidsImage> getStudent(){
        return kidsImageService.findAll();
    }


}
