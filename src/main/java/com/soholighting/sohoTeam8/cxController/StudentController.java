package com.soholighting.sohoTeam8.cxController;

import com.soholighting.sohoTeam8.cxService.KidsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class StudentController {
    @Autowired
    private KidsImageService kidsImageService;
    @RequestMapping("/kids")
    public List<com.soholighting.sohoTeam8.cxEnity.KidsImage> getStudent(){
        return kidsImageService.findAll();
    }


}
